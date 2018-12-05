/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config.statemachine;

/**
 * <p>Description : 订单事件</p>
 * <p>Created on  : 2018-11-13 15:33</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public enum OrderEvent {
    /** 申请*/
    APPLY,
    /** 审核通过*/
    APPROVE,
    /** 审核拒绝*/
    REJECT,
    /** 取消*/
    CALLOFF,
    /** 还款*/
    REPAY;
}
