/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.squirrel;

import com.geercode.creed.samples.web.config.statemachine.OrderEvent;
import com.geercode.creed.samples.web.config.statemachine.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.squirrelframework.foundation.fsm.Condition;
import org.squirrelframework.foundation.fsm.StateMachine;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

import java.util.Map;

/**
 * <p>Description : 状态机配置</p>
 * <p>Created on  : 2018-11-15 13:37</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Slf4j
public class StateMachineConfig {
    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-15 18:10:51</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    public void processMain() {
        StateMachineBuilder<StateMachineSample, OrderState, OrderEvent, Map> builder =
                StateMachineBuilderFactory.create(
                StateMachineSample.class, OrderState.class, OrderEvent.class,
                Map.class
        );

        builder.externalTransition().from(OrderState.INIT).to(OrderState.APPROVED).on(OrderEvent.APPROVE).when(
                new NoobCondition()).callMethod("myInternalTransitionCall");

        StateMachine sm = builder.newStateMachine(OrderState.INIT);
        sm.fire(OrderEvent.APPROVE);
        log.debug("456");

        UntypedStateMachineBuilder buildder = StateMachineBuilderFactory.create(OrderStateMachine.class);
        StateMachine sm2 = buildder.newStateMachine(OrderState.INIT);

        sm2.fire(OrderEvent.APPROVE);
        sm2.fire(OrderEvent.CALLOFF);

        log.debug(sm2.getCurrentState().toString());
        log.debug("789");
    }

    static class NoobCondition implements Condition<Map> {
        @Override
        public boolean isSatisfied(Map context) {
            return true;
        }

        @Override
        public String name() {
            return "MyCondition";
        }
    }

    static class StateMachineSample extends AbstractStateMachine<StateMachineSample, OrderState, OrderEvent, Map> {
        public void myInternalTransitionCall(OrderState from, OrderState to, OrderEvent e, Map context) {
            log.debug("123");
        }
    }
}
