package com.geercode.creed.samples.runner;

import com.geercode.creed.samples.batch.SimpleBatch;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @description: 容器启动后执行一些事<br>
 *               ContextClosedEvent   、ContextRefreshedEvent  、ContextStartedEvent  、ContextStoppedEvent   、RequestHandleEvent
 * @author: Jerry
 * @date: 2017-12-18 19:53
 */
@Component
@Log4j2
public class CtxUpRunner implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private SimpleBatch simpleBatch;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		log.info(this.getClass().getSimpleName() + "--->ApplicationContext启动完毕");
	}
}
