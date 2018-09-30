/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.samples.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.geercode.creed.samples.entity.Bank;
import com.geercode.creed.samples.repo.es.BankEsDao;
import com.geercode.creed.samples.service.BankService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.common.lucene.search.function.FiltersFunctionScoreQuery.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>Description : BankServiceImpl</p>
 * <p>Created on  : 2018-09-29 15:58</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Component
@Slf4j
public class BankServiceImpl implements BankService {
    @Autowired
    private BankEsDao bankEsDao;
    @Autowired
    private TransportClient client;

    @Override
    public String add(Bank bank){
        bankEsDao.save(bank);
        return "success";
    }
    @Override
    public String delete(Long id){
        bankEsDao.deleteById(id);
        return "success";
    }
    @Override
    public String update(Long id){
        Optional<Bank> bankOp = bankEsDao.findById(id);
        Bank bank = bankOp.get();
        bank.setCode("123");
        bankEsDao.save(bank);
        return "success";
    }


    /**
     * <p>description : query</p>
     * <p>create   on : 2018-09-30 12:11:40</p>
     *
     * 1.总行名称起决定性作用
     * 2.权重分数第一名与第二名差距大则选用第一个
     * 3.结果错误直接填空值
     *
     * 注意：查询的文本字段必需在索引设置里设置fielddata为true, painless脚本有特别的使用用法, 是groovy的一个子集
     * 通过调整字段与过滤打分规则去调整分值排序, 调整分数间隔常数来控制是否有多个结果
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @SneakyThrows
    @Override
    public String query(String searchContent){
        ObjectMapper ob = new ObjectMapper();
        //允许序列化空POJO
        ob.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //把时间按照字符串输出
        ob.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //POJO中的null值不输出
        ob.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //在遇到未知属性的时候不抛出异常
        ob.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        /**************/
        //1.配置操作
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.multiMatchQuery(searchContent, "name"));

        //字典参数
        List briefBankList = Arrays.asList("工商银行","农业银行","中国银行","建设银行","招商银行");
        List briefLocationList = Arrays.asList("上海", "北京");
        Map<String, Object> params = new HashMap<>();
        params.put("briefBankList", briefBankList);
        params.put("briefLocationList", briefLocationList);

        //脚本
        String scriptStr = "String bankName = doc['name.keyword'].value;boolean bankFlag = false;for (String briefBank : params.briefBankList) {if (bankName.contains(briefBank)) {bankFlag = true;break;}}if (!bankFlag) {return 0;}boolean locationFlag = false;for (String location : params.briefLocationList) {if (bankName.contains(location)) {locationFlag = true;break;}}if (!locationFlag) {return 0;}return 1;";
        Script script = new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptStr, params);

        //多个计分函数
        FilterFunctionBuilder[] filterFunctionBuilders = new FilterFunctionBuilder[]{
                new FilterFunctionBuilder(ScoreFunctionBuilders.scriptFunction(script))
                };
        FunctionScoreQueryBuilder functionScoreQuery = QueryBuilders.functionScoreQuery(boolQueryBuilder, filterFunctionBuilders)
                .scoreMode(ScoreMode.MULTIPLY)
                .boostMode(CombineFunction.MULTIPLY);

        //2.构建操作
        SearchRequestBuilder requestBuilder = client.prepareSearch("architect").setTypes("bank")
                .setQuery(functionScoreQuery);

        SearchResponse response = requestBuilder
                .addSort(SortBuilders.scoreSort().order(SortOrder.DESC))
                .setMinScore(0.01f)
                .setFrom(0).setSize(10)
                .execute().actionGet();

        log.info("==========");
        log.info(ob.writerWithDefaultPrettyPrinter().writeValueAsString(response));

        SearchHit[] hitList = response.getHits().getHits();
        //Arrays.sort(hitList, (hitB, hitA) -> (hitA.getScore() < hitB.getScore()) ? -1 : ((hitA.getScore() == hitB.getScore()) ? 0 : 1));

        /*for (SearchHit hit : hitList) {
            log.info(hit.getSourceAsString() + "  -----------  " + hit.getScore());
        }*/

        if (hitList.length == 0) {
            log.info("No Possible Value");
        } else {
            log.info("Guess Value is    >" + hitList[0].getSourceAsString() + "  -----------  " + hitList[0].getScore());
            if (hitList.length > 1) {
                for (int i = 0; i < hitList.length - 1; i++) {
                    if (isPossibleValue(hitList[i].getScore(), hitList[i + 1].getScore(), 0.1f)) {
                        log.info("Possible Value is >" + hitList[i + 1].getSourceAsString() + "  -----------  " + hitList[i + 1].getScore());
                    } else {
                        break;
                    }
                }
            }
        }
        return ob.writeValueAsString(response);
    }

    private boolean isPossibleValue(float f1, float f2, float limit) {
        BigDecimal b1 = BigDecimal.valueOf(f1);
        BigDecimal b2 = BigDecimal.valueOf(f2);
        BigDecimal dValue = b1.subtract(b2);
        double similarValue = dValue.divide(b1, 6, RoundingMode.CEILING).doubleValue();
        if (similarValue < limit) {
            return true;
        }
        return false;
    }
}
