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

package com.geercode.creed.core.modular.config.ancestor;

/**
 * <p>Description : 配置</p>
 * <p>Created on  : 2018-11-01 16:55</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface Configuration {
    /**
     * <p>description : 获取profile</p>
     * <p>create   on : 2019-03-08 12:48:01</p>
     *
     * @author jerryniu
     * @return profile值
     * @since 1.0.0
     */
    String getProfile();

    /**
     * <p>description : 获取映射值</p>
     * <p>create   on : 2019-03-08 12:48:01</p>
     *
     * @author jerryniu
     * @param key 配置键值
     * @return 配置值
     * @since 1.0.0
     */
    String getValue(String key);

    /**
     * <p>description : 刷新配置</p>
     * <p>create   on : 2019-03-08 12:48:01</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    void refresh();
}
