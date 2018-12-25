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

import com.geercode.creed.CreedConsulServiceApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.context.ConfigurableWebServerApplicationContext;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * <p>Description : servlet配置,打war包使用</p>
 * <p>Created on  : 2018-10-11 12:57</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */

@Configuration
public class ServletInitialConfig extends SpringBootServletInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private static boolean isNeedToRegister = false;
    @Autowired
    private ServerProperties serverProperties;
    @Autowired
    private ConsulAutoServiceRegistration autoServiceRegistration;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        isNeedToRegister = true;
        return builder.sources(CreedConsulServiceApp.class);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        if (isNeedToRegister) {
            if (!(context instanceof ConfigurableWebServerApplicationContext) || !"management".equals(((ConfigurableWebServerApplicationContext)context).getServerNamespace())) {
                autoServiceRegistration.setPort(serverProperties.getPort());
                autoServiceRegistration.start();
            }
        }
    }
}
