package com.geercode.creed.samples.controller;

import com.geercode.creed.samples.buildtest.group.BuildTests;
import com.geercode.creed.samples.buildtest.spring.SpringJ;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>Title       : SayControllerTest</p>
 * <p>Description : SayController测试类</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-09-04 13:50</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Slf4j
@Category(BuildTests.class)
public class SayControllerTest extends SpringJ {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getUserNameTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/say/getUserName?userNumber=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("张三丰")));
        mvc.perform(MockMvcRequestBuilders.get("/say/getUserName?userNumber=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("慕容复")));
        mvc.perform(MockMvcRequestBuilders.get("/say/getUserName?userNumber=3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("未知")));
    }

    @Test
    public void updatePasswordTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/say/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .param("userId", "-1")
                .param("password", "123")
                .param("newPassword", "321"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("未知的用户")));
        mvc.perform(MockMvcRequestBuilders.post("/say/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .param("userId", "1")
                .param("password", "")
                .param("newPassword", "321"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("密码不能为空")));
        mvc.perform(MockMvcRequestBuilders.post("/say/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .param("userId", "1")
                .param("password", "123")
                .param("newPassword", "123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("新旧密码不能相同")));
        mvc.perform(MockMvcRequestBuilders.post("/say/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .param("userId", "1")
                .param("password", "123")
                .param("newPassword", "321"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("密码修改成功!")))
                .andDo(MockMvcResultHandlers.print());
    }
}
