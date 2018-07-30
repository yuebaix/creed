package com.jufan.creed.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: 示例接口</p>
 *
 * @author Jerry
 * @date 2018-07-30 21:28
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
