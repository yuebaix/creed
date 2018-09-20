/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.geercode.creed.samples.web.common.SystemConstant;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * <p>Description : MybatisPlusConfig</p>
 * <p>Created on  : 2018-09-10 18:56</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@MapperScan("com.geercode.creed.samples.repo.dao")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * <p>description : 只在开发环境中开启的性能插件</p>
     * <p>create   on : 2018-09-20 19:55:10</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @Bean
    @Profile(SystemConstant.PROFILE_DEV)
    public PerformanceInterceptor performanceInterceptor() {
        Properties props = new Properties();
        props.put("maxTime", "2000");
        props.put("format", "true");
        PerformanceInterceptor interceptor = new PerformanceInterceptor();
        interceptor.setProperties(props);
        return interceptor;
    }

    /**
     * <p>description : 只在开发环境中开启的sql执行插件</p>
     * <p>create   on : 2018-09-20 19:55:27</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @Bean
    @Profile(SystemConstant.PROFILE_DEV)
    public SqlExplainInterceptor explainInterceptor() {
        Properties props = new Properties();
        props.put("stopProceed", "false");
        SqlExplainInterceptor interceptor = new SqlExplainInterceptor();
        interceptor.setProperties(props);
        return interceptor;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandlerSub();
    }

    private static class MetaObjectHandlerSub implements MetaObjectHandler {
        private static final String SYSTEM_ID = "SYSTEM";

        @Override
        public void insertFill(MetaObject metaObject) {
            LocalDateTime nower = LocalDateTime.now();
            setFieldValByName("creatorId", SYSTEM_ID, metaObject);
            setFieldValByName("createTime", nower, metaObject);
            setFieldValByName("updaterId", SYSTEM_ID, metaObject);
            setFieldValByName("updateTime", nower, metaObject);
        }

        @Override
        public void updateFill(MetaObject metaObject) {
            LocalDateTime nower = LocalDateTime.now();
            setFieldValByName("updaterId", SYSTEM_ID, metaObject);
            setFieldValByName("updateTime", nower, metaObject);
        }
    }
}
