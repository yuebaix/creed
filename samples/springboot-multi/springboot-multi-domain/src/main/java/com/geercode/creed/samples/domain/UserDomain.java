/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>Description : 用户领域实体</p>
 * <p>Created on  : 2018-11-06 15:15</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class UserDomain {
    private long id;
    private String name;
}
