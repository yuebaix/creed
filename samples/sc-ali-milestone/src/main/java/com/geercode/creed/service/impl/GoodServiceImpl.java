/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.service.impl;

import com.geercode.creed.repo.dao.entity.GoodEntity;
import com.geercode.creed.repo.dao.mapper.GoodDao;
import com.geercode.creed.service.GoodService;
import com.geercode.creed.service.AbstractBaseService;
import org.springframework.stereotype.Service;

/**
 * <p> 服务实现类</p>
 *
 * @author jerryniu
 * @since 2019-05-09
 */
@Service
public class GoodServiceImpl extends AbstractBaseService<GoodDao, GoodEntity>
        implements GoodService {
}
