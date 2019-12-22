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

package com.geercode.creed.core;

import com.geercode.creed.core.system.log.Logger;
import com.geercode.creed.core.system.log.LoggerFactory;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Description : 随便测试</p>
 * <p>Created on  : 2019-03-11 15:39</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class FooTest {
    private static Logger logger = LoggerFactory.getLogger(FooTest.class);

    @Test
    public void test() {
        Deque deque = new ArrayDeque();
        System.out.println(deque.poll());
        LinkedHashMap linkedHashMap = new LinkedHashMap(16, .75f, true);
        linkedHashMap.put("first", "first");
        linkedHashMap.put("middle", "middle");
        linkedHashMap.put("last", "last");
        linkedHashMap.get("middle");

        for (Object entry : linkedHashMap.entrySet()) {
            System.out.println(((Map.Entry) entry).getKey());
        }
    }
}
