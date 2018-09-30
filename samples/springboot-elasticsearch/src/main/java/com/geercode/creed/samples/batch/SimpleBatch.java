package com.geercode.creed.samples.batch;

import com.geercode.creed.samples.service.BankService;
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
	private BankService bankService;
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

	@Async("batchpool")
	public void executeEsTask() {
		bankService.query("上海长宁招商");
		/*Bank bank = new Bank();
		bank.setId(0);
		bank.setName("宇宙洪荒破产第一爱存不存工商银行长宁破烂行");
		bank.setCode("0001");
		bank.setAddress("上海徐汇");
		bankService.add(bank);
		bank.setId(1);
		bank.setName("农业银行");
		bankService.add(bank);
		bank.setId(2);
		bank.setName("长宁支行--(招商银行)");
		bankService.add(bank);
		bank.setId(3);
		bank.setName("从来没用过的浦发银行");
		bankService.add(bank);
		bank.setId(4);
		bank.setName("上海招商银行");
		bankService.add(bank);
		bank.setId(5);
		bank.setName("北京农业银行");
		bankService.add(bank);
		bank.setId(6);
		bank.setName("上海浦发银行");
		bankService.add(bank);
		bank.setId(7);
		bank.setName("上海中信银行");
		bankService.add(bank);
		bank.setId(8);
		bank.setName("招商银行上海分行长宁支行");
		bankService.add(bank);*/
		log.info("修改成功");
	}
}
