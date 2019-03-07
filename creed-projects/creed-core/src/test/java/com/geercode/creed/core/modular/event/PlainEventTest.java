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

package com.geercode.creed.core.modular.event;

import com.geercode.creed.core.modular.event.ancester.EventBus;
import com.geercode.creed.core.system.log.Logger;
import com.geercode.creed.core.system.log.LoggerFactory;
import org.junit.Test;

import java.util.Collections;

/**
 * <p>Description : 简易事件测试</p>
 * <p>Created on  : 2019-03-06 18:08</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class PlainEventTest {
    private static Logger logger = LoggerFactory.getLogger(PlainEventTest.class);

    @Test
    public void simpleTest() {
        EventBus bus = new PlainEventBus();
        bus.register(new PlainEventListener());
        bus.post(new PlainEvent(Collections.singletonMap("msg,", "what I'm saying?")));
    }
}
