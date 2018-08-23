package com.geercode.creed.samples.dao;

/**
 * <p>Title       : AbstractNumb</p>
 * <p>Description : 测试抽象类命名规则</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-23 16:18</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
public abstract class AbstractNumb<S2T> {
    public void testCatch() {
        try {
            Thread.currentThread().getName();
        } catch (Exception exZ9) {

        }
    }
}
