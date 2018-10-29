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

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description : oauth2 token添加</p>
 * <p>Created on  : 2018-09-20 18:39</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class FilterConfig {

    /**
     * <p>description : 为服务添加oauth2 token</p>
     * <p>create   on : 2018-10-29 15:26:06</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @Bean
    public ZuulFilter oauth2ClientAuth(OAuth2RestTemplate oAuth2RestTemplate) {
        return new Oauth2ZuulFilter(oAuth2RestTemplate);
    }

    private static final class Oauth2ZuulFilter extends ZuulFilter {
        private OAuth2RestTemplate oAuth2RestTemplate;

        private Oauth2ZuulFilter(OAuth2RestTemplate oAuth2RestTemplate) {
            this.oAuth2RestTemplate = oAuth2RestTemplate;
        }

        @Override
        public String filterType() {
            return "route";
        }

        @Override
        public int filterOrder() {
            return 0;
        }

        @Override
        public boolean shouldFilter() {
            return true;
        }

        @Override
        public Object run() {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            log.info(String.format("%s %s request to %s", "0:0:0:0:0:0:0:1".equals(request.getRemoteAddr())
                    ? "127.0.0.1" : request.getRemoteAddr(), request.getMethod(), request.getRequestURL().toString()));
            ctx.addZuulRequestHeader("Authorization", "Bearer "
                    + oAuth2RestTemplate.getAccessToken().getValue());
            return null;
        }
    }
}
