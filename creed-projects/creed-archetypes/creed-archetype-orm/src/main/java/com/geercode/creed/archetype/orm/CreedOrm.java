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

import com.geercode.creed.archetype.orm.mybatisplus.MpgImpl;
import com.geercode.creed.archetype.orm.mybatisplus.Mpg;

/**
 * <p>Description : CreedOrm接口</p>
 * <p>Created on  : 2018-09-11 15:18</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface CreedOrm {
    /**
     * <p>description : MybatisPlus Generator获取</p>
     * <p>create   on : 2018-09-11 16:18:22</p>
     *
     * @author jerryniu
     * @version 1.0.0
     *
     * @return Mpg CreedMybatisPlusGenerator
     */
    static Mpg mpg() {
        return MpgImpl.getHolder();
    }
}
