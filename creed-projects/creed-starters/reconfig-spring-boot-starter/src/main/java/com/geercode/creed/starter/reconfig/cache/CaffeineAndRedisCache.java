/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.starter.reconfig.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.AbstractValueAdaptingCache;
import org.springframework.data.redis.cache.RedisCache;

import java.util.concurrent.Callable;

/**
 * <p>Description : Caffeine与Redis构造的双重缓存</p>
 * <p>Created on  : 2018-09-28 16:14</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Slf4j
public class CaffeineAndRedisCache extends AbstractValueAdaptingCache {
    private String name;
    private RedisCache redisCache;
    private CaffeineCache caffeineCache;

    /**
     * <p>description : 构造器</p>
     * <p>create   on : 2018-09-28 18:03:05</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public CaffeineAndRedisCache(String name, RedisCache redisCache, CaffeineCache caffeineCache) {
        super(true);
        this.name = name;
        this.redisCache = redisCache;
        this.caffeineCache = caffeineCache;
    }

    @Override
    protected Object lookup(Object key) {
        Object value = null;
        value = caffeineCache.get(key);
        log.debug("查询一级缓存 key:{},返回值是:{}", key);
        if (value == null) {
            value = redisCache.get(key);
            log.debug("查询二级缓存 key:{},返回值是:{}", key);
        }
        return value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        T value = null;
        //查询一级缓存,如果一级缓存没有值则调用getForSecondaryCache(k, valueLoader)查询二级缓存
        value = (T) caffeineCache.getNativeCache().get(key, k -> getForSecondaryCache(k, valueLoader));
        if (value == null) {
            //直接查询二级缓存
            value = (T) getForSecondaryCache(key, valueLoader);
        }
        return value;
    }

    @Override
    public void put(Object key, Object value) {
        caffeineCache.put(key, value);
        redisCache.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        caffeineCache.putIfAbsent(key, value);
        return redisCache.putIfAbsent(key, value);
    }

    @Override
    public void evict(Object key) {
        // 删除的时候要先删除二级缓存再删除一级缓存，否则有并发问题
        redisCache.evict(key);
        caffeineCache.evict(key);
    }

    @Override
    public void clear() {
        redisCache.clear();
        caffeineCache.clear();
    }

    /**
     * 查询二级缓存
     */
    private <T> Object getForSecondaryCache(Object key, Callable<T> valueLoader) {
        T value = redisCache.get(key, valueLoader);
        log.debug("查询二级缓存 key:{},返回值是:{}", key, value);
        return value;
    }
}
