package com.geercode.creed.samples.controller;

import com.geercode.creed.samples.buildtest.spring.SpringJ;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>Title       : DemoControllerTest</p>
 * <p>Description : DemoController测试类</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-16 17:07</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@AutoConfigureMockMvc
public class DemoControllerTest extends SpringJ {
	@Autowired
	private MockMvc mvc;

	@Test
	public void helloTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/demo/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("hello")));
	}
}
