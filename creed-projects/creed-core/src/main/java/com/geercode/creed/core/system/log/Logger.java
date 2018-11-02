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

/**
 * <p>Description : 日志类</p>
 * <p>Created on  : 2018-11-02 14:30</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface Logger {
    /**
     * <p>description : 输出trace等级的日志</p>
     *
     * @param msg 日志信息
     */
    void trace(String msg);

    /**
     * <p>description : 输出trace等级的日志</p>
     *
     * @param msg 日志信息
     * @param t 异常信息
     */
    void trace(String msg, Throwable t);

    /**
     * <p>description : 输出trace等级的日志</p>
     *
     * @param msg 日志信息
     * @param args 日志参数
     */
    default void trace(String msg, Object... args) {
        trace(String.format(msg, args));
    }

    /**
     * <p>description : 输出debug等级的日志</p>
     *
     * @param msg 日志信息
     */
    void debug(String msg);

    /**
     * <p>description : 输出debug等级的日志</p>
     *
     * @param msg 日志信息
     * @param t 异常信息
     */
    void debug(String msg, Throwable t);

    /**
     * <p>description : 输出debug等级的日志</p>
     *
     * @param msg 日志信息
     * @param args 日志参数
     */
    default void debug(String msg, Object... args) {
        debug(String.format(msg, args));
    }

    /**
     * <p>description : 输出info等级的日志</p>
     *
     * @param msg 日志信息
     */
    void info(String msg);

    /**
     * <p>description : 输出info等级的日志</p>
     *
     * @param msg 日志信息
     * @param t 异常信息
     */
    void info(String msg, Throwable t);

    /**
     * <p>description : 输出info等级的日志</p>
     *
     * @param msg 日志信息
     * @param args 日志参数
     */
    default void info(String msg, Object... args) {
        info(String.format(msg, args));
    }

    /**
     * <p>description : 输出warn等级的日志</p>
     *
     * @param msg 日志信息
     */
    void warn(String msg);

    /**
     * <p>description : 输出warn等级的日志</p>
     *
     * @param msg 日志信息
     * @param t 异常信息
     */
    void warn(String msg, Throwable t);

    /**
     * <p>description : 输出warn等级的日志</p>
     *
     * @param msg 日志信息
     * @param args 日志参数
     */
    default void warn(String msg, Object... args) {
        warn(String.format(msg, args));
    }

    /**
     * <p>description : 输出error等级的日志</p>
     *
     * @param msg 日志信息
     */
    void error(String msg);

    /**
     * <p>description : 输出error等级的日志</p>
     *
     * @param msg 日志信息
     * @param t 异常信息
     */
    void error(String msg, Throwable t);

    /**
     * <p>description : 输出error等级的日志</p>
     *
     * @param msg 日志信息
     * @param args 日志参数
     */
    default void error(String msg, Object... args) {
        error(String.format(msg, args));
    }
}
