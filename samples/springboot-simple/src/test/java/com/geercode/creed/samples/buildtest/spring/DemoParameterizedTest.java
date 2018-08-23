package com.geercode.creed.samples.buildtest.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * <p>Title       : DemoParameterizedTest</p>
 * <p>Description : 测试Parameterized提供参数,固定测试用例</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-16 14:08</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Slf4j
@RunWith(Parameterized.class)
public class DemoParameterizedTest {
    private String name;
    private String greeting;

    public DemoParameterizedTest(String name, String greeting) {
        this.name = name;
        this.greeting = greeting;
    }

    /**
     * 这里的返回的应该是一个可迭代数组，且方法必须是public static
     *
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"jerry", "hello"},
                {"tommy", "hi"},
                {"jack", "good morning"},
                {"rose", "how are you"}
        });
    }

    @Test
    public void testParams() {
        log.debug(greeting + " ," + name);
    }
}
