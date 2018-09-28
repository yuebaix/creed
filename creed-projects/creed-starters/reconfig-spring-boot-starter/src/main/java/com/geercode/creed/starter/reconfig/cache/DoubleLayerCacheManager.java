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

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.cache.support.NoOpCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;

import java.util.Collection;
import java.util.Collections;

/**
 * <p>Description : 双重缓存CacheManager</p>
 * <p>Created on  : 2018-09-28 16:15</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class DoubleLayerCacheManager extends AbstractCacheManager {

    public DoubleLayerCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {

    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return Collections.singletonList(new NoOpCache(""));
    }
}
