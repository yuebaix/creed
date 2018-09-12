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

package com.geercode.creed.archetype.orm.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : Creed MybatisPlus Generator</p>
 * <p>Created on  : 2018-09-11 14:59</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class MpgImpl implements Mpg {
    private volatile static Mpg holder;
    private static final char[] HOLDER_MONITOR = new char[0];

    private GlobalConfig globalConfig = new GlobalConfig();
    private DataSourceConfig dataSourceConfig = new DataSourceConfig();
    private StrategyConfig strategyConfig = new StrategyConfig();
    private PackageConfig packageConfig = new PackageConfig();
    private TemplateConfig templateConfig = new TemplateConfig();

    private AutoGenerator mpg = new AutoGenerator();

    private MpgImpl() {
        configMpg();
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-09-11 16:14:53</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static Mpg getHolder() {
        if (holder == null) {
            synchronized (HOLDER_MONITOR) {
                if (holder == null) {
                    holder = new MpgImpl();
                }
            }
        }
        return holder;
    }

    @Override
    public void genBase() {

    }

    @Override
    public void genXml() {

    }

    @Override
    public void genMapper() {

    }

    @Override
    public void genEntity() {

    }

    @Override
    public void genService() {

    }

    @Override
    public void genAll() {
        strategyConfig.setInclude("t_proxy");
        //加载配置并执行
        mpg.execute();
    }

    private void configMpg() {
        //从配置文件读取配置
        MultiModulePathConfig pathConfig = new MultiModulePathConfig().init();
        //加载默认配置
        globalConfig = new GlobalConfig()
                .setOutputDir(pathConfig.getRootArtifactDir())
                .setFileOverride(false)
                .setActiveRecord(true)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setAuthor(pathConfig.getAuthor())
                .setEntityName("%sEntity")
                .setMapperName("%sDAO")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl");
        dataSourceConfig = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName(pathConfig.getDatabaseDriver())
                .setUrl(pathConfig.getDatabaseUrl())
                .setUsername(pathConfig.getDatabaseUser())
                .setPassword(pathConfig.getDatabasePassword());
        strategyConfig = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .entityTableFieldAnnotationEnable(true)
                .setEntityLombokModel(true);
        packageConfig = new PackageConfig()
                .setParent(pathConfig.getPkg())
                .setEntity("repo.dao.entity")
                .setMapper("repo.dao.mapper")
                .setXml("repo.dao.xml")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("web.controller");
        //关闭所有默认模板生成
        templateConfig = new TemplateConfig()
                .setEntity(null)
                .setMapper(null)
                .setXml(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(null);
        mpg.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplate(templateConfig)
                .setCfg(getInjectionConfig(pathConfig));
    }

    /**
     * 修改代码模板与生成路径
     */
    private InjectionConfig getInjectionConfig(MultiModulePathConfig pathConfig) {
        List<FileOutConfig> fileOutConfigList = Arrays.asList(
                new FileOutConfig("/creed.entity.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getEntityDir() + File.separator + tableInfo.getEntityName()
                                + StringPool.DOT_JAVA;
                    }
                },
                new FileOutConfig("/creed.dao.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getDaoDir() + File.separator + tableInfo.getMapperName()
                                + StringPool.DOT_JAVA;
                    }
                },
                new FileOutConfig("/creed.mapper.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getMapperDir() + File.separator + tableInfo.getXmlName()
                                + StringPool.DOT_XML;
                    }
                },
                new FileOutConfig("/creed.service.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getServiceDir() + File.separator + tableInfo.getServiceName()
                                + StringPool.DOT_JAVA;
                    }
                },
                new FileOutConfig("/creed.serviceimpl.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getServiceImplDir() + File.separator + tableInfo.getServiceImplName()
                                + StringPool.DOT_JAVA;
                    }
                },
                new FileOutConfig("/creed.controller.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getControllerDir() + File.separator + tableInfo.getControllerName()
                                + StringPool.DOT_JAVA;
                    }
                }
        );
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(1);
                map.put("header", pathConfig.getHeader());
                this.setMap(map);
            }
        }.setFileOutConfigList(fileOutConfigList);
    }
}
