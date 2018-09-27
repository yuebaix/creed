/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>Description : 测试swagger</p>
 * <p>Created on  : 2018-08-27 21:55</p>
 *
 * 增POST 删DELETE 改PUT 查GET
 * CRUD (POST GET PUT DELETE)
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Api(tags = "测试接口")
@Slf4j
@RestController
@RequestMapping("/demo")
@CacheConfig(cacheNames = "123")
public class DemoController {
    private static final int NUMBVALUE0 = 0;
    private static final int NUMBVALUE1 = 1;
    private static final int NUMBVALUE2 = 2;
    private static final int NUMBVALUE5 = 5;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * <p>description : 测试获取姓名</p>
     * <p>create   on : 2018-09-05 18:18:53</p>
     *
     * @param userNumber 用户id
     * @return java.lang.String 修改结果
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @ApiOperation(value = "获取用户姓名", notes = "用用户ID获取用户姓名: 仅1和2有正确返回")
    @ApiImplicitParam(name = "userNumber", value = "用户ID # Integer", required = true)
    @GetMapping("/getUserName")
    public String getUserName(@RequestParam int userNumber) {
        if (userNumber == NUMBVALUE1) {
            return "张三丰";
        } else if (userNumber == NUMBVALUE2) {
            return "慕容复";
        } else {
            return "未知";
        }
    }

    /**
     * <p>description : 测试修改用户密码</p>
     * <p>create   on : 2018-09-05 18:18:02</p>
     *
     * @return java.lang.String 修改结果
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @ApiOperation(value = "修改用户密码", notes = "根据用户id修改密码<br>新旧密码不能相同<br>用户ID必须在0与5之间")
    @PostMapping("/updatePassword")
    public Date updatePassword(Date date) {
        return date;
    }

    /**
     * <p>description : test</p>
     * <p>create   on : 2018-09-17 17:18:23</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @ApiOperation(value = "测试swagger entity mapping", notes = "测试一下")
    @PostMapping("/model")
    public LocalDateTime test(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return date;
    }

    @Cacheable
    @GetMapping("/redis")
    public String testRedis(String id) {
        return stringRedisTemplate.opsForValue().getAndSet("123", "456");
    }
}