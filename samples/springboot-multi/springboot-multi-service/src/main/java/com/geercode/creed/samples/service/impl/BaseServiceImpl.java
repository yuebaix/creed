/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geercode.creed.samples.service.BaseService;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : 基础service实现类</p>
 * <p>Created on  : 2018-09-10 15:32</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SqlSessionTemplate sqlSession;

    /**
     * 根据自定义语句查询数据
     *
     * @param myBatisSqlId mapper.xml中sqlId
     * @param conditions 条件参数
     * @return java.lang.Object 数据实体
     */
    @Override
    public Object getObjectBySqlId(String myBatisSqlId, Object conditions) {
        String model = getModel();
        String statement = "" + model + "Mapper." + myBatisSqlId;
        Object object = sqlSession.selectOne(statement, conditions);
        return object;
    }

    /**
     * 根据 sqlid 查询数据返回单个数据
     *
     * @param myBatisSqlId mapper.xml中sqlId
     * @param conditions 条件参数
     * @return java.util.List 数据实体列表
     */
    @Override
    public List getListBySqlId(String myBatisSqlId, Object conditions) {
        String model = getModel();
        logger.info(" this service class is {}", this.getClass().toString());
        String statement = "" + model + "Mapper." + myBatisSqlId;
        List list = sqlSession.selectList(statement, conditions);
        return list;
    }

    /**
     * 根据自定义语句查询数据
     *
     * @param querySqlId 查询语句sqlId
     * @param countSqlId 查询总记录数语句sqlId
     * @param param 条件参数
     * @param pageSize 每页大小
     * @param currentPage 查询当前页
     * @return com.baomidou.mybatisplus.core.metadata.IPage 数据实体分页
     */
    @Override
    public IPage<Object> queryPageBySqlId(String querySqlId, String countSqlId, Map<String, Object> param,
            Long pageSize, Long currentPage) {
        String model = getModel();
        List<Object> list = null;
        String statement = "" + model + "Dao." + countSqlId;
        Long totalSize = sqlSession.selectOne(statement, param);
        IPage<Object> page = new Page<>(currentPage, pageSize, totalSize);
        Long pageStart = Long.parseLong((page.getCurrent() - 1) * pageSize + "");
        param.put("startRow", pageStart);
        param.put("endRow", pageSize);
        statement = "" + model + "Dao." + querySqlId;
        list = sqlSession.selectList(statement, param);
        page.setRecords(list);
        return page;
    }

    private String getModel() {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
        String paths = entityClass.toString();
        String model = paths.substring(paths.lastIndexOf(".") + 1, paths.length());
        return model;
    }
}
