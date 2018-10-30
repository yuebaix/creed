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

package com.geercode.creed.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description : </p>
 * <p>Created on  : 2018-10-23 18:31</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;
    @Value("${noob}")
    private String noob;

    @GetMapping("/getConfig")
    public String getConfig(String key) {
        return noob;
    }

    /**
     * <p>description : 测试资源是否正确访问</p>
     * <p>create   on : 2018-10-23 20:50:08</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @GetMapping("/check")
    public String getToken() {
        ResponseEntity<String> responseEntity = oAuth2RestTemplate
                .getForEntity("http://creeduaa.jufandev.com:10103/resource/me", String.class);
        return responseEntity.getBody();
    }

    /**
     * <p>description : 测试resource保护</p>
     * <p>create   on : 2018-10-23 16:30:50</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @RequestMapping("/me")
    @SneakyThrows
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new HashMap(1);
        OAuth2AccessToken accessToken = oauth2ClientContext.getAccessToken();
        map.put("name", principal.getName());
        map.put("access_token", accessToken.getValue());
        return map;
    }
}
