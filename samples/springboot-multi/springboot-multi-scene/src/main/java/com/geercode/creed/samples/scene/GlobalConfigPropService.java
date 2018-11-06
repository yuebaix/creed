/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.scene;

import java.util.Map;

/**
 * <p>Description : 全局配置属性缓存</p>
 * <p>Created on  : 2018-11-06 19:06</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface GlobalConfigPropService {
    /**
     * <p>description : 加载系统配置</p>
     * <p>create   on : 2018-11-06 19:17:57</p>
     *
     * @author jerryniu
     * @version 1.0.0
     *
     * @param key 配置集
     * @return Map 配置
     */
    Map<String, String> getConfig(String key);
}
