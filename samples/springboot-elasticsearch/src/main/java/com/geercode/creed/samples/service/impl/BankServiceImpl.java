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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geercode.creed.samples.entity.Bank;
import com.geercode.creed.samples.repo.es.BankEsDao;
import com.geercode.creed.samples.service.BankService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.util.List;
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
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public String add(){
        Bank bank=new Bank();
        bank.setName("工商銀行");
        bank.setCode("0001");
        bank.setAddress("上海徐匯");
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

    @SneakyThrows
    @Override
    public String query(String searchContent){
        Optional<Bank> bankOp = bankEsDao.findById(1L);
        Bank bank = bankOp.get();
        String result = new ObjectMapper().writeValueAsString(bank);

        List<Bank> bankList = bankEsDao.findByNameLike(searchContent);
        log.info(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(bankList));

        Bank bank2 = new Bank();
        bank2.setName("工商");
        Page<Bank> bankList3 = bankEsDao.searchSimilar(bank2, new String[]{"name"}, PageRequest.of(0, 10));
        log.info("==========");
        log.info(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(bankList3));

        /**************/
        //1.配置操作
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.wildcardQuery("name", "*工*"));
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", "中国工商银行"));

        FilterFunctionBuilder[] filterFunctionBuilders = new FilterFunctionBuilder[]{
                new FilterFunctionBuilder(
                        ScoreFunctionBuilders.weightFactorFunction(2))
                };

        FunctionScoreQueryBuilder functionScoreQuery = QueryBuilders.functionScoreQuery(boolQueryBuilder, filterFunctionBuilders)
                .boostMode(CombineFunction.SUM);

        //2.构建操作
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(functionScoreQuery)
                .withPageable(PageRequest.of(0, 10))
                .build();

        Page<Bank> bankList2 = bankEsDao.search(query);
        log.info("==========");
        log.info(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(bankList2));
        return result;
    }
}
