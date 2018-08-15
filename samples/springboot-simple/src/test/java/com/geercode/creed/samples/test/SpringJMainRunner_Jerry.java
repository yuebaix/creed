package com.geercode.creed.samples.test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <p>Title       : SpringJEntry</p>
 * <p>Description : SpringTest总执行器</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2017-07-14 17:42</p>
 *
 * @author jerryniu
 * @version 1.0.0
 * SpringTest总执行器</p>使用方法:<br>
 * 1.拷贝本类，修改类名后缀为开发者ID<br>
 * 2.编写测试类,继承SpringJ @see src.test.java.com.jufan.springtest.SpringJ<br>
 * 3.将class注册到此类的SuiteClasses注解中</p>
 * warn:自己的测试类自己管理，测试main下哪个类就起名为该类加后缀Test,植入test下相同路径下<br>
 * 例：给src.main.java.com.jufan.mq.client.XJFQWechatAutoCheckConsumer做测试，
 * 则新建src.test.java.com.jufan.mq.client.XJFQWechatAutoCheckConsumerTest
 * </p>
 */
@RunWith(Suite.class)
@SuiteClasses({
	/*******  所有SpringTest的类 START  *******/
	SpringJ01.class,
	SpringJ02.class,
	/*******  所有SpringTest的类 END  *******/
	})
public class SpringJMainRunner_Jerry {

}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          Note
 * -------------------------------------------------------------------------
 * 1.0           2017年7月14日         Jerry           
 *  
 */