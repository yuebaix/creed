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

import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>Description : mdc过滤器</p>
 * <p>Created on  : 2019-02-12 18:54</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
@WebFilter
public class MdcFilter implements Filter {
    public MdcFilter() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        this.insertIntoMdc(request);

        try {
            chain.doFilter(request, response);
        } finally {
            this.clearMdc();
        }
    }

    @Override
    public void destroy() {
    }

    private void insertIntoMdc(ServletRequest request) {
        //对应logstash-gelf,添加请求发起时间
        MDC.put("profiling.requestStart.millis", "" + System.currentTimeMillis());
        //添加请求详细
        MDC.put("req.remoteHost", request.getRemoteHost());
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            MDC.put("req.requestURI", httpServletRequest.getRequestURI());
            StringBuffer requestURL = httpServletRequest.getRequestURL();
            if (requestURL != null) {
                MDC.put("req.requestURL", requestURL.toString());
            }

            MDC.put("req.method", httpServletRequest.getMethod());
            MDC.put("req.queryString", httpServletRequest.getQueryString());
            MDC.put("req.userAgent", httpServletRequest.getHeader("User-Agent"));
            MDC.put("req.xForwardedFor", httpServletRequest.getHeader("X-Forwarded-For"));
        }
    }

    private void clearMdc() {
        //对应logstash-gelf,清除请求发起时间
        MDC.remove("profiling.requestStart.millis");
        //清除请求详细
        MDC.remove("req.remoteHost");
        MDC.remove("req.requestURI");
        MDC.remove("req.queryString");
        MDC.remove("req.requestURL");
        MDC.remove("req.method");
        MDC.remove("req.userAgent");
        MDC.remove("req.xForwardedFor");
    }
}
