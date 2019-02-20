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

package com.geercode.creed.controler;

import com.geercode.creed.facade.common.FooFeignResp;
import com.geercode.creed.facade.dto.InnerDto;
import com.geercode.creed.facade.dto.ShowMeDto;
import com.geercode.creed.facade.service.ConsulServiceFeignService;
import com.geercode.creed.stub.DemoDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description : </p>
 * <p>Created on  : 2018-10-23 18:31</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
@Slf4j
@RefreshScope
public class TestController {
    ///
    /*@Value("${noob}")
    private String noob;*/

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ConsulServiceFeignService consulServiceFeignService;
    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:12345", lazy = true)
    private DemoDubboService demoDubboService;

    ///
    /*@GetMapping("/getConfig")
    public String getConfig(String key) {
        log.debug(noob);
        return noob;
    }*/

    /**
     * <p>description : </p>
     * <p>create   on : 2018-12-26 14:28:58</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @RequestMapping("test")
    public String test() {
        String url = "http://sc-consul-service:10203/test/getConfig?key=1";
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-12-26 14:29:02</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @RequestMapping("showme")
    public String showme() {
        ShowMeDto showMeDto = new ShowMeDto();
        log.debug(showMeDto.getVer());
        InnerDto inner = new InnerDto();
        inner.setWhat(2);
        showMeDto.setInner(inner);
        FooFeignResp resp = consulServiceFeignService.showMe(showMeDto);
        return resp.getCode();
    }

    /**
     * <p>description : </p>
     * <p>create   on : 2018-12-26 14:29:02</p>
     *
     * @author jerryniu
     * @since 1.0.0
     */
    @RequestMapping("simple")
    public String simple() {
        log.info("simple!!!");
        log.error("simple_error!!!");
        if (true) {
            throw new RuntimeException("Exception");
        }
        return "simple";
    }

    @GetMapping("testDubbo")
    public String testDubbo() {
        log.info("consumer");
        return demoDubboService.sayHello("hi");
    }
}
