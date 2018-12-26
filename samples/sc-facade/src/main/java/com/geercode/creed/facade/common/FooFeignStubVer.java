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

package com.geercode.creed.facade.common;

/**
 * <p>Description : Dto基础抽象类</p>
 * <p>Created on  : 2018-12-25 20:32</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface FooFeignStubVer {
    String API_VERSION = "v1.0.0";

    /**
     * <p>description : </p>
     * <p>create   on : 2018-12-26 13:47:57</p>
     *
     * @author jerryniu
     * @return String 123
     * @since 1.0.0
     */
    default String getVer() {
        return API_VERSION;
    }
}
