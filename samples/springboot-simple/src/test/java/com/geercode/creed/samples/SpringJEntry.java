package com.geercode.creed.samples;

import com.geercode.creed.samples.test.SpringJ01;
import com.geercode.creed.samples.test.SpringJ02;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <p>Title       : SpringJEntry</p>
 * <p>Description : 测试套件启动器</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-15 18:24</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@RunWith(Suite.class)
@SuiteClasses({
		/*******  所有SpringTest的类 START  *******/
		SpringJ01.class,
		SpringJ02.class,
		/*******  所有SpringTest的类 END  *******/
})
public class SpringJEntry {}
