#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package ${package}.web.config;

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
