/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.repo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geercode.creed.samples.repo.dao.model.TCompany;

/**
 * <p>Description : 实体操作注册类</p>
 * <p>Created on  : 2018-09-10 15:28</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface BaseModelMapper {
    interface TCompanyMapper extends BaseMapper<TCompany> {
    }
}