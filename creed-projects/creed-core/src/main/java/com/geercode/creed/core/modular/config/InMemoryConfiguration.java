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

import com.geercode.creed.core.lang.VerboseConstants;
import com.geercode.creed.core.modular.config.ancestor.AbstractConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : 内存配置类</p>
 * <p>Created on  : 2019-03-08 12:46</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class InMemoryConfiguration extends AbstractConfiguration {
    private String activeProfile;
    private Map<String, Map<String, String>> configHolder;

    public InMemoryConfiguration() {
        refresh();
    }

    @Override
    public String getProfile() {
        return activeProfile;
    }

    @Override
    public String getValue(String key) {
        String value = null;
        if (activeProfile != null && !DEFAUL_PROFILE.equals(activeProfile)) {
            Map<String, String> activeMap = configHolder.get(activeProfile);
            if (activeMap != null) {
                value = activeMap.get(key);
            }
            if (value == null) {
                Map<String, String> defaultMap = configHolder.get(DEFAUL_PROFILE);
                if (defaultMap != null) {
                    value = defaultMap.get(key);
                }
            }
        } else {
            Map<String, String> defaultMap = configHolder.get(DEFAUL_PROFILE);
            if (defaultMap != null) {
                value = defaultMap.get(key);
            }
        }
        return value;
    }

    @Override
    public void refresh() {
        activeProfile = DEFAUL_PROFILE;
        configHolder = new HashMap(VerboseConstants.DEFAULT_HASHMAP_SIZE);
        configHolder.put(DEFAUL_PROFILE, new HashMap(VerboseConstants.DEFAULT_HASHMAP_SIZE));

        String profile = configHolder.get(DEFAUL_PROFILE).get(PROFILE_KEY);
        if (profile == null) {
            activeProfile = DEFAUL_PROFILE;
        } else {
            activeProfile = profile;
        }
    }

    public void setActiveProfile(String activeProfile) {
        this.activeProfile = activeProfile;
    }

    public void setConfigHolder(Map<String, Map<String, String>> configHolder) {
        this.configHolder = configHolder;
    }

    @Override
    public String toString() {
        return "InMemoryConfiguration{" + "activeProfile='" + activeProfile + '\''
                + ", configHolder=" + configHolder + '}';
    }

    public static class StepBuilder {

        public static PhaseStep newBuilder() {
            return new Steps();
        }

        public interface PhaseStep {
            /**
             * <p>description : 添加配置</p>
             *
             * @param key 配置key
             * @param value 配置value
             * @return 添加配置步骤
             */
            ConfigStep config(String key, String value);

            /**
             * <p>description : 配置profile归属</p>
             *
             * @param profile profile名
             * @return 添加配置步骤
             */
            ConfigStep profile(String profile);

            /**
             * <p>description : 配置激活的profile</p>
             *
             * @param activeProfile 激活profile名
             * @return 启动配置步骤
             */
            SetupStep active(String activeProfile);

            /**
             * <p>description : 构建</p>
             *
             * @return 内存配置类
             */
            InMemoryConfiguration build();
        }

        public interface ConfigStep {
            /**
             * <p>description : 添加配置</p>
             *
             * @param key 配置key
             * @param value 配置value
             * @return 添加配置步骤
             */
            ConfigStep config(String key, String value);

            /**
             * <p>description : 转到phase步骤</p>
             *
             * @return 阶段步骤
             */
            PhaseStep and();
        }

        public interface SetupStep {
            /**
             * <p>description : 转到phase步骤</p>
             *
             * @return 阶段步骤
             */
            PhaseStep and();
        }

        private static class Steps implements PhaseStep, ConfigStep, SetupStep {
            private String activeProfile;
            private Map<String, Map<String, String>> configHolder;

            private String profileCache;
            private Map<String, String> kvCache;

            Steps() {
                activeProfile = DEFAUL_PROFILE;
                configHolder = new HashMap(VerboseConstants.DEFAULT_HASHMAP_SIZE);
                configHolder.put(DEFAUL_PROFILE, new HashMap(VerboseConstants.DEFAULT_HASHMAP_SIZE));
            }

            @Override
            public ConfigStep config(String key, String value) {
                if (kvCache == null) {
                    kvCache = new HashMap(VerboseConstants.DEFAULT_HASHMAP_SIZE);
                }
                kvCache.put(key, value);
                return this;
            }

            @Override
            public PhaseStep and() {
                String profile = null;
                if (profileCache == null) {
                    profile = DEFAUL_PROFILE;
                } else {
                    profile = profileCache;
                }

                Map profileConfig = configHolder.get(profile);

                if (profileConfig == null) {
                    profileConfig = kvCache;
                } else {
                    if (kvCache != null) {
                        profileConfig.putAll(kvCache);
                    }
                }
                configHolder.put(profile, profileConfig);

                profileCache = null;
                kvCache = null;
                return this;
            }

            @Override
            public ConfigStep profile(String profile) {
                this.profileCache = profile;
                return this;
            }

            @Override
            public SetupStep active(String profile) {
                this.activeProfile = profile;
                return this;
            }

            @Override
            public InMemoryConfiguration build() {
                InMemoryConfiguration configuration = new InMemoryConfiguration();
                configuration.setActiveProfile(activeProfile);
                configuration.setConfigHolder(configHolder);
                return configuration;
            }
        }
    }
}
