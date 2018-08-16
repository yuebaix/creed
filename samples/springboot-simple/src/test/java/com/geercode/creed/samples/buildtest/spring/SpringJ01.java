package com.geercode.creed.samples.buildtest.spring;

import com.geercode.creed.samples.buildtest.group.FastTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(FastTests.class)
public class SpringJ01 extends SpringJ {
	@Test
	public void test1() {
		System.err.println("test1");
	}
	@Test
	public void test2() {
		System.err.println("test2");
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