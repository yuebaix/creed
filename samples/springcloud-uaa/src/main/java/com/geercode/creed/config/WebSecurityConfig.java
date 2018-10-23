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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * <p>Description : 网站安全配置</p>
 * <p>Created on  : 2018-10-22 13:19</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** 创建注入认证管理器*/
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /** 配置认证管理器*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    /** 配置websecurityfilter中的安全策略*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().disable();
    }

    /** 配置忽略静态资源的权限控制*/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/favicon.ico", "/webjars/**");
    }

    /** 配置密码编码器*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NonePasswordEncoder();
    }

    /** 创建注入UserDetailsService,自定义用户验证*/
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new SimpleUserDetailsServiceImpl();
    }

    private static class NonePasswordEncoder implements PasswordEncoder {
        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return charSequence.equals(s);
        }
    }

    private static class SimpleUserDetailsServiceImpl implements UserDetailsService {
        @Override
        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            return new User("admin", "admin", Collections.emptySet());
        }
    }
}
