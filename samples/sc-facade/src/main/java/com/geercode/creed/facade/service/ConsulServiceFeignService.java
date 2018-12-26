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
import com.geercode.creed.facade.dto.ShowMeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>description : </p>
 *
 * @author jerryniu
 * @since 2018-12-25
 */
@FeignClient(name = Constants.CONSUL_SERVICE_FEIGN_SERVICE)
public interface ConsulServiceFeignService {

    /**
     * <p>description : </p>
     * <p>create   on : 2018-12-26 13:46:19</p>
     *
     * @author jerryniu
     * @since 1.0.0
     *
     * @param dto 示例参数
     * @return java.lang.String 示例报文
     */
    @PostMapping("/test/showme")
    String showMe(@RequestBody ShowMeDto dto);
}
