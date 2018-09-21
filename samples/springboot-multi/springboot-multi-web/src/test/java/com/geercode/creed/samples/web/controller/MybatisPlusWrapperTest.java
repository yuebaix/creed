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

package com.geercode.creed.samples.web.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.geercode.creed.samples.repo.dao.entity.TProxyEntity;
import org.junit.Test;

/**
 * <p>Description : mybatisplus wrapper 测试</p>
 * <p>Created on  : 2018-09-21 13:17</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class MybatisPlusWrapperTest {
    @Test
    public void test() {
        TProxyEntity tProxyEntity = new TProxyEntity();
        Wrapper wrap = new QueryWrapper(tProxyEntity);
        System.out.println(wrap.getSqlSegment());
    }
}
