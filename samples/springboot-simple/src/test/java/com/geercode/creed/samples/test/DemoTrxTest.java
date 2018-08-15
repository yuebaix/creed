package com.geercode.creed.samples.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

public class DemoTrxTest extends SpringJ {
	@Test
//	@Transactional
	public void doTest() {
		
	}
	public void test() {
		System.err.println("test");
	}
	@Before
	public void before() {
		System.err.println("before");
	}
	@After
	public void after() {
		System.err.println("after");
	}
	@BeforeTransaction
	public void beforeTx() {
		System.err.println("beforeTx");
	}
	@AfterTransaction
	public void afterTx() {
		System.err.println("afterTx");
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