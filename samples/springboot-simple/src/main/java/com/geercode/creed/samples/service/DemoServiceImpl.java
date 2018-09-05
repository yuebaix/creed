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

package com.geercode.creed.samples.service;

import com.geercode.creed.samples.domain.UserDomain;
import org.springframework.stereotype.Service;

/**
 * <p>Description : DemoServiceImpl</p>
 * <p>Created on  : 2018-08-17 14:24</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello() {
        UserDomain user = new UserDomain();
        user.setId(1);
        user.setName("jerry");
        return user.sayHi();
    }
}
