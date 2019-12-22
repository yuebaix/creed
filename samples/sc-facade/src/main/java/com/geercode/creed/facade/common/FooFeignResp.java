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

package com.geercode.creed.facade.common;

import lombok.Data;

/**
 * <p>description : 基础回复类</p>
 *
 * @author jerryniu
 * @since 2018-09-25
 */
@Data
public class FooFeignResp<T> {
    /**描述*/
    private String msg;
    /**编码*/
    private String code;
    /**数据内容*/
    private T data;

    /**
     * <p>description : 默认成功(不返回数据)</p>
     */
    public static FooFeignResp success() {
        return FooFeignResp.discuss(FooFeignCode.SUCCESS, null);
    }

    /**
     * <p>description : 成功(返回数据)</p>
     */
    public static <T> FooFeignResp<T> success(T data) {
        return FooFeignResp.discuss(FooFeignCode.SUCCESS, data);
    }

    /**
     * <p>description : 默认失败(不返回数据)</p>
     */
    public static FooFeignResp fail() {
        return FooFeignResp.discuss(FooFeignCode.FAIL, null);
    }

    /**
     * <p>description : 失败(返回数据)</p>
     */
    public static <T> FooFeignResp<T> fail(T data) {
        return FooFeignResp.discuss(FooFeignCode.FAIL, data);
    }

    /**
     * <p>description : 提示校验异常</p>
     */
    public static FooFeignResp review() {
        return FooFeignResp.discuss(FooFeignCode.REVIEW, null);
    }

    /**
     * <p>description : 提示校验异常(返回信息)</p>
     */
    public static FooFeignResp review(String msg) {
        return FooFeignResp.custom(FooFeignCode.REVIEW.getCode(), FooFeignCode.REVIEW.getMsg() + ":" + msg, null);
    }

    /**
     * <p>description : 提示校验异常(返回数据)</p>
     */
    public static <T> FooFeignResp<T> review(T data) {
        return FooFeignResp.discuss(FooFeignCode.REVIEW, data);
    }

    /**
     * <p>description : 错误</p>
     */
    public static FooFeignResp error() {
        return FooFeignResp.discuss(FooFeignCode.ERROR, null);
    }

    /**
     * <p>description : 自定义返回码与数据(需要在BaseCode中建立新的枚举类)</p>
     */
    public static <T> FooFeignResp<T> custom(FooFeignCode code, T data) {
        FooFeignResp<T> resp = new FooFeignResp();
        resp.setCode(code.getCode());
        resp.setMsg(code.getMsg());
        resp.setData(data);
        return resp;
    }

    /**
     * <p>description : 自定义返回码与数据</p>
     */
    public static <T> FooFeignResp<T> custom(String code, String msg, T data) {
        FooFeignResp<T> resp = new FooFeignResp();
        resp.setCode(code);
        resp.setMsg(msg);
        resp.setData(data);
        return resp;
    }

    private static <T> FooFeignResp<T> discuss(FooFeignCode code, T data) {
        FooFeignResp<T> resp = new FooFeignResp();
        resp.setCode(code.getCode());
        resp.setMsg(code.getMsg());
        resp.setData(data);
        return resp;
    }
}