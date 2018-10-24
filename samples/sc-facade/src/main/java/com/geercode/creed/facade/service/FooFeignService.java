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

package com.geercode.creed.facade.service;

import com.geercode.creed.facade.common.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Description : 示例feign服务</p>
 * <p>Created on  : 2018-10-24 20:03</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@FeignClient(value = Constants.FOO_FEIGN_SERVICE)
public interface FooFeignService {

    /**
     * <p>description : 检测服务接口</p>
     * <p>create   on : 2018-10-24 20:20:01</p>
     *
     * @return java.lang.String 示例报文
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/test/check")
    String testCheck();
}
