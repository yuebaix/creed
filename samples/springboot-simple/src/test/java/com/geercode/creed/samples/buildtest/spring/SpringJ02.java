package com.geercode.creed.samples.buildtest.spring;

import com.geercode.creed.samples.buildtest.group.SlowTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SlowTests.class)
public class SpringJ02 extends SpringJ {
	@Test
	public void test1() {
		System.err.println("test3");
	}
	@Test
	public void test2() {
		System.err.println("test4");
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2017年7月14日         Jerry           
 *  
 */