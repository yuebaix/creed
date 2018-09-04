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

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title       : SimpleApp</p>
 * <p>Description : 简单示例启动类</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-07 18:32</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Slf4j
@SpringBootApplication
public class SimpleApp {
    /**
     * <p>description : 程序入口</p>
     * <p>create   on : 2018-08-07 18:32:40</p>
     *
     * @author: jerryniu
     */
    public static void main(String[] args) {
        SpringApplication.run(SimpleApp.class, args);
    }
}
