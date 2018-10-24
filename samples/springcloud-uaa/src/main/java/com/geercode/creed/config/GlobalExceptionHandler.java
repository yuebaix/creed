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

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description : 全局控制器异常处理</p>
 * <p>Created on  : 2018-09-20 18:39</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * <p>description : 输出错误日志</p>
     * <p>create   on : 2018-10-24 14:13:29</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception ex, HttpServletRequest request) {
        log.error("请求地址:" + request.getRequestURL());
        ModelAndView mav = new ModelAndView();
        log.error("异常信息:", ex);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
