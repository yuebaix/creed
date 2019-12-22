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

/**
 * <p>Description : 路径配置</p>
 * <p>Created on  : 2019-05-07 17:23</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface MpgPathConfig {

    /**
     * <p>description : 初始化路径配置</p>
     * <p>create   on : 2018-09-12 19:36:23</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    MpgPathConfig init();

    /**
     * <p>description : 是否覆盖原文件</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    boolean isOverride();

    /**
     * <p>description : 包含哪些表</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String[] getIncludeTables();

    /**
     * <p>description : 获取作者名</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getAuthor();

    /**
     * <p>description : 获取数据库驱动类名</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getDatabaseDriver();

    /**
     * <p>description : 获取数据库地址</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getDatabaseUrl();

    /**
     * <p>description : 获取数据库用户名</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getDatabaseUser();

    /**
     * <p>description : 获取数据库密码</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getDatabasePassword();

    /**
     * <p>description : 获取文件头</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getHeader();

    /**
     * <p>description : 获取父模块根目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getRootArtifactDir();

    /**
     * <p>description : 获取根package</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getPkg();

    /**
     * <p>description : 获取entity目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getEntityDir();

    /**
     * <p>description : 获取dao接口目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getDaoDir();

    /**
     * <p>description : 获取xml目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getXmlDir();

    /**
     * <p>description : 获取service目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getServiceDir();

    /**
     * <p>description : 获取serviceImpl目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getServiceImplDir();

    /**
     * <p>description : 获取controller目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getControllerDir();

    /**
     * <p>description : 获取dao根目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getBaseDaoDir();

    /**
     * <p>description : 获取回复基类目录</p>
     * <p>create   on : 2018-09-12 19:36:42</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     */
    String getRespDir();
}
