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
import com.geercode.creed.core.modular.event.ancester.Reportable;

import java.util.Map;

/**
 * <p>Description : 简易事件</p>
 * <p>Created on  : 2019-03-06 17:14</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class PlainEvent implements Event, Carriable, Reportable {
    private Map payload;
    private Map baggage;
    private Map report;

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

    @Override
    public Map getReport() {
        return report;
    }

    public void setPayload(Map payload) {
        this.payload = payload;
    }

    public void setBaggage(Map baggage) {
        this.baggage = baggage;
    }

    public void setReport(Map report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "PlainEvent{" + "payload=" + payload + ", baggage=" + baggage + ", report=" + report + '}';
    }

    public static final class StepBuilder {
        public static PayloadStep newBuilder() {
            return new Steps();
        }

        public interface PayloadStep {
            /**
             * <p>description : 添加主信息</p>
             *
             * @param payload 主信息
             * @return 添加透传数据接口
             */
            BaggageStep payload(Map payload);

            /**
             * <p>description : 只有主信息,跳过其他步骤</p>
             *
             * @param payload 主信息
             * @return 构建步骤接口
             */
            BuildStep justPayload(Map payload);
        }

        public interface BaggageStep {
            /**
             * <p>description : 添加透传信息</p>
             *
             * @param baggage 透传信息
             * @return 添加返回数据步骤接口
             */
            ReportStep baggage(Map baggage);
        }

        public interface ReportStep {
            /**
             * <p>description : 添加返回数据</p>
             *
             * @param report 返回数据
             * @return 构建步骤接口
             */
            BuildStep report(Map report);
        }

        public interface BuildStep {
            /**
             * <p>description : 构建</p>
             *
             * @return 事件
             */
            PlainEvent build();
        }

        public static final class Steps implements PayloadStep, BaggageStep, ReportStep, BuildStep {
            private Map payloadValue;
            private Map baggageValue;
            private Map reportValue;

            @Override
            public StepBuilder.BaggageStep payload(Map payload) {
                this.payloadValue = payload;
                return this;
            }

            @Override
            public BuildStep justPayload(Map payload) {
                this.payloadValue = payload;
                return this;
            }

            @Override
            public StepBuilder.ReportStep baggage(Map baggage) {
                this.baggageValue = baggage;
                return this;
            }

            @Override
            public StepBuilder.BuildStep report(Map report) {
                this.reportValue = report;
                return this;
            }

            @Override
            public PlainEvent build() {
                PlainEvent event = new PlainEvent();
                event.setPayload(payloadValue);
                event.setBaggage(baggageValue);
                event.setReport(reportValue);
                return event;
            }
        }
    }
}
