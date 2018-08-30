package com.geercode.creed.samples.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Title       : SayController</p>
 * <p>Description : 测试swagger</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-27 21:55</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Api(tags = "测试接口")
@Slf4j
@RestController
@RequestMapping("/say")
public class SayController {

    private static final int NUMBVALUE0 = 0;
    private static final int NUMBVALUE1 = 1;
    private static final int NUMBVALUE2 = 2;
    private static final int NUMBVALUE5 = 5;

    /**
     * <p>description : 测试获取姓名</p>
     * <p>create   on : 2018-08-30 18:08:15</p>
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
     * <p>create   on : 2018-08-30 18:08:26</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @ApiOperation(value = "修改用户密码", notes = "根据用户id修改密码<br>新旧密码不能相同<br>用户ID必须在0与5之间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID # Integer", required = true),
            @ApiImplicitParam(name = "password", value = "旧密码 # String", required = true),
            @ApiImplicitParam(name = "newPassword", value = "新密码 # String", required = true)
    })
    @PostMapping("/updatePassword")
    public String updatePassword(int userId, String password, String newPassword) {
        if (userId <= NUMBVALUE0 || userId > NUMBVALUE5) {
            return "未知的用户";
        }
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)) {
            return "密码不能为空";
        }
        if (password.equals(newPassword)) {
            return "新旧密码不能相同";
        }
        return "密码修改成功!";
    }
}