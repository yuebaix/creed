/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.geercode.creed.samples.repo.dao.entity.TCompany;
import com.geercode.creed.samples.service.TCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : 测试控制器</p>
 * <p>Created on  : 2018-09-10 18:56</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    private static final long TEST_ID = 1007L;
    @Autowired
    private TCompanyService tCompanyService;
    ///跳过检测
    /*@Autowired
    private TProxyService tProxyService;*/

    /**
     * <p>description : testDao</p>
     * <p>create   on : 2018-09-10 18:59:59</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @RequestMapping("/dao")
    public String testDao() {
        TCompany tCompany = new TCompany();
        tCompany.setId(TEST_ID);
        List list = tCompanyService.list(new QueryWrapper(tCompany));
        log.debug(list.toString());
        TCompany tCompany1 = tCompanyService.getById(TEST_ID);
        log.debug(tCompany1.toString());
        return "success";
    }
    /// 跳过检测
    /*@RequestMapping("/gen")
    public String testGen() {
        TProxyEntity tProxyEntity = new TProxyEntity();
        List list = tProxyService.list(new QueryWrapper(tProxyEntity));
        log.debug(list.toString());
        List list1 = tProxyService.getListBySqlId("findCourseById", null);
        System.out.println(list1.toString());
        TProxyEntity tProxyEntity1 = (TProxyEntity)tProxyService.getObjectBySqlId("findCourseById_By", null);
        System.out.println(tProxyEntity1);
        return "success";
    }*/
}
