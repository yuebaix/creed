/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.service.impl;

import com.geercode.creed.samples.repo.dao.entity.TProxyEntity;
import com.geercode.creed.samples.repo.dao.mapper.TProxyDao;
import com.geercode.creed.samples.service.TProxyService;
import com.geercode.creed.samples.service.AbstractBaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 代理池 服务实现类
 * </p>
 *
 * @author jerryniu
 * @since 2018-09-14
 */
@Service
public class TProxyServiceImpl extends AbstractBaseService<TProxyDao, TProxyEntity>
        implements TProxyService {
}
