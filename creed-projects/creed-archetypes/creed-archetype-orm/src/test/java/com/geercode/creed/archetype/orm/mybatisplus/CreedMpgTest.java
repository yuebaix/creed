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

package com.geercode.creed.archetype.orm.mybatisplus;

import com.geercode.creed.archetype.orm.CreedOrm;
import org.junit.Test;

/**
 * <p>Description : 生成代码测试</p>
 * <p>Created on  : 2018-09-12 12:58</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class CreedMpgTest {
    @Test
    public void getSrcPath() {
        MpgPathConfig mpc = new MultiModulePathConfig().init();
        System.out.println(mpc.getEntityDir());
    }

    @Test
    public void getSrcPathStandalone() {
        MpgPathConfig mpc = new StandalonePathConfig().init();
        System.out.println(mpc.getEntityDir());
    }

    @Test
    public void genAllTest() {
        //CreedOrm.mpg().genAll();
        //CreedOrm.mpg().genXml();
        //CreedOrm.mpg().genBase();
        CreedOrm.mpgStandalone().genAll();
        CreedOrm.mpg().genXml();
    }
}
