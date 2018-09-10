/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>Description : springboot多模块示例启动类</p>
 * <p>Created on  : 2018-09-10 15:49</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@EnableAutoConfiguration
@ComponentScan("com.geercode.creed.samples")
public class MultiApp {
    /**
     * <p>description : 程序入口</p>
     * <p>create   on : 2018-08-07 18:32:40</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public static void main(String[] args) {
        SpringApplication.run(MultiApp.class, args);
    }
}
