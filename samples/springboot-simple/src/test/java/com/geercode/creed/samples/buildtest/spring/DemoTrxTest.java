package com.geercode.creed.samples.buildtest.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

@Slf4j
public class DemoTrxTest extends SpringJ {
    @Test
    //@Transactional//需要本地提供事务管理
    public void test() {
        log.debug("test");
    }

    @Before
    public void before() {
        log.debug("before");
    }

    @After
    public void after() {
        log.debug("after");
    }

    @BeforeTransaction
    public void beforeTx() {
        log.debug("beforeTx");
    }

    @AfterTransaction
    public void afterTx() {
        log.debug("afterTx");
    }
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2017年7月14日         Jerry
 */