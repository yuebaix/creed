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

package com.geercode.creed.tools.configure;

import org.junit.Test;

import java.util.Map;

/**
 * <p>Description : ResourceUtilTest</p>
 * <p>Created on  : 2018-09-11 17:05</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class ResourceUtilTest {
    @Test
    public void readPropertyFromResourcesTest() {
        //读取模板
        String input = ResourceUtil.readFileFromJar("templates/mybatis-plus.properties");
        System.out.println(input);
        Map result = ResourceUtil.readPropertiesFromResources("templates/mybatis-plus");
        System.out.println(result);
    }

    @Test
    public void readFileFromCode() {
        System.out.println(ResourceUtil.readFileFromCode("src/test/resources/templates/mybatis-plus.properties"));
    }
}
