package com.geercode.creed.samples.runner;

import com.geercode.creed.samples.batch.SimpleBatch;
import com.geercode.creed.samples.common.SpringContextHolder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: AppStartUpRunner
 * @author: Jerry
 * @date: 2018-04-16 15:21
 */
@Component
@Log4j2
@Order(Integer.MAX_VALUE)
public class AppStartUpRunner implements ApplicationRunner {
	@Autowired
	private SpringContextHolder ctxholder;
	@Resource(name = "batchpool")
	private ThreadPoolTaskExecutor batchpool;
	@Autowired
	private SimpleBatch simpleBatch;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info(this.getClass().getSimpleName() + "--->Application启动完毕,开始执行批处理任务");

		/****************实现批处理任务******************/
		//示例
		simpleBatch.executeBatchTask();

		simpleBatch.executeEsTask();

		//异步触发退出jvm任务(所有任务完成后)
		if (CmdDealRunner.autostop) {
			exitJvm();
		}
	}

	private void exitJvm() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;) {
					try {
						//每隔一秒检测一次
						Thread.sleep(1000);
						if (batchpool.getActiveCount() == 0) {
							batchpool.shutdown();
						}
						//判断任务线程池是否停止
						if (batchpool.getThreadPoolExecutor().isTerminated()) {
							log.info(this.getClass().getSimpleName() + "--->批处理任务执行完毕，jvm虚拟机关闭");
							ctxholder.publishEvent(new ContextStoppedEvent(ctxholder.getApplicationContext()));
							System.exit(0);
						}
					} catch (Exception e) {
						log.error("关闭虚拟机异常{}", e);
					}
				}
			}
		}).start();
	}
}
