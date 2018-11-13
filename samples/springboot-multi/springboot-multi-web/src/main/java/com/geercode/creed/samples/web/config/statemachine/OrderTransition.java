/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * <p>Description : 订单状态转换</p>
 * <p>Created on  : 2018-11-13 16:28</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@WithStateMachine
@Slf4j
public class OrderTransition {

    @OnTransition(target = "APPROVED")
    public void apporve() {
        log.debug("approved");
    }

    @OnTransition(target = "INIT")
    public void calloff() {
        log.debug("calloff");
    }
}
