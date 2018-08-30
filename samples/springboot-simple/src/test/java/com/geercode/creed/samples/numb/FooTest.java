package com.geercode.creed.samples.numb;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * <p>Title       : FooTest</p>
 * <p>Description : 没什么用的测试</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-30 12:33</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Slf4j
public class FooTest {
    @Test
    public void test2() throws Exception {
        long l = 100L;
        log.debug("" + l);
        int[] arr = new int[]{1, 2,
                3};
        int i = 1;
        i = 2;
        log.debug("" + i);
        try {
            log.debug("try");
        } catch (Exception
              ex) {
            log.debug("ex");
        }
        if (true && true && true && true) {
            log.debug("test through");
        }
    }
}
