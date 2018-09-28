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

package com.geercode.creed.starter.reconfig.cache;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * <p>Description : 类元数据键值生成器</p>
 * <p>Created on  : 2018-09-27 19:13</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Slf4j
public class ClassMetaKeyGenerator implements KeyGenerator {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String SEPARATOR = ":";
    private static final int INIT_VOL = 128;
    private String prefix;

    /**
     * <p>description : 类元数据键值生成器构造器,需要定义preffix</p>
     * <p>create   on : 2018-09-28 14:41:32</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public ClassMetaKeyGenerator(String prefix) {
        //允许序列化空POJO
        OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //把时间按照字符串输出
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //POJO中的null值不输出
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //在遇到未知属性的时候不抛出异常
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        this.prefix = prefix;
    }

    @SneakyThrows
    @Override
    public Object generate(Object instance, Method method, Object... params) {
        String clazzName = instance.getClass().getName();
        String methodName = method.getName();
        String paramName = OBJECT_MAPPER.writeValueAsString(params);
        StringBuilder sb = new StringBuilder(INIT_VOL);
        sb.append(prefix)
                .append(SEPARATOR).append(clazzName)
                .append(SEPARATOR).append(methodName)
                .append(SEPARATOR).append(paramName);
        String cacheKey = sb.toString();
        log.debug("cache key is {}", cacheKey);
        return cacheKey;
    }
}

