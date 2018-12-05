/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.squirrel;

/**
 * <p>Description : 订单状态机</p>
 * <p>Created on  : 2018-11-15 14:16</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */

import com.geercode.creed.samples.web.config.statemachine.OrderEvent;
import com.geercode.creed.samples.web.config.statemachine.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.squirrelframework.foundation.fsm.Condition;
import org.squirrelframework.foundation.fsm.annotation.State;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.annotation.States;
import org.squirrelframework.foundation.fsm.annotation.Transit;
import org.squirrelframework.foundation.fsm.annotation.Transitions;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

import java.util.Map;

@StateMachineParameters(stateType = OrderState.class, eventType = OrderEvent.class,
        contextType = Map.class)
@States({
        @State(name = "INIT", initialState = true),
        @State(name = "APPROVED")
})
@Transitions({
        @Transit(from = "INIT", to = "APPROVED", on = "APPROVE", callMethod = "apporve", whenMvel = "true",
        when = OrderStateMachine.PreCondition.class),
        @Transit(from = "APPROVED", to = "INIT", on = "CALLOFF", callMethod = "calloff")
})
@Slf4j
public class OrderStateMachine extends AbstractUntypedStateMachine {

    public void calloff(OrderState from, OrderState to, OrderEvent e, Map context) {
        log.debug("calloff");
    }

    public void apporve(OrderState from, OrderState to, OrderEvent e, Map context) {
        log.debug("apporve");
    }

    static class PreCondition implements Condition {
        @Override
        public boolean isSatisfied(Object o) {
            return false;
        }

        @Override
        public String name() {
            return null;
        }
    }
}
