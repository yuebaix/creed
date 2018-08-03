package com.geercode.creed.samples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jerryniu
 */
@Slf4j
@SpringBootApplication
public class SimpleApp {
	public static void main(String[] args) {
		SpringApplication.run(SimpleApp.class, args);
	}
}
