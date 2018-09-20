/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.service.impl;

import com.geercode.creed.samples.repo.dao.entity.TCompanyEntity;
import com.geercode.creed.samples.repo.dao.mapper.TCompanyDao;
import com.geercode.creed.samples.service.TCompanyService;
import com.geercode.creed.samples.service.AbstractBaseService;
import org.springframework.stereotype.Service;

/**
 * <p>公司基本信息表 服务实现类</p>
 *
 * @author jerryniu
 * @since 2018-09-20
 */
@Service
public class TCompanyServiceImpl extends AbstractBaseService<TCompanyDao, TCompanyEntity>
        implements TCompanyService {
}
