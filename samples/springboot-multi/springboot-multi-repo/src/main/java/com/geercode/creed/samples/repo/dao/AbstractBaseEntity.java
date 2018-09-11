/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.repo.dao;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>Description : 基础实体</p>
 * <p>Created on  : 2018-09-10 15:28</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public abstract class AbstractBaseEntity<T extends Model> extends Model<T> {
}
