/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.samples;

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
@SuiteClasses(
        SpringJLocalEntryJerry.class
)
public class SpringJLocalEntry {
}
