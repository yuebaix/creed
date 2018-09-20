/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config;

import com.geercode.creed.samples.web.common.SystemConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Description : mvc配置类</p>
 * <p>Created on  : 2018-09-20 16:11</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //测试与开发环境开启swagger
        if (SystemConstant.PROFILE_DEV.equals(profile) || SystemConstant.PROFILE_TEST.equals(profile)) {
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }
}
