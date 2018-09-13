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
import java.util.ArrayList;
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

    private MultiModulePathConfig pathConfig = new MultiModulePathConfig();

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
        strategyConfig.setInclude("t_proxy");

        //加载配置并执行
        mpg.setCfg(getInjectionConfig(manipulateFileOutConfig(new String[] {"base"})));
        mpg.execute();
    }

    @Override
    public void genXml() {
        strategyConfig.setInclude("t_proxy");

        //加载配置并执行
        mpg.setCfg(getInjectionConfig(manipulateFileOutConfig(new String[] {"xml"})));
        mpg.execute();
    }

    @Override
    public void genDao() {
        strategyConfig.setInclude("t_proxy");

        //加载配置并执行
        mpg.setCfg(getInjectionConfig(manipulateFileOutConfig(new String[] {"dao"})));
        mpg.execute();
    }

    @Override
    public void genService() {
        strategyConfig.setInclude("t_proxy");

        //加载配置并执行
        mpg.setCfg(getInjectionConfig(manipulateFileOutConfig(new String[] {"service"})));
        mpg.execute();
    }

    @Override
    public void genWeb() {
        strategyConfig.setInclude("t_proxy");

        //加载配置并执行
        mpg.setCfg(getInjectionConfig(manipulateFileOutConfig(new String[] {"web"})));
        mpg.execute();
    }

    @Override
    public void genAll() {
        strategyConfig.setInclude("t_proxy");

        //加载配置并执行
        mpg.setCfg(getInjectionConfig(manipulateFileOutConfig(new String[] {
                "base", "dao", "xml", "service", "web"})));
        mpg.execute();
    }

    private void configMpg() {
        pathConfig.init();
        //从配置文件读取配置
        globalConfig = new GlobalConfig()
                .setOutputDir(pathConfig.getRootArtifactDir())
                .setFileOverride(true)
                .setActiveRecord(true)
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setAuthor(pathConfig.getAuthor())
                .setSwagger2(true)
                .setEntityName("%sEntity")
                .setMapperName("%sDao")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");
        //加载默认配置
        dataSourceConfig = new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName(pathConfig.getDatabaseDriver())
                .setUrl(pathConfig.getDatabaseUrl())
                .setUsername(pathConfig.getDatabaseUser())
                .setPassword(pathConfig.getDatabasePassword());
        strategyConfig = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //用来生成tableInfo,MPG有转换判断的逻辑错误
                .setTablePrefix(new String[]{""})
                .entityTableFieldAnnotationEnable(true)
                .setEntityLombokModel(true)
                .setSuperEntityClass(pathConfig.getPkg() + ".repo.dao.AbstractBaseEntity")
                .setSuperServiceImplClass(pathConfig.getPkg() + ".service.AbstractBaseService");
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
                .setTemplate(templateConfig);
    }

    /**
     * 装配InjectionConfig
     */
    private InjectionConfig getInjectionConfig(List<FileOutConfig> fileOutConfigList) {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(1);
                map.put("header", pathConfig.getHeader());
                this.setMap(map);
            }
        }.setFileOutConfigList(fileOutConfigList);
    }

    /**
     * 根据选项提供模板配置
     */
    private List<FileOutConfig> manipulateFileOutConfig(String[] cmds) {
        List<FileOutConfig> fileOutConfigList = new ArrayList();
        for (String cmd : cmds) {
            if ("dao".equals(cmd)) {
                fileOutConfigList.add(new FileOutConfig("/creed.entity.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getEntityDir() + File.separator + tableInfo.getEntityName()
                                + StringPool.DOT_JAVA;
                    }
                });
                fileOutConfigList.add(new FileOutConfig("/creed.dao.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getDaoDir() + File.separator + tableInfo.getMapperName()
                                + StringPool.DOT_JAVA;
                    }
                });
                continue;
            }
            if ("xml".equals(cmd)) {
                fileOutConfigList.add(new FileOutConfig("/creed.xml.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getXmlDir() + File.separator + tableInfo.getXmlName()
                                + StringPool.DOT_XML;
                    }
                });
                continue;
            }
            if ("service".equals(cmd)) {
                fileOutConfigList.add(new FileOutConfig("/creed.service.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getServiceDir() + File.separator + tableInfo.getServiceName()
                                + StringPool.DOT_JAVA;
                    }
                });
                fileOutConfigList.add(new FileOutConfig("/creed.serviceimpl.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getServiceImplDir() + File.separator + tableInfo.getServiceImplName()
                                + StringPool.DOT_JAVA;
                    }
                });
                continue;
            }
            if ("web".equals(cmd)) {
                fileOutConfigList.add(new FileOutConfig("/creed.controller.vm") {
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return pathConfig.getControllerDir() + File.separator + tableInfo.getControllerName()
                                + StringPool.DOT_JAVA;
                    }
                });
                continue;
            }
            if ("base".equals(cmd)) {
                continue;
            }
        }
        return fileOutConfigList;
    }
}
