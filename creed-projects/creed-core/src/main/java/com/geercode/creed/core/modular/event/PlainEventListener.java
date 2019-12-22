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

import com.geercode.creed.core.modular.event.ancester.EventListener;
import com.geercode.creed.core.system.log.Logger;
import com.geercode.creed.core.system.log.LoggerFactory;

/**
 * <p>Description : 简易事件监听器</p>
 * <p>Created on  : 2019-03-06 17:16</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class PlainEventListener implements EventListener<PlainEvent> {
    private static Logger logger = LoggerFactory.getLogger(PlainEventListener.class);

    @Override
    public void listen(PlainEvent event) {
        logger.debug(event.toString());
    }
}
