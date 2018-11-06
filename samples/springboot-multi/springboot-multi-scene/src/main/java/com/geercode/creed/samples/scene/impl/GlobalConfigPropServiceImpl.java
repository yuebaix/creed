/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.scene.impl;

import com.alicp.jetcache.anno.CachePenetrationProtect;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.geercode.creed.samples.scene.GlobalConfigPropService;
import com.geercode.creed.samples.scene.common.SceneConstant;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : 全局配置缓存实现</p>
 * <p>Created on  : 2018-11-06 19:07</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Service
public class GlobalConfigPropServiceImpl implements GlobalConfigPropService {
    @Override
    @Cached(cacheType = CacheType.BOTH,
            cacheNullValue = true,
            name = SceneConstant.CACHE_PREFIX + SceneConstant.CACHE_PROP,
            key = "#key"
    )
    @CacheRefresh(refresh = SceneConstant.CACHE_REFRESH_SEC)
    @CachePenetrationProtect
    public Map<String, String> getConfig(String key) {
        return loadProp().get(key);
    }

    private Map<String, Map<String, String>> loadProp() {
        Map<String, Map<String, String>> prop = new HashMap(SceneConstant.FOO_INT);
        Map<String, String> cityCodeConfig = new HashMap(SceneConstant.FOO_INT);

        cityCodeConfig.put("1", "北京");
        cityCodeConfig.put("2", "上海");
        cityCodeConfig.put("3", "广州");
        cityCodeConfig.put("4", "深圳");
        prop.put("cityCode", cityCodeConfig);
        return prop;
    }
}
