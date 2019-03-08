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

package com.geercode.creed.core.modular.event.ancester;

/**
 * <p>Description : 可返回结果</p>
 * <p>Created on  : 2019-03-07 16:24</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface Reportable {
    /**
     * <p>description : 获得返回值</p>
     * <p>create   on : 2019-03-07 16:26:10</p>
     *
     * @author jerryniu
     * @return 返回值
     * @since 1.0.0
     */
    <T> T getReport();
}
