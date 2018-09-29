package com.geercode.creed.samples.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

@Configuration
@EnableAsync(proxyTargetClass=true)
public class TheadPoolConfig {
	/*************batchpool线程池****************/
	@Resource(name = "batchpoolMeta")
	private ThreadPoolMeta batchpoolMeta;

	@Bean(name = "batchpoolMeta")
	@ConfigurationProperties(prefix = "jufan.threadpool.batchpool")
	public ThreadPoolMeta batchpoolMeta() {
		return new ThreadPoolMeta();
	}

	@Bean(name="batchpool")
	public ThreadPoolTaskExecutor batchpoolExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(batchpoolMeta.getCorePoolSize());
		pool.setMaxPoolSize(batchpoolMeta.getMaxPoolSize());
		pool.setKeepAliveSeconds(batchpoolMeta.getKeepAliveSeconds());
		pool.setQueueCapacity(batchpoolMeta.getQueueCapacity());
		pool.setThreadNamePrefix(batchpoolMeta.getThreadNamePrefix());
		return pool;
	}
	/*****************************/
	@Data
	private class ThreadPoolMeta {
		private String threadNamePrefix;
		private int corePoolSize;
		private int maxPoolSize;
		private int keepAliveSeconds;
		private int queueCapacity;
	}
}
