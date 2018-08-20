package com.geercode.creed.samples.controller;

import com.geercode.creed.samples.buildtest.group.BuildTests;
import com.geercode.creed.samples.buildtest.spring.SpringJ;
import com.geercode.creed.samples.service.DemoService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
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
@Category(BuildTests.class)
public class DemoControllerTest extends SpringJ {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private DemoService demoService;

	@Test
	public void helloTest() throws Exception {
		Mockito.when(demoService.hello()).thenReturn("hello");

		mvc.perform(MockMvcRequestBuilders.get("/demo/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("hello")))
				.andDo(MockMvcResultHandlers.print());
		System.out.println(1);
	}
}

