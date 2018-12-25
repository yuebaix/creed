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

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

    ///
    /*@GetMapping("/getConfig")
    public String getConfig(String key) {
        log.debug(noob);
        return noob;
    }*/

    @RequestMapping("test")
    public String test() {
        String url = "http://sc-consul-service:10203/test/getConfig?key=1";
        return restTemplate.getForObject(url, String.class);
    }
}
