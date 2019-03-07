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

import com.geercode.creed.core.modular.event.ancester.Event;
import com.geercode.creed.core.modular.event.ancester.EventBus;
import com.geercode.creed.core.modular.event.ancester.EventListener;
import com.geercode.creed.core.system.log.Logger;
import com.geercode.creed.core.system.log.LoggerFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : 简易事件总线</p>
 * <p>Created on  : 2019-03-06 17:16</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class PlainEventBus implements EventBus {
    private static Logger logger = LoggerFactory.getLogger(PlainEventBus.class);
    private static final String LISTEN_METHOD_NAME = "listen";
    private Map<Class, List<EventListener>> catalog = new HashMap();

    @Override
    public void register(EventListener listener) {
        Class topic = null;
        Method[] methods = listener.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (LISTEN_METHOD_NAME.equals(method.getName()) && parameterTypes.length == 1
                    && Event.class.isAssignableFrom(parameterTypes[0]) && !method.isBridge()) {
                topic = parameterTypes[0];
                logger.debug("The topic registered on eventBus is [%s]", topic);
            }
        }
        List listenerList = catalog.get(topic);
        if (listenerList == null) {
            listenerList = new LinkedList();
        }
        listenerList.add(listener);
        catalog.put(topic, listenerList);
    }

    @Override
    public void post(Event event) {
        Class topic = event.getClass();
        List<EventListener> listenerList = catalog.get(topic);
        if (listenerList != null) {
            for (EventListener listener :listenerList) {
                listener.listen(event);
            }
        }
    }
}
