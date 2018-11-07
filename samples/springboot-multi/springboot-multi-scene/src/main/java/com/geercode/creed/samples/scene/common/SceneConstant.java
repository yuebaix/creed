/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.scene.common;

/**
 * <p>Description : 常量</p>
 * <p>Created on  : 2018-11-06 15:50</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public final class SceneConstant {
    /** 指定缓存名前缀*/
    public static final String CACHE_PREFIX = "system:";
    public static final int CACHE_LOCK_SEC = 100;
    public static final int CACHE_REFRESH_SEC = 10;
    public static final String CACHE_USER = "user:";
    public static final String CACHE_PROP = "prop:";
    public static final String CACHE_FOO = "foo:";

    public static final int FOO_INT = 10;

    private SceneConstant() {
    }
}
