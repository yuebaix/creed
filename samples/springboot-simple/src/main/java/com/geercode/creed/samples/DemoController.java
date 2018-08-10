package com.geercode.creed.samples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title       : DemoController</p>
 * <p>Description : Demo 接口</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-07 18:30</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	/**
	 * <p>description : 测试接口</p>
	 * <p>create   on : 2018-08-07 18:31:22</p>
	 * @author: jerryniu
	 * todo
	 * fixme
	 */
	@GetMapping("/hello")
	public String hello() {
//		String str = null;
//		System.out.println(str.split("1"));
		return "hello";
	}
}
