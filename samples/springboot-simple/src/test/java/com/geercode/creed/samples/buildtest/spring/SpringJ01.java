package com.geercode.creed.samples.buildtest.spring;

import com.geercode.creed.samples.buildtest.group.FastTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Slf4j
@Category(FastTests.class)
public class SpringJ01 extends SpringJ {
    @Test
    public void test1() {
        log.debug("test1");
    }

    @Test
    public void test2() {
        log.debug("test2");
    }
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2017年7月14日         Jerry
 */