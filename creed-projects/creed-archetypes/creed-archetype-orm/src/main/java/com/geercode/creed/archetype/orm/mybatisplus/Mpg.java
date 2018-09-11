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
 * <p>Description : MybatisPlus Generator优化接口</p>
 * <p>Created on  : 2018-09-11 15:23</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface Mpg {
    /**
     * <p>description : 生成基础类</p>
     * <p>create   on : 2018-09-11 16:19:16</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    void genBase();

    /**
     * <p>description : 生成mapper.xml</p>
     * <p>create   on : 2018-09-11 16:19:16</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    void genXml();

    /**
     * <p>description : 生成mapper类</p>
     * <p>create   on : 2018-09-11 16:19:16</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    void genMapper();

    /**
     * <p>description : 生成实体类</p>
     * <p>create   on : 2018-09-11 16:19:16</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    void genEntity();

    /**
     * <p>description : 生成服务类</p>
     * <p>create   on : 2018-09-11 16:19:16</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    void genService();

    /**
     * <p>description : 全部生成</p>
     * <p>create   on : 2018-09-11 16:19:16</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    void genAll();
}
