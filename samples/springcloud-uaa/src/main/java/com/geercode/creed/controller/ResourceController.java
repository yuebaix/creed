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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Description : 测试控制器</p>
 * <p>Created on  : 2018-10-22 15:14</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    /**
     * <p>description : 测试resource保护</p>
     * <p>create   on : 2018-10-23 16:30:50</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @RequestMapping("/me")
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        map.put("access_token", oauth2ClientContext.getAccessToken().getValue());
        return map;
    }
}

