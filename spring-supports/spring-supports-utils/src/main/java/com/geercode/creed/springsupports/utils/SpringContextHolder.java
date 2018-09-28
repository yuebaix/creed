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

package com.geercode.creed.springsupports.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * <p>Description : Spring的ApplicationContext, Environment获取器(存在多线程安全问题,多线程环境禁用)</p>
 * <p>Created on  : 2017-12-18 20:08</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Slf4j
public class SpringContextHolder implements ApplicationContextAware, EnvironmentAware {
    private ApplicationContext context;
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        log.info(this.getClass().getSimpleName() + "--->Environment注入完成");
    }

    public String getProperty(String key) {
        return environment.getProperty(key);
    }

    public ApplicationContext getApplicationContext() {
        return this.context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;
        log.info(this.getClass().getSimpleName() + "--->ApplicationContext注入完成");
    }

    public <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return context.getBeansOfType(clazz);
    }

    public Object getBean(String name) {
        return context.getBean(name);
    }

    public <T> T getBean(Class<T> clazz) {
        T bean = context.getBean(clazz);
        return bean;
    }

    public void publishEvent(ApplicationEvent event) {
        context.publishEvent(event);
    }
}
