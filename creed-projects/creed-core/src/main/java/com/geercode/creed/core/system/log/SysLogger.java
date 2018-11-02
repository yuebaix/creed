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

import com.geercode.creed.core.system.util.TimeUtil;

/**
 * <p>Description : 标准流日志</p>
 * <p>Created on  : 2018-11-02 14:34</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class SysLogger implements Logger {
    private static final String LOG_FORMAT = "%s  %s  [%s] : # %s";
    private String name;

    private SysLogger(String name) {
        this.name = name;
    }

    public static SysLogger getInstance(String name) {
        return new SysLogger(name);
    }

    @Override
    public void trace(String msg) {
        System.out.println(String.format(LOG_FORMAT, TimeUtil.now(), "TRACE", name, msg));
    }

    @Override
    public void trace(String msg, Throwable t) {
        System.out.println(String.format(LOG_FORMAT, TimeUtil.now(), "TRACE", name, msg));
        t.printStackTrace();
    }

    @Override
    public void debug(String msg) {
        System.out.println(String.format(LOG_FORMAT, TimeUtil.now(), "DEBUG", name, msg));
    }

    @Override
    public void debug(String msg, Throwable t) {
        System.out.println(String.format(LOG_FORMAT, TimeUtil.now(), "DEBUG", name, msg));
        t.printStackTrace();
    }

    @Override
    public void info(String msg) {
        System.out.println(String.format(LOG_FORMAT, TimeUtil.now(), "INFO ", name, msg));
    }

    @Override
    public void info(String msg, Throwable t) {
        System.out.println(String.format(LOG_FORMAT, TimeUtil.now(), "INFO ", name, msg));
        t.printStackTrace();
    }

    @Override
    public void warn(String msg) {
        System.err.println(String.format(LOG_FORMAT, TimeUtil.now(), "WARN ", name, msg));
    }

    @Override
    public void warn(String msg, Throwable t) {
        System.err.println(String.format(LOG_FORMAT, TimeUtil.now(), "WARN ", name, msg));
        t.printStackTrace();
    }

    @Override
    public void error(String msg) {
        System.err.println(String.format(LOG_FORMAT, TimeUtil.now(), "ERROR", name, msg));
    }

    @Override
    public void error(String msg, Throwable t) {
        System.err.println(String.format(LOG_FORMAT, TimeUtil.now(), "ERROR", name, msg));
        t.printStackTrace();
    }
}
