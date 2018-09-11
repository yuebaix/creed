/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.service.impl;

import com.geercode.creed.samples.repo.dao.mapper.BaseModelMapper;
import com.geercode.creed.samples.repo.dao.model.TCompany;
import com.geercode.creed.samples.service.AbstractBaseService;
import com.geercode.creed.samples.service.TCompanyService;
import org.springframework.stereotype.Service;

/**
 * <p>Description : 服务实现类</p>
 * <p>Created on  : 2018-09-10 15:32</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Service
public class TCompanyServiceImpl extends AbstractBaseService<BaseModelMapper.TCompanyMapper, TCompany>
        implements TCompanyService {
}
