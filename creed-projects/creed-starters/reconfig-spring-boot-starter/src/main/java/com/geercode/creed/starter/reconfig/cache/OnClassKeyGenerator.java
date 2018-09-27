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

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <p>Description : 用类元数据生成缓存key值</p>
 * <p>Created on  : 2018-09-27 19:13</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class OnClassKeyGenerator implements KeyGenerator {
    private static final String SEPRATOR = ":";
    private static final String COMMA = ",";
    private static final int INIT_VOL = 128;
    private static final int HALF_INIT_VOL = 64;

    @Override
    public Object generate(Object instance, Method method, Object... objects) {
        //String clazzName = instance.getClass().getName();
        //String methodName = method.getName();
        StringBuilder paramSb = new StringBuilder(HALF_INIT_VOL);
        Arrays.asList(objects).forEach((param) -> paramSb.append(param));
        //String paramName = paramSb.toString();
        StringBuilder sb = new StringBuilder(INIT_VOL);
        return sb.toString();
    }

    /*private String generateParamKey(Object... params) {
        if (params.length == 0) {
            return "[void]";
        } else {
            StringBuilder paramSb = new StringBuilder(64);
            for (Object param : params) {
                if (isSimpleValueType(param.getClass())) {
                    paramSb.append(param);
                } else {
                    //todo
                    paramSb.append(param);
                }
            }
            return paramSb.toString();
        }
    }

    private boolean isSimpleValueType(Class<?> clazz) {
        return (ClassUtils.isPrimitiveOrWrapper(clazz) || clazz.isEnum() || CharSequence.class.isAssignableFrom(clazz)
                || Number.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz) || URI.class == clazz
                || URL.class == clazz || Locale.class == clazz || Class.class == clazz);
    }*/
}
