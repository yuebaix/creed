/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>description : 基础回复类</p>
 *
 * @author jerryniu
 * @since 2018-09-19
 */
@ApiModel("回复基类")
@Data
public class BaseResp<T> {
    /**描述*/
    @ApiModelProperty("描述")
    private String msg;
    /**编码*/
    @ApiModelProperty("编码")
    private String code;
    /**数据内容*/
    @ApiModelProperty("数据")
    private T data;

    /**
     * <p>description : 默认成功(不返回数据)</p>
     */
    public static BaseResp success() {
        return BaseResp.discuss(BaseCode.SUCCESS, null);
    }

    /**
     * <p>description : 成功(返回数据)</p>
     */
    public static <T> BaseResp<T> success(T data) {
        return BaseResp.discuss(BaseCode.SUCCESS, data);
    }

    /**
     * <p>description : 默认失败(不返回数据)</p>
     */
    public static BaseResp fail() {
        return BaseResp.discuss(BaseCode.FAIL, null);
    }

    /**
     * <p>description : 失败(返回数据)</p>
     */
    public static <T> BaseResp<T> fail(T data) {
        return BaseResp.discuss(BaseCode.FAIL, data);
    }

    /**
     * <p>description : 提示校验异常</p>
     */
    public static BaseResp review() {
        return BaseResp.discuss(BaseCode.REVIEW, null);
    }

    /**
     * <p>description : 提示校验异常(返回信息)</p>
     */
    public static BaseResp review(String msg) {
        return BaseResp.custom(BaseCode.REVIEW.getCode(), BaseCode.REVIEW.getMsg() + ":" + msg, null);
    }

    /**
     * <p>description : 提示校验异常(返回数据)</p>
     */
    public static <T> BaseResp<T> review(T data) {
        return BaseResp.discuss(BaseCode.REVIEW, data);
    }

    /**
     * <p>description : 错误</p>
     */
    public static BaseResp error() {
        return BaseResp.discuss(BaseCode.ERROR, null);
    }

    /**
     * <p>description : 自定义返回码与数据(需要在BaseCode中建立新的枚举类)</p>
     */
    public static <T> BaseResp<T> custom(BaseCode code, T data) {
        BaseResp<T> resp = new BaseResp();
        resp.setCode(code.getCode());
        resp.setMsg(code.getMsg());
        resp.setData(data);
        return resp;
    }

    /**
     * <p>description : 自定义返回码与数据</p>
     */
    public static <T> BaseResp<T> custom(String code, String msg, T data) {
        BaseResp<T> resp = new BaseResp();
        resp.setCode(code);
        resp.setMsg(msg);
        resp.setData(data);
        return resp;
    }

    private static <T> BaseResp<T> discuss(BaseCode code, T data) {
        BaseResp<T> resp = new BaseResp();
        resp.setCode(code.getCode());
        resp.setMsg(code.getMsg());
        resp.setData(data);
        return resp;
    }
}