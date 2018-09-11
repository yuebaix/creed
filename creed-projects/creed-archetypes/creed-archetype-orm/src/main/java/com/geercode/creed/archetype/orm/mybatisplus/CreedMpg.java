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

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : Creed MybatisPlus Generator</p>
 * <p>Created on  : 2018-09-11 14:59</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class CreedMpg implements Mpg {
    private volatile static Mpg holder;
    private static final char[] HOLDER_MONITOR = new char[0];

    private static final String CONFIG_FILE_PATH = "mybatis-plus";

    /*GlobalConfig globalConfig = new GlobalConfig();
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    StrategyConfig strategyConfig = new StrategyConfig();
    PackageConfig packageConfig = new PackageConfig();
    TemplateConfig tc = new TemplateConfig();*/

    private CreedMpg() {
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
                    holder = new CreedMpg();
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

    }

    private void configMpg() {
    }

    private InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(1);
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
            }
        }));
    }
}
