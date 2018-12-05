/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config.statemachine;

import lombok.Data;

/**
 * <p>Description : 订单实体</p>
 * <p>Created on  : 2018-11-14 14:21</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Data
public class OrderDomain {
    private long id;
    private String state;
}
