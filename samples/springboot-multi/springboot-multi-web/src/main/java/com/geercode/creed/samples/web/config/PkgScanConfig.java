/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description : 包扫描配置</p>
 * <p>Created on  : 2018-09-10 20:10</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.geercode.creed.samples")
public class PkgScanConfig {
}
