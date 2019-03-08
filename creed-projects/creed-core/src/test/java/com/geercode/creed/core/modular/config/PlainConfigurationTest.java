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

package com.geercode.creed.core.modular.config;

import com.geercode.creed.core.modular.config.ancestor.Configuration;
import com.geercode.creed.core.system.log.Logger;
import com.geercode.creed.core.system.log.LoggerFactory;
import org.junit.Test;

/**
 * <p>Description : 配置测试</p>
 * <p>Created on  : 2019-03-08 14:15</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class PlainConfigurationTest {
    private static Logger logger = LoggerFactory.getLogger(PlainConfigurationTest.class);

    @Test
    public void plainTest() {
        Configuration configuration = new PlainConfiguration();
        ((PlainConfiguration) configuration).put("creed.profiles.active", "dev");
        logger.debug(configuration.getProfile());
    }

    @Test
    public void inMemonryTest() {
        InMemoryConfiguration configuration = InMemoryConfiguration.StepBuilder.newBuilder().build();
        logger.debug(configuration.toString());
        InMemoryConfiguration configuration1 = InMemoryConfiguration.StepBuilder.newBuilder()
                .active("dev").and().build();
        logger.debug(configuration1.toString());
        InMemoryConfiguration configuration2 = InMemoryConfiguration.StepBuilder.newBuilder().profile("default")
                .config("retes", "xxxxx").config("creed", "yyyy").and().active("dev").and().build();
        logger.debug(configuration2.toString());
        logger.debug(configuration.getValue("creed"));
        logger.debug(configuration1.getValue("creed"));
        logger.debug(configuration2.getValue("creed"));
    }
}
