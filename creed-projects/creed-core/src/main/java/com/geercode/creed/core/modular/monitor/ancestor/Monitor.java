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

package com.geercode.creed.core.modular.monitor.ancestor;

/**
 * <p>Description : 监视器</p>
 * <p>Created on  : 2019-03-07 16:38</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface Monitor {
    /**
     * <p>description : 查看当前采样结果</p>
     * <p>create   on : 2019-03-08 10:11:30</p>
     *
     * @author jerryniu
     * @return 获取实时监测数据
     * @since 1.0.0
     */
    String peek();

    /**
     * <p>description : 获取数据面板</p>
     * <p>create   on : 2019-03-08 10:11:59</p>
     *
     * @author jerryniu
     * @return 获取监视面板实体
     * @since 1.0.0
     */
    Dashboard getDashboard();
}
