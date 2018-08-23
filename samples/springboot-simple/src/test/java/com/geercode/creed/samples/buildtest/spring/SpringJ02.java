package com.geercode.creed.samples.buildtest.spring;

import com.geercode.creed.samples.buildtest.group.SlowTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Slf4j
@Category(SlowTests.class)
public class SpringJ02 extends SpringJ {
    @Test
    public void test1() {
        log.debug("test3");
    }

    @Test
    public void test2() {
        log.debug("test4");
    }
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2017年7月14日         Jerry
 */