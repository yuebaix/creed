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

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * <p>Description : 缓存修改自定义类</p>
 * <p>Created on  : 2018-09-28 14:36</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({RedisConnectionFactory.class, Caffeine.class, CaffeineCacheManager.class})
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnBean(RedisConnectionFactory.class)
@ConditionalOnMissingBean(CacheManager.class)
@Slf4j
public class EnhanceCachingAutoConfig {
    private final CacheProperties cacheProperties;
    private final CacheManagerCustomizers customizers;
    private final RedisCacheConfiguration redisCacheConfiguration;
    private final Caffeine<Object, Object> caffeine;
    private final CaffeineSpec caffeineSpec;
    private final CacheLoader<Object, Object> cacheLoader;

    /**
     * <p>description : 构造器</p>
     * <p>create   on : 2018-09-28 17:53:35</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public EnhanceCachingAutoConfig(CacheProperties cacheProperties, CacheManagerCustomizers customizers,
            ObjectProvider<RedisCacheConfiguration> redisCacheConfiguration,
            ObjectProvider<Caffeine<Object, Object>> caffeine,
            ObjectProvider<CaffeineSpec> caffeineSpec,
            ObjectProvider<CacheLoader<Object, Object>> cacheLoader) {
        this.cacheProperties = cacheProperties;
        this.customizers = customizers;
        this.redisCacheConfiguration = redisCacheConfiguration.getIfAvailable();
        this.caffeine = caffeine.getIfAvailable();
        this.caffeineSpec = caffeineSpec.getIfAvailable();
        this.cacheLoader = cacheLoader.getIfAvailable();

        log.debug("cache works");
    }

    @Bean
    public DoubleLayerCacheManager cacheManager() {
        return null;
    }
}
