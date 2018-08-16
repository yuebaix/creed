package com.geercode.creed.samples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * <p>Title       : SimpleApp</p>
 * <p>Description : 简单示例启动类</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-07 18:32</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Slf4j
@SpringBootApplication
public class SimpleApp {
	/**
	 * <p>description : 程序入口</p>
	 * <p>create   on : 2018-08-07 18:32:40</p>
	 * @author: jerryniu
	 */
	public static void main(String[] args) {
		///
//		String str = null;
//		System.out.println(str.split("1"));
		SpringApplication.run(SimpleApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
}
