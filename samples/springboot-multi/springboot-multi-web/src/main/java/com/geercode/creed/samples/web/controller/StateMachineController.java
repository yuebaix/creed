/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.controller;

import com.geercode.creed.samples.web.config.statemachine.OrderEvent;
import com.geercode.creed.samples.web.config.statemachine.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : 状态机控制器</p>
 * <p>Created on  : 2018-11-13 16:32</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sm")
public class StateMachineController {

    @Autowired
    private StateMachine<OrderState, OrderEvent> stateMachine;

    @GetMapping("/approve")
    public String approve() {
        stateMachine.sendEvent(OrderEvent.APPROVE);
        return "success";
    }

    @GetMapping("/calloff")
    public String calloff() {
        stateMachine.sendEvent(OrderEvent.CALLOFF);
        return "success";
    }
}
