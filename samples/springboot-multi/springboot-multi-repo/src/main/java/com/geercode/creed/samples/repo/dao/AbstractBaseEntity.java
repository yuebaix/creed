/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.repo.dao;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>基础实体</p>
 *
 * @author jerryniu
 * @since 2018-09-25
 */
public abstract class AbstractBaseEntity<T extends Model> extends Model<T> {
}