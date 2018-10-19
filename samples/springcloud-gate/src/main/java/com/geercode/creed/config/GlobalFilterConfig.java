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

package com.geercode.creed.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * <p>Description : 全局过滤</p>
 * <p>Created on  : 2018-10-19 16:10</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class GlobalFilterConfig {
    /**
     * <p>description : 全局过滤器示例</p>
     * <p>create   on : 2018-10-19 16:50:21</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @Bean
    public GlobalFilter routeReport() {
        return (exchange, chain) -> {
            log.info("first pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("first post filter");
            }));
        };
    }
}
