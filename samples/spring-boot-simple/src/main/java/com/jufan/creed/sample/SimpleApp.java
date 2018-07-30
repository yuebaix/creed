package com.jufan.creed.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Description: spring2.0简单例子</p>
 * @author Jerry
 * @date 2018-07-30 21:04
 */
@Slf4j
@SpringBootApplication
public class SimpleApp {
	public static void main(String[] args) {
		SpringApplication.run(SimpleApp.class, args);
	}
}
