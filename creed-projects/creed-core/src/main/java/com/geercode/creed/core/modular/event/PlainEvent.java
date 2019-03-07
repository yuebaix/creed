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

import com.geercode.creed.core.modular.event.ancester.Carriable;
import com.geercode.creed.core.modular.event.ancester.Event;

import java.util.Map;

/**
 * <p>Description : 简易事件</p>
 * <p>Created on  : 2019-03-06 17:14</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class PlainEvent implements Event, Carriable {
    private Map payload;
    private Map baggage;

    public PlainEvent() {
    }

    public PlainEvent(Map payload) {
        this.payload = payload;
    }

    @Override
    public Map getPayload() {
        return payload;
    }

    @Override
    public Map getBaggage() {
        return baggage;
    }

    public void setPayload(Map payload) {
        this.payload = payload;
    }

    public void setBaggage(Map baggage) {
        this.baggage = baggage;
    }
}
