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
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.Assert;

/**
 * <p>Description : oauth2客户端配置</p>
 * <p>Created on  : 2018-10-23 19:43</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class Oauth2ClientConfig {
    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @Bean
    public OAuth2RestTemplate restTemplate(ClientCredentialsResourceDetails clientDetails) {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(clientDetails, new DefaultOAuth2ClientContext(atr));
    }

    /**
     * 确保可以正常连接认证中心
     *
     * @PostConstruct
     */
    @SneakyThrows
    public String getAccessToken() {
        Assert.isTrue(oAuth2RestTemplate.getResource() != null,
                "resource属性为空，请检查security.oauth.client&resource配置");
        OAuth2AccessToken oAuth2AccessToken = oAuth2RestTemplate.getAccessToken();
        log.info(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(oAuth2AccessToken));
        String accessToken = oAuth2AccessToken.getValue();
        log.debug("获取oauth2的授权令牌access_token end; access_token = " + accessToken
                + "; 失效时间 = " + oAuth2AccessToken.getExpiration()
                + "; 剩余失效时间: " + oAuth2AccessToken.getExpiresIn());
        return accessToken;
    }
}
