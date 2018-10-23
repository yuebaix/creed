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

package com.geercode.creed.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geercode.creed.common.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : 全局错误处理</p>
 * <p>Created on  : 2018-09-20 18:39</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class GlobalErrController extends AbstractErrorController {
    private final ServerProperties serverProperties;
    private final ErrorProperties errorProperties;
    @Value("${spring.profiles.active}")
    private String activeProfile;

    /**
     * <p>description : 构造器中加载springboot环境中的相关配置</p>
     * <p>create   on : 2018-09-20 19:11:54</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    public GlobalErrController(ServerProperties serverProperties, ErrorAttributes errorAttributes,
            @Autowired(required = false) List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
        this.serverProperties = serverProperties;
        Assert.notNull(this.serverProperties.getError(), "ErrorProperties must not be null");
        this.errorProperties = this.serverProperties.getError();
    }

    @Override
    public String getErrorPath() {
        return this.errorProperties.getPath();
    }

    /**
     * <p>description : 统一错误返回json,只在开发环境生效,其他环境返回空字符串</p>
     * <p>create   on : 2018-09-20 19:03:40</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String error(HttpServletRequest request) {
        if (SystemConstant.PROFILE_SINGLETON.equals(activeProfile)) {
            Map<String, Object> body = getErrorAttributes(request, false);
            HttpStatus status = getStatus(request);
            try {
                return new ObjectMapper().writerWithDefaultPrettyPrinter()
                        .writeValueAsString(new ResponseEntity<Map<String, Object>>(body, status));
            } catch (Throwable ex) {
                ex.printStackTrace();
                return "{\"error\" : \"jackson error\"}";
            }
        }
        return "";
    }
}
