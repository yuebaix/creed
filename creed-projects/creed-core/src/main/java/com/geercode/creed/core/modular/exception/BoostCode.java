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

package com.geercode.creed.core.modular.exception;

/**
 * <p>Description : 异常编码</p>
 * <p>Created on  : 2019-03-07 14:58</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public enum BoostCode {
    /**
     * 无异常
     */
    NONE("0000", "none exception"),
    /**
     * 框架异常
     */
    FRAMEWORK("0001", "framework error");

    /**
     * 异常码
     */
    private String code;
    /**
     * 异常信息
     */
    private String msg;

    BoostCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * <p>description : 用异常码获取异常编码</p>
     * <p>create   on : 2019-03-07 15:24:29</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    public static BoostCode getBoostCodeByCode(String code) {
        for (BoostCode boostCode : BoostCode.values()) {
            if (boostCode.code.equals(code)) {
                return boostCode;
            }
        }
        return null;
    }
}
