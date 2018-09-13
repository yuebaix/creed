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

package com.geercode.creed.archetype.orm;

import java.io.File;

/**
 * <p>Description : 文件路径配置</p>
 * <p>Created on  : 2018-09-07 14:48</p>
 *
 * @author LiKe
 */
public class FilePathConfig {
    private String modelPath;
    private String configPath;
    private String mapperpath;
    private String servicePath;
    private String baseServicePath;
    private String baseServiceImplPath;
    private String serviceImplPath;
    private String xmlPath;

    /**
     * 生成文件的路径 （在所在自定义的目录）
     */
    public FilePathConfig(PackageConfig packageConfig, String filePath) {
        String charPath = File.separator;
        String path = packageConfig.getModelPackage().replaceAll("\\.", "\\" + charPath);
        this.modelPath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "java" + charPath + ""
                + path + charPath;

        this.configPath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "java" + charPath
                + packageConfig.getConfigPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.mapperpath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "java" + charPath
                + packageConfig.getMapperPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.servicePath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "java" + charPath
                + packageConfig.getServicePackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.baseServicePath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "java" + charPath
                + packageConfig.getBaseServicePackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.serviceImplPath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "java" + charPath
                + packageConfig.getServiceImplPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.baseServiceImplPath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "java" + charPath
                + packageConfig.getBaseServiceImplPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.xmlPath = filePath + "" + charPath + "src" + charPath + "main" + charPath + "resources" + charPath
                + "mapper" + "" + charPath + "";

    }

    /**
     * 生成文件的路径 （在所在项目中）
     */
    public FilePathConfig(PackageConfig packageConfig) {
        String charPath = File.separator;
        String path = packageConfig.getModelPackage().replaceAll("\\.", "\\" + charPath);
        this.modelPath = System.getProperty("user.dir") + "" + charPath + "src" + charPath + "main"
                + charPath + "java" + charPath + "" + path + charPath;

        this.configPath = System.getProperty("user.dir") + "" + charPath + "src" + charPath + "main"
                + charPath + "java" + charPath
                + packageConfig.getConfigPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.mapperpath = System.getProperty("user.dir") + "" + charPath + "src" + charPath + "main"
                + charPath + "java" + charPath
                + packageConfig.getMapperPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.servicePath = System.getProperty("user.dir") + "" + charPath + "src" + charPath
                + "main" + charPath + "java" + charPath
                + packageConfig.getServicePackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.baseServicePath = System.getProperty("user.dir") + "" + charPath + "src" + charPath
                + "main" + charPath + "java" + charPath
                + packageConfig.getBaseServicePackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.serviceImplPath = System.getProperty("user.dir") + "" + charPath + "src" + charPath
                + "main" + charPath + "java" + charPath
                + packageConfig.getServiceImplPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.baseServiceImplPath = System.getProperty("user.dir") + "" + charPath + "src" + charPath
                + "main" + charPath + "java" + charPath
                + packageConfig.getBaseServiceImplPackage().replaceAll("\\.", "\\" + charPath) + charPath;
        this.xmlPath = System.getProperty("user.dir") + "" + charPath + "src" + charPath
                + "main" + charPath + "resources" + charPath
                + "mapper" + "" + charPath + "";

    }

    public String getXmlPath() {
        return xmlPath;
    }

    public String getBaseServicePath() {
        return baseServicePath;
    }

    public String getBaseServiceImplPath() {
        return baseServiceImplPath;
    }

    public String getModelPath() {
        return modelPath;
    }

    public String getConfigPath() {
        return configPath;
    }

    public String getMapperpath() {
        return mapperpath;
    }

    public String getServicePath() {
        return servicePath;
    }

    public String getServiceImplPath() {
        return serviceImplPath;
    }
}
