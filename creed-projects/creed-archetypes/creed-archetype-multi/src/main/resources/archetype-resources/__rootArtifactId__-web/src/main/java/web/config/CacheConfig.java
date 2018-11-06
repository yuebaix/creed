#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package ${package}.web.config;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description : 缓存配置</p>
 * <p>Created on  : 2018-09-27 12:05</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "${package}.web")
@EnableMethodCache(basePackages = {
        "${package}.web",
        "${package}.scene"
})
public class CacheConfig {
}
