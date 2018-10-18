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

package com.geercode.creed.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>Description : AppStartUpRunner</p>
 * <p>Created on  : 2018-10-18 17:12</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Component
@Log4j2
@Order(Integer.MAX_VALUE)
public class AppStartUpRunner implements ApplicationRunner {
    private static final long SLEEP_SEC = 100000L;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(this.getClass().getSimpleName() + "--->Application启动完毕,开始执行批处理任务");
        Thread.sleep(SLEEP_SEC);
    }
}
