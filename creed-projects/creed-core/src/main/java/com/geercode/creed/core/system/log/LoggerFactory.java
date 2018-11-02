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

import com.geercode.creed.core.system.util.ClassUtil;

/**
 * <p>Description : 日志工厂</p>
 * <p>Created on  : 2018-11-02 14:22</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class LoggerFactory {
    private static final String SLF4J_LOGGER_BINDER_NAME = "org.slf4j.impl.StaticLoggerBinder";
    private static LoggerFactory singleton = new LoggerFactory();
    private boolean useSysFlag;

    private LoggerFactory() {
        useSysFlag = !ClassUtil.isPresent(SLF4J_LOGGER_BINDER_NAME, null);
    }

    private static LoggerFactory getSingleton() {
        return singleton;
    }

    private Logger create(Object param) {
        if (param instanceof Class) {
            String name = ((Class) param).getName();
            if (useSysFlag) {
                return SysLogger.getInstance(name);
            } else {
                return Slf4jLogger.getInstance(name);
            }
        } else if (param instanceof String) {
            String name = (String) param;
            if (useSysFlag) {
                return SysLogger.getInstance(name);
            } else {
                return Slf4jLogger.getInstance(name);
            }
        } else {
            throw new IllegalArgumentException("日志工厂不支持的参数类型");
        }
    }

    /**
     * <p>description : 获取日志记录器</p>
     *
     * @param clazz 日志记录器追踪类名
     */
    public static Logger getLogger(Class clazz) {
        return getSingleton().create(clazz);
    }

    /**
     * <p>description : 获取日志记录器</p>
     *
     * @param name 日志记录器名
     */
    public static Logger getLogger(String name) {
        return getSingleton().create(name);
    }
}
