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

/**
 * 生成的包配置
 *
 * @author LIKE
 */
public class PackageConfig {
    private String basePackage;

    /**
     * 配置包属性
     *
     * @param corpName    公司名
     * @param projectName 项目名
     * @param moduleName  模块名
     */
    public PackageConfig(String corpName, String projectName, String moduleName) {
        String mname = moduleName == null ? "" : "." + moduleName;
        basePackage = "com." + corpName + "." + projectName + mname;
    }

    public String getBaseServicePackage() {
        return basePackage + ".service";
    }

    public String getBaseServiceImplPackage() {

        return basePackage + ".service.impl";
    }

    /**
     * * 返回 mybatis plus  model
     */
    public String getModelPackage() {
        return basePackage + ".model";
    }

    /**
     * 返回 mybatis plus  mapper 文件包
     */
    public String getMapperPackage() {
        return basePackage + ".mapper";
    }

    /**
     * 生成mybatis plus 配置包
     */
    public String getConfigPackage() {
        return basePackage + ".config";
    }

    /**
     * 生成service  接口包
     */
    public String getServicePackage() {
        return basePackage + ".service";
    }

    /**
     * 生成Service Impl 包
     */
    public String getServiceImplPackage() {
        return basePackage + ".service.impl";
    }
}
