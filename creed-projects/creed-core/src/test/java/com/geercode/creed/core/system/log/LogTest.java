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

package com.geercode.creed.core.system.log;

import org.junit.Test;

/**
 * <p>Description : 测试系统日志</p>
 * <p>Created on  : 2018-11-02 16:27</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class LogTest {
    private Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        log.trace("123");
        log.debug("123");
        log.info("123");
        log.warn("123");
        log.error("123");
    }
}
