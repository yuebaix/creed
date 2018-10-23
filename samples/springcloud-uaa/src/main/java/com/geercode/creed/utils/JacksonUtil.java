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

package com.geercode.creed.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * <p>Description : jackson工具类</p>
 * <p>Created on  : 2018-10-23 20:13</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class JacksonUtil {
    private volatile static ObjectMapper objectMapperHolder;

    private JacksonUtil() {
    }

    /**
     * <p>description : 获取一般配置后的单例ObjectMapper</p>
     * <p>create   on : 2018-10-23 20:42:54</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static ObjectMapper getObjectMapperHolder() {
        if (objectMapperHolder == null) {
            synchronized (JacksonUtil.class) {
                if (objectMapperHolder == null) {
                    ObjectMapper ob = new ObjectMapper();
                    //允许序列化空POJO
                    ob.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
                    //把时间按照字符串输出
                    ob.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                    //POJO中的null值不输出
                    ob.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    //在遇到未知属性的时候不抛出异常
                    ob.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    objectMapperHolder = ob;
                }
            }
        }
        return objectMapperHolder;
    }
}
