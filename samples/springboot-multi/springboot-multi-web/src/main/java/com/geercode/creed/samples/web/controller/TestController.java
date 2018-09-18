/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geercode.creed.samples.repo.dao.entity.TProxyEntity;
import com.geercode.creed.samples.service.TProxyService;
import com.geercode.creed.samples.web.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private static final long TEST_ID = 11906L;
    ///跳过检测

    @Autowired
    private TProxyService tProxyService;

    /**
     * <p>description : testGen</p>
     * <p>create   on : 2018-09-14 16:19:02</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @RequestMapping("/gen")
    public String testGen() {
        TProxyEntity tProxyEntity = new TProxyEntity();
        tProxyEntity.setId(TEST_ID);
        List list = tProxyService.list(new QueryWrapper(tProxyEntity));
        log.debug(list.toString());
        List list1 = tProxyService.getListBySqlId("findCourseById", null);
        log.debug(list1.toString());
        TProxyEntity tProxyEntity1 = (TProxyEntity) tProxyService.getObjectBySqlId("findCourseById_By", null);
        log.debug(tProxyEntity1.toString());
        return "success";
    }

    /**
     * 获取数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex,
            @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        tProxyService.page(page, null);
        return BaseResponse.onSuccess(page);
    }

    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public BaseResponse findAll() {
        List<TProxyEntity> models = tProxyService.list(null);
        return BaseResponse.onSuccess(models);
    }

    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public BaseResponse find(@RequestParam("id") Long id) {
        TProxyEntity entity = tProxyService.getById(id);
        if (entity == null) {
            return BaseResponse.onFail("尚未查询到此ID");
        }
        return BaseResponse.onSuccess(entity);
    }

    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addItem(@RequestBody TProxyEntity entity) {
        boolean isOk = tProxyService.save(entity);
        if (isOk) {
            return BaseResponse.onSuccess("数据添加成功！");
        }
        return BaseResponse.onFail("数据添加失败");
    }

    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateItem(@RequestBody TProxyEntity entity) {
        boolean isOk = tProxyService.updateById(entity);
        if (isOk) {
            return BaseResponse.onSuccess("数据更改成功！");
        }
        return BaseResponse.onFail("数据更改失败");
    }

    /**
     * 删除数据
     */
    @RequestMapping("/del")
    @ResponseBody
    public BaseResponse deleteItems(@RequestParam("ids") List<Long> ids) {
        boolean isOk = tProxyService.removeByIds(ids);
        if (isOk) {
            return BaseResponse.onSuccess("数据删除成功！");
        }
        return BaseResponse.onFail("数据删除失败");
    }
}