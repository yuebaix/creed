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
@SuppressWarnings({"unchecked", "rawtypes", "unused"})
public class FooTest {
    private final int con1 = 1;
    private final int con2 = 2;
    private final int con3 = 3;
    private final int con4 = 4;
    private final int con5 = 5;
    private final int con6 = 6;
    private final int con7 = 7;
    private final int con8 = 8;
    private final int con9 = 9;
    private final int con0 = 0;

    @Test
    public void test1() {
        int constant = 9;
        switch (constant) {
            case con1 :
                log.debug("" + con1);
                break;
            case con2 :
                log.debug("" + con2);
                break;
            case con3 :
                log.debug("" + con3);
                break;
            case con4 :
                log.debug("" + con4);
                break;
            case con5 :
                log.debug("" + con5);
                break;
            case con6 :
                log.debug("" + con6);
                break;
            case con7 :
                log.debug("" + con7);
                break;
            case con8 :
                log.debug("" + con8);
                break;
            case con9 :
                log.debug("" + con9);
                break;
            default :
                log.debug("default");
        }
    }

    @Test
    public void test2() {
        int constant = 9;
        if (constant == con1) {
            doSomething(constant);
        } else if (constant == con2) {
            doSomething(constant);
        } else {
            doSomething(constant);
        }
    }

    private void doSomething(int constant) {
        if (constant == con3) {
            new Thread(() -> {
                log.debug("123");
            }).start();
        } else if (constant == con4) {
            log.debug("" + con1);
        } else if (constant == con5) {
            log.debug("" + con1);
        } else if (constant == con6) {
            log.debug("" + con1);
        } else if (constant == con7) {
            log.debug("" + con1);
        } else if (constant == con8) {
            log.debug("" + con1);
        } else if (constant == con9) {
            log.debug("" + con1);
        } else if (constant == con0) {
            log.debug("" + con1);
        } else {
            log.debug("" + con1);
        }
    }

    @Test
    public void test3() throws Exception {
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
        //if (true && true && true && true) {
        //    log.debug("test through");
        //}
    }

    @Test
    public void test4() {
        int constant = 9;
        for (int i = 0; i < 10; i++) {
            if (constant == con2) {
                doSomething(constant);
            } else if (constant == con2) {
                doSomething(constant);
            } else {
                doSomething(constant);
            }
        }
    }
}
