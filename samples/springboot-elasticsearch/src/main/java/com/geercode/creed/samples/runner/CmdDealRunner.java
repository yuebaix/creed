package com.geercode.creed.samples.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: CmdDealRunner
 * @author: Jerry
 * @date: 2018-04-16 15:21
 */
@Component
@Log4j2
@Order(8888)
public class CmdDealRunner implements ApplicationRunner {
	private String AUTOSTOP = "jufan.autostop";
	public static boolean autostop = false;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (args.containsOption(AUTOSTOP)) {
			List<String> list = args.getOptionValues(AUTOSTOP);
			String autostopFlag = list.get(0);
			if ("true".equals(autostopFlag)) {
				autostop = true;
				log.info(this.getClass().getSimpleName() + "--->设置为自动停止");
			}
		}
		log.info(this.getClass().getSimpleName() + "--->cmd参数处理完毕");
	}
}
