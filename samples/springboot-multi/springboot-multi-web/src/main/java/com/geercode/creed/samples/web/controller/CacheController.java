/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.alicp.jetcache.anno.CreateCache;
import com.geercode.creed.samples.domain.UserDomain;
import com.geercode.creed.samples.scene.CacheService;
import com.geercode.creed.samples.scene.GlobalConfigPropService;
import com.geercode.creed.samples.scene.common.SceneConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description : 缓存控制器</p>
 * <p>Created on  : 2018-11-05 19:02</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private GlobalConfigPropService globalConfigPropService;
    /** 缓存变量 */
    @CreateCache(cacheType = CacheType.BOTH, name = SceneConstant.CACHE_PREFIX + SceneConstant.CACHE_FOO)
    private Cache<Integer, String> feildCache;

    /**
     * <p>description : 给变量加缓存(key受类名、变量名、查询key值影响)</p>
     * <p>create   on : 2018-11-05 20:00:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/feild")
    public String feild(int id) {
        log.debug("field --> 进入方法");
        return feildCache.computeIfAbsent(id, (key) -> {
            log.debug("field --> 查询数据库");
            return "foo" + (key + 1);
        }, true);
    }

    /**
     * <p>description : 对方法加缓存(key受类名、方法名、方法参数影响)</p>
     * <p>create   on : 2018-11-05 20:00:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @Cached(cacheType = CacheType.BOTH, key = "'[' + #id.toString() + ']'")
    @GetMapping("/method")
    public String method(String id) {
        log.debug("method --> 进入方法");
        log.debug("method --> 查询数据库");
        return id;
    }

    /**
     * <p>description : 分布式锁</p>
     * <p>create   on : 2018-11-05 20:00:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/lock")
    public String lock() {
        log.debug("lock --> 进入方法");
        boolean hasRun = feildCache.tryLockAndRun(-1, SceneConstant.CACHE_LOCK_SEC, TimeUnit.SECONDS, () -> {
            log.debug("lock --> 获取锁");
            log.debug("lock --> 执行操作");
            log.debug("lock --> 释放锁");
        });
        return "" + hasRun;
    }

    /**
     * <p>description : 缓存查询</p>
     * <p>create   on : 2018-11-05 20:00:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/select")
    public UserDomain select(long id) {
        UserDomain user = cacheService.select(id);
        log.debug("" + user);
        return user;
    }

    /**
     * <p>description : 缓存更新</p>
     * <p>create   on : 2018-11-05 20:00:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/update")
    public UserDomain update(UserDomain user) {
        return cacheService.insertOrUpdate(user);
    }

    /**
     * <p>description : 缓存删除</p>
     * <p>create   on : 2018-11-05 20:00:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/delete")
    public UserDomain delete(long id) {
        return cacheService.delete(id);
    }

    /**
     * <p>description : 获取配置</p>
     * <p>create   on : 2018-11-05 20:00:31</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/getConfig")
    public Map<String, String> getConfig(String key) {
        return globalConfigPropService.getConfig(key);
    }
}
