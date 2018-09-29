package com.geercode.creed.samples.service.impl;

import com.geercode.creed.samples.service.TimeService;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: Jerry
 * @date: 2018-04-16 16:52
 */
@Component
public class TimeServiceImpl implements TimeService {
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
	@Override
	public String nower() {
		Date nower = new Date();
		String nowerStr = df.format(nower);
		return nowerStr;
	}
}
