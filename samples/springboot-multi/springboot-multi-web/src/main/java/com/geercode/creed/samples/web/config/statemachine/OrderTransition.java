/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config.statemachine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * <p>Description : 订单状态转换</p>
 * <p>Created on  : 2018-11-13 16:28</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@WithStateMachine(id = OrderStateMachineConfig.ORDER_DOMAIN_STATE_MACHINE_ID)
@Slf4j
public class OrderTransition {

    @OnTransition(source = "INIT", target = "APPROVED")
    public void apporve() {
        log.debug("TRANSITION>>>approved");
        throw new RuntimeException("transition err");
    }

    @OnTransition(source = "APPROVED", target = "INIT")
    public void calloff() {
        log.debug("TRANSITION>>>calloff");
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-14 20:41:11</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @OnTransition(source = "APPROVED", target = "FOO_END")
    public boolean msg(Message<OrderEvent> message) {
        OrderDomain orderDomain = (OrderDomain) message.getHeaders().get("order");
        try {
            log.debug(new ObjectMapper().writeValueAsString(orderDomain));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
