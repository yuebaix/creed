package com.geercode.creed.samples.foo;

import com.geercode.creed.samples.buildtest.group.BuildTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * @author Jerry
 */
@Category(BuildTests.class)
public class CoverTest {
	@Test
	public void test1() {
		System.out.println("coveralls");
//		String str = null;
//		System.out.println(str.split("1"));
	}
}
