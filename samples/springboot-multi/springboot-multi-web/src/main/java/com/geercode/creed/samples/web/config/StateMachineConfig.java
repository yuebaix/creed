/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config;

import com.geercode.creed.samples.web.config.statemachine.OrderEvent;
import com.geercode.creed.samples.web.config.statemachine.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

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
 * 初始化过程        initAction -> transition -> entryAction -> listener
 * transition过程   guard -> transitionAction -> transition -> exitAction -> entryAction -> listener
 * 放弃跟state有关的 entryAction与exitAction
 * 初始化过程        initAction -> transition -> listener
 * transition过程   guard -> transitionAction -> transition -> -> listener
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@EnableStateMachine
@Slf4j
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderState, OrderEvent> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
        states.withStates()
                .initial(OrderState.INIT, initAction())
                .end(OrderState.DONE)
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
                    log.debug("guard");
                    ///log.debug(state.getId().toString());
                    return true;
                })
                .action(transitionAction(), errAction())
                .and()
                .withExternal().source(OrderState.APPROVED).target(OrderState.INIT).event(OrderEvent.CALLOFF)
                .guard((context) -> {
                    StateMachine sm = context.getStateMachine();
                    State state = sm.getState();
                    log.debug(state.getId().toString());
                    return true;
                })
                .action(transitionAction(), errAction());
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
            log.debug("init");
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
            log.debug("entry");
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
            log.debug("exit");
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
            log.debug("transitionAction");
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
            log.debug(ex.getLocalizedMessage());
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
            ///log.debug(from.getId() + " change to " + to.getId());
            log.debug("statechange");
        }
    }
}
