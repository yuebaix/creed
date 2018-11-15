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
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.OnStateMachineError;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Map;

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
    public boolean msg(@EventHeaders Map<String, Object> headers,
            ExtendedState extendedState,
            StateMachine<OrderState, OrderEvent> stateMachine,
            Message<OrderEvent> message,
            Exception e) throws Exception {
        OrderDomain orderDomain = (OrderDomain) message.getHeaders().get("order");
        log.debug(stateMachine.getExtendedState().get("extendparam", String.class));
        log.debug(stateMachine.getState().toString());
        log.debug(new ObjectMapper().writeValueAsString(orderDomain));
        log.debug(e.getLocalizedMessage());
        return true;
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-14 20:41:11</p>
     *
     * ///@OnTransition(source = "APPROVED", target = "FOO_END")
     *
     * @author jerryniu
     * @since 1.0.0
     */
    public boolean test(StateContext<OrderState, OrderEvent> stateContext) {
        OrderDomain orderDomain = (OrderDomain) stateContext.getMessage().getHeaders().get("order");
        try {
            log.debug(new ObjectMapper().writeValueAsString(orderDomain));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @OnStateMachineError
    public void onStateMachineError(Exception e) {
        log.debug(e.getLocalizedMessage());
    }
}
