/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config.statemachine;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * <p>Description : 订单状态</p>
 * <p>Created on  : 2018-11-13 15:33</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public enum OrderState {
    /** 订单初始化*/
    FOO_INITIAL("-200", "foo_initial"),
    /** 订单初始化*/
    FOO_END("-100", "foo_end"),
    /** 订单初始化*/
    INIT("0", "init"),
    /** 审核中*/
    AUDITING("1", "auditing"),
    /** 已通过*/
    APPROVED("2", "approved"),
    /** 已拒绝*/
    REJECTED("3", "rejected"),
    /** 已取消*/
    CALLOFFED("4", "calloffed"),
    /** 还款中*/
    REPAYING("5", "repaying"),
    /** 完成*/
    DONE("6", "done");

    private String code;
    private String description;

    OrderState(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDecription() {
        return description;
    }

    /**
     * <p>description : 根据code获得状态实体</p>
     * <p>create   on : 2018-11-14 20:35:41</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    public static <E> E getByCode(Class<E> clz, Object code) {
        try {
            for (E e : clz.getEnumConstants()) {
                Field field = clz.getDeclaredField("code");
                ///field.setAccessible(true);
                if (Objects.equals(field.get(e), code)) {
                    return e;
                }
            }
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException("根据code获取枚举实例异常" + clz + " code:" + code, ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException("根据code获取枚举实例异常" + clz + " code:" + code, ex);
        }
        return null;
    }

}
