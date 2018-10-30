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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import java.security.KeyPair;

/**
 * <p>Description : 认证服务器配置</p>
 * <p>Created on  : 2018-10-22 13:55</p>
 *
 * 默认securityfilter顺序为
 * 1.匹配AuthorizationServerConfigurerAdapter
 * 2.匹配ResourceServerConfigurerAdapter
 * 3.匹配WebSecurityConfigurerAdapter
 *
 * authorization_code：授权码类型。
 * implicit：简化授权类型。
 * password：资源所有者（即用户）密码类型。
 * client_credentials：客户端凭据（客户端ID以及Key）类型。
 * refresh_token：通过以上授权获得的刷新令牌来获取新的令牌。
 *
 * /oauth/authorize：授权端点。
 * /oauth/token：令牌端点。
 * /oauth/confirm_access：用户确认授权提交端点。
 * /oauth/error：授权服务错误信息端点。
 * /oauth/check_token：用于资源服务访问的令牌解析端点。
 * /oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话。
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 注入认证管理器(必须在WebSecurityConfig中创建)
     * @see WebSecurityConfig
     */
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    /**
     * 1.用来配置客户端详情服务(ClientDetailsService)
     *
     * warn:必须要有scope,否则会触发spelview的漏洞执行服务器代码
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("uaa_id")
                .secret("uaa_secret")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token",
                        "authorization_code", "implicit").scopes("default")
                .and()
                .withClient("gate_id")
                .secret("gate_secret")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .scopes("default")
                .and()
                .withClient("service_id")
                .secret("service_secret")
                .authorizedGrantTypes("client_credentials")
                .scopes("default")
                .and()
                .withClient("aggregator_id")
                .secret("aggregator_secret")
                .authorizedGrantTypes("client_credentials")
                .scopes("default")
                .and()
                .withClient("app_id")
                .secret("app_secret")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("default")
                .and()
                .withClient("client_id")
                .secret("client_secret")
                .authorizedGrantTypes("client_credentials")
                .scopes("default");
    }

    /** 2.用来配置令牌端点(Token Endpoint)的安全约束*/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        security.allowFormAuthenticationForClients();
    }

    /** 3.用来配置令牌端点(Token Endpoint)的众多配置类*/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    /** jwt配置*/
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("keystore.jks"), "foobar".toCharArray())
                .getKeyPair("test");
        converter.setKeyPair(keyPair);
        return converter;
    }
}
