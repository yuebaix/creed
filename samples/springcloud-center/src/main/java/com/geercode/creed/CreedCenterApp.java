/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */
package com.geercode.creed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>Description : 注册中心</p>
 * <p>Created on  : 2018-10-16 19:03</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class CreedCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(CreedCenterApp.class, args);
    }
}
