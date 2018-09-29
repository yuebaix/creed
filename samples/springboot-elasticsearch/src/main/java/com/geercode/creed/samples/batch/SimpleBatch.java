package com.geercode.creed.samples.batch;

import com.geercode.creed.samples.service.TimeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description: 简单示例
 * @author: Jerry
 * @date: 2017-12-18 19:42
 */
@Component
@Log4j2
public class SimpleBatch {

	@Autowired
	private TimeService timeService;
	@Async("batchpool")
	public void executeBatchTask() {
		for (int i =0; i < 10; i++) {
			log.info("CurrentTime is " + timeService.nower());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}
