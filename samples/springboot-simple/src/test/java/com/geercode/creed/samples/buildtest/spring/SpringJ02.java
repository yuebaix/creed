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

package com.geercode.creed.samples.buildtest.spring;

import com.geercode.creed.samples.buildtest.group.SlowTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Slf4j
@Category(SlowTests.class)
public class SpringJ02 extends SpringJ {
    @Test
    public void test1() {
        log.debug("test3");
    }

    @Test
    public void test2() {
        log.debug("test4");
    }
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2017年7月14日         Jerry
 */