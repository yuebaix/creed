/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

/**
 * <p>Description : 状态机配置</p>
 * <p>Created on  : 2018-11-13 15:33</p>
 *
 * state
 * event
 * statemachine
 * stateContext
 *
 * guard 判断是否可以向下执行
 * action
 * transition 状态转换时执行的操作
 * listener statemachine生命周期的事件监听器
 *
 * 初始化过程        initialAction -> transition -> entryAction -> listener
 * transition过程   guard -> transitionAction -> transition -> exitAction -> entryAction -> listener
 * 放弃跟state有关的 entryAction与exitAction
 * 初始化过程        initialAction -> transition -> listener
 * transition过程   guard -> transitionAction -> transition -> listener
 * 放弃跟state有关的 transistion
 * 初始化过程        initialAction -> listener
 * transition过程   guard -> transitionAction -> transition -> listener
 *
 * StateAction
 * entryAction
 * exitAction
 *
 * accessor
 * interceptor
 * extendstate
 * message
 * trigger
 *
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@EnableStateMachineFactory(contextEvents = false)
@Slf4j
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

    public static final String ORDER_DOMAIN_STATE_MACHINE_ID = "orderDomainStateMachineId";
    private static final int NOOB_SB_SIEZ = 64;

    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderState, OrderEvent> config)
            throws Exception {
        config
                .withConfiguration()
                .machineId(ORDER_DOMAIN_STATE_MACHINE_ID)
                .listener(listener())
                .autoStartup(true);
    }

    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
        states.withStates()
                .initial(OrderState.FOO_INITIAL, initAction())
                .end(OrderState.FOO_END)
                .end(OrderState.DONE)
                .end(OrderState.REJECTED)
                .end(OrderState.CALLOFFED)
                .states(EnumSet.allOf(OrderState.class))
                .state(OrderState.INIT, entryAction(), exitAction())
                .state(OrderState.APPROVED, entryAction(), exitAction());
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions) throws Exception {
        transitions
                .withExternal().source(OrderState.INIT).target(OrderState.APPROVED).event(OrderEvent.APPROVE)
                .guard((context) -> {
                    StateMachine sm = context.getStateMachine();
                    State state = sm.getState();
                    log.debug("GUARD>>>current state is " + state.getId().toString());
                    return true;
                })
                .action(transitionAction(), errAction())
                .and()
                .withExternal().source(OrderState.APPROVED).target(OrderState.INIT).event(OrderEvent.CALLOFF)
                .guard((context) -> {
                    StateMachine sm = context.getStateMachine();
                    State state = sm.getState();
                    log.debug("GUARD>>>current state is " + state.getId().toString());
                    return true;
                })
                .action(transitionAction(), errAction())
                .and()
                .withExternal().source(OrderState.APPROVED).target(OrderState.FOO_END).event(OrderEvent.REJECT);
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-13 20:17:39</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @Bean
    public Action<OrderState, OrderEvent> initAction() {
        return (context) -> {
            log.debug("INITIAL_ACTION>>>");
        };
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-13 20:17:39</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @Bean
    public Action<OrderState, OrderEvent> entryAction() {
        return (context) -> {
            log.debug("ENTRY_ACTION>>>");
        };
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-13 20:17:39</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @Bean
    public Action<OrderState, OrderEvent> exitAction() {
        return (context) -> {
            log.debug("EXIT_ACTION>>>");
        };
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-13 20:17:39</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @Bean
    public Action<OrderState, OrderEvent> transitionAction() {
        return (context) -> {
            StateMachine sm = context.getStateMachine();
            State state = sm.getState();
            log.debug("TRANSITION_ACTION>>>");
            ///log.debug(state.getId().toString());
            ///throw new RuntimeException("action error");
        };
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-13 20:17:39</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @Bean
    public Action<OrderState, OrderEvent> errAction() {
        return (context) -> {
            Exception ex = context.getException();
            log.debug("TRANSITION_ERR_ACTION" + ex.getLocalizedMessage());
        };
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-13 20:17:39</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @Bean
    public StateMachineListener<OrderState, OrderEvent> listener() {
        return new LogStateMachineListener();
    }

    @Bean
    public StateMachinePersister<OrderState, OrderEvent, OrderDomain> persister() {
        return new DefaultStateMachinePersister(new CustomStateMachinePersist());
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-13 20:17:39</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static class LogStateMachineListener extends StateMachineListenerAdapter<OrderState, OrderEvent> {
        @Override
        public void stateChanged(State<OrderState, OrderEvent> from, State<OrderState, OrderEvent> to) {
            StringBuilder sb = new StringBuilder(NOOB_SB_SIEZ);
            sb.append("STATE_CHANGING>>>");
            if (from != null) {
                sb.append(from.getId() + " ");
            }
            sb.append("change to " + to.getId());
            log.debug(sb.toString());
        }
    }

    public static class CustomStateMachinePersist implements StateMachinePersist<OrderState, OrderEvent, OrderDomain> {
        @Override
        public void write(StateMachineContext<OrderState, OrderEvent> context, OrderDomain contextObj)
                throws Exception {
            log.debug("write");
        }

        @Override
        public StateMachineContext<OrderState, OrderEvent> read(OrderDomain orderDomain) throws Exception {
            log.debug("read");
            String status = orderDomain.getState();
            OrderState currentState = OrderState.getByCode(OrderState.class, status);
            StateMachineContext<OrderState, OrderEvent> result =
                    new DefaultStateMachineContext<OrderState, OrderEvent>(currentState, null, null, null, null,
                    ORDER_DOMAIN_STATE_MACHINE_ID);
            return result;
        }
    }
}
