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

package com.geercode.creed.samples.domain;

import lombok.Data;

/**
 * <p>Title       : UserDomain</p>
 * <p>Description : 用户领域对象</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-17 14:19</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Data
public class UserDomain {
    private long id;
    private String name;

    /**
     * <p>description : 你好</p>
     * <p>create   on : 2018-08-30 19:36:34</p>
     *
     * @author jerryniu
     * @version 1.0.0
     * @return String
     *     一些注释
     */
    public String sayHi() {
        return "hi, I'm " + name;
    }
}
