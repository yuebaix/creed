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

package com.geercode.creed.core.system.util;

/**
 * <p>Description : 类工具</p>
 * <p>Created on  : 2018-11-02 15:59</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class ClassUtil {
    private ClassUtil() {
    }

    /**
     * <p>description : 获取是否有对应的类被加载</p>
     * <p>create   on : 2018-11-02 16:26:12</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static boolean isPresent(String className, ClassLoader classLoader) {
        if (className == null || "".equals(className)) {
            throw new IllegalArgumentException("ClassUtil ---> className不能为空");
        }
        if (classLoader == null) {
            classLoader = getDefaultClassLoader();
        }
        try {
            Class clazz = classLoader == null ? Class.forName(className) : classLoader.loadClass(className);
            return clazz != null;
        } catch (Throwable ex) {
            return false;
        }
    }

    /**
     * <p>description : 获取默认的ClassLoader</p>
     * <p>create   on : 2018-11-02 16:26:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
        }
        if (cl == null) {
            cl = ClassUtil.class.getClassLoader();
            if (cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {
                }
            }
        }
        return cl;
    }
}
