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

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

@Slf4j
public class DemoTrxTest extends SpringJ {
    @Test
    //@Transactional//需要本地提供事务管理
    public void test() {
        log.debug("test");
    }

    @Before
    public void before() {
        log.debug("before");
    }

    @After
    public void after() {
        log.debug("after");
    }

    @BeforeTransaction
    public void beforeTx() {
        log.debug("beforeTx");
    }

    @AfterTransaction
    public void afterTx() {
        log.debug("afterTx");
    }
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2017年7月14日         Jerry
 */