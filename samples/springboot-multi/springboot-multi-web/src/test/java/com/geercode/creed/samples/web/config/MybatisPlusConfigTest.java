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

package com.geercode.creed.samples.web.config;

import com.geercode.creed.samples.repo.dao.entity.TCompanyEntity;
import com.geercode.creed.samples.service.TCompanyService;
import com.geercode.creed.springsupports.test.SpringJ;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Description : mybatisplus配置测试</p>
 * <p>Created on  : 2018-09-20 12:49</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class MybatisPlusConfigTest extends SpringJ {
    @Autowired
    private TCompanyService tCompanyService;

    @Test
    public void insertTest() {
        TCompanyEntity tCompanyEntity = new TCompanyEntity();
        tCompanyEntity.setMemo("测试mybatisplus");
        tCompanyEntity.setName("测试mybatisplus");
        tCompanyEntity.setOrgNo("测试mybatisplus");
        tCompanyEntity.setCity("测试mybatisplus");
        tCompanyService.save(tCompanyEntity);
        System.out.println("end");
    }

    @Test
    public void updateTest() {
        TCompanyEntity tCompanyEntity = new TCompanyEntity();
        tCompanyEntity.setId(1041568088552849412L);
        tCompanyEntity.setMemo("这才不是测试mybatisplus");
        tCompanyEntity.setName("这才不是测试mybatisplus");
        tCompanyEntity.setOrgNo("这才不是测试mybatisplus");
        tCompanyEntity.setCity("这才不是测试mybatisplus");
        tCompanyService.saveOrUpdate(tCompanyEntity);
        System.out.println("end");
    }
}
