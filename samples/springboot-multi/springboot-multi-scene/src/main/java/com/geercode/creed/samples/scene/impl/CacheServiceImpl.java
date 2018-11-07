/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.scene.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.geercode.creed.samples.domain.UserDomain;
import com.geercode.creed.samples.scene.CacheService;
import com.geercode.creed.samples.scene.common.SceneConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : 缓存服务实现</p>
 * <p>Created on  : 2018-11-06 15:14</p>
 *
 * 注意:写null值目前只有本地或者远程缓存的时候才起作用,阿里彩票团队二层缓存的实现有问题,我已经提了issue,要用的时候请测试一下,
 * 他们修改完以后我会顺势升级一下jetcache版本
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Service
@Slf4j
public class CacheServiceImpl implements CacheService {
    private static Map<Long, UserDomain> cache = new HashMap();

    @Override
    @Cached(cacheType = CacheType.BOTH,
            cacheNullValue = true,
            name = SceneConstant.CACHE_PREFIX + SceneConstant.CACHE_USER,
            key = "#id"
    )
    public UserDomain select(long id) {
        log.debug("查询");
        UserDomain user = cache.get(id);
        return user;
    }

    @Override
    @CacheUpdate(name = SceneConstant.CACHE_PREFIX + SceneConstant.CACHE_USER,
            key = "#user.id",
            value = "#result"
    )
    public UserDomain insertOrUpdate(UserDomain user) {
        log.debug("修改");
        cache.put(user.getId(), user);
        return user;
    }

    @Override
    @CacheInvalidate(name = SceneConstant.CACHE_PREFIX + SceneConstant.CACHE_USER,
            key = "#id"
    )
    public UserDomain delete(long id) {
        log.debug("删除");
        cache.remove(id);
        return cache.get(id);
    }
}
