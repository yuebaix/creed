/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config.statemachine;

/**
 * <p>Description : 订单状态</p>
 * <p>Created on  : 2018-11-13 15:33</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public enum OrderState {
    /** 订单初始化*/
    INIT(0, "init"),
    /** 审核中*/
    AUDITING(1, "auditing"),
    /** 已通过*/
    APPROVED(2, "approved"),
    /** 已拒绝*/
    REJECTED(3, "rejected"),
    /** 已取消*/
    CALLOFFED(4, "calloffed"),
    /** 还款中*/
    REPAYING(5, "repaying"),
    /** 完成*/
    DONE(0, "done");

    private int stateCode;
    private String description;

    OrderState(int stateCode, String description) {
        this.stateCode = stateCode;
        this.description = description;
    }

    public int getStateCode() {
        return stateCode;
    }

    public String getDecription() {
        return description;
    }
}
