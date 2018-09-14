/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.service.impl;

import com.geercode.creed.samples.repo.dao.entity.TFocusListEntity;
import com.geercode.creed.samples.repo.dao.mapper.TFocusListDao;
import com.geercode.creed.samples.service.TFocusListService;
import com.geercode.creed.samples.service.AbstractBaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 重点关注名单 服务实现类
 * </p>
 *
 * @author jerryniu
 * @since 2018-09-14
 */
@Service
public class TFocusListServiceImpl extends AbstractBaseService<TFocusListDao, TFocusListEntity>
        implements TFocusListService {
}
