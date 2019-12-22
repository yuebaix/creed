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

import com.geercode.creed.core.modular.config.ancestor.AbstractConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : 简易配置类</p>
 * <p>Created on  : 2019-03-08 12:45</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class PlainConfiguration extends AbstractConfiguration {
    private static Map<String, String> configHolder = new HashMap();

    @Override
    public String getProfile() {
        String activeProfile = configHolder.get(PROFILE_KEY);
        if (activeProfile == null) {
            activeProfile = DEFAUL_PROFILE;
        }
        return activeProfile;
    }

    @Override
    public String getValue(String key) {
        return configHolder.get(key);
    }

    @Override
    public void refresh() {
    }

    public void put(String key, String value) {
        configHolder.put(key, value);
    }
}
