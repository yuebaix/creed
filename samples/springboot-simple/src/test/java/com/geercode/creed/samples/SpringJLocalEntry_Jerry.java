package com.geercode.creed.samples;

import com.geercode.creed.samples.controller.DemoControllerTest;
import com.geercode.creed.samples.controller.DemoControllerTest2;
import com.geercode.creed.samples.service.DemoServiceImplTest;
import com.geercode.creed.samples.service.DemoServiceImplTest2;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <p>Title       : SpringJLocalEntry</p>
 * <p>Description : 测试套件启动器</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-15 18:24</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@RunWith(Categories.class)
//@Categories.IncludeCategory({SlowTests.class, FastTests.class})
//@Categories.ExcludeCategory(FastTests.class)
@SuiteClasses({
        /*******  所有需要测试的类 START  *******/
        DemoControllerTest.class,
        DemoControllerTest2.class,
        DemoServiceImplTest.class,
        DemoServiceImplTest2.class
        /*******  所有需要测试的类 END  *******/
})
public class SpringJLocalEntry_Jerry {
}
