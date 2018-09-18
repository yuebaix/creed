/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.common;

import lombok.Data;

/**
 * <p>Description : 基础回复类</p>
 * <p>Created on  : 2018-09-18 15:28</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Data
public final class BaseResponse<T> {
    private T data;
    private String msg;

    private BaseResponse(String msg, T data) {
        this.data = data;
        this.msg = msg;
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-09-18 15:59:01</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static <T> BaseResponse<T> onSuccess(T data) {
        return new BaseResponse("success", data);
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-09-18 15:59:05</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static BaseResponse onFail(String msg) {
        return new BaseResponse(msg, null);
    }
}
