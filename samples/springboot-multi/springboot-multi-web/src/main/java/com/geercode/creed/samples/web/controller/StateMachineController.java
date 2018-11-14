/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.controller;

import com.geercode.creed.samples.web.config.statemachine.OrderDomain;
import com.geercode.creed.samples.web.config.statemachine.OrderEvent;
import com.geercode.creed.samples.web.config.statemachine.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
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
    private StateMachineFactory<OrderState, OrderEvent> stateMachineFactory;
    @Autowired
    private StateMachinePersister<OrderState, OrderEvent, OrderDomain> stateMachinePersister;

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-14 20:41:19</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @GetMapping("/approve")
    public String approve() {
        //查询数据
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setId(1);
        orderDomain.setState("0");
        //构造状态机,恢复状态
        StateMachine stateMachine = stateMachineFactory.getStateMachine();
        try {
            stateMachinePersister.restore(stateMachine, orderDomain);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //执行操作
        boolean isSuccess = stateMachine.sendEvent(OrderEvent.APPROVE);
        return isSuccess ? "success" : "fail";
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-14 20:41:24</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @GetMapping("/calloff")
    public String calloff() {
        //查询数据
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setId(1);
        orderDomain.setState("2");
        //构造状态机,恢复状态
        StateMachine stateMachine = stateMachineFactory.getStateMachine();
        try {
            stateMachinePersister.restore(stateMachine, orderDomain);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //执行操作
        boolean isSuccess = stateMachine.sendEvent(OrderEvent.CALLOFF);
        return isSuccess ? "success" : "fail";
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-14 20:41:28</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @GetMapping("/msg")
    public String msg() {
        //查询数据
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setId(1);
        orderDomain.setState("2");
        //构造状态机,恢复状态
        StateMachine stateMachine = stateMachineFactory.getStateMachine();
        try {
            stateMachinePersister.restore(stateMachine, orderDomain);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Message message = MessageBuilder.withPayload(OrderEvent.CALLOFF).setHeader("order", orderDomain).build();
        //执行操作
        boolean isSuccess = stateMachine.sendEvent(message);
        return isSuccess ? "success" : "fail";
    }
}
