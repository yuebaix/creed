package com.geercode.creed.samples.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>Title       : PageSecureConfig</p>
 * <p>Description : 页面安全</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-27 21:55</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(ResourceProperties.class)
public class PageSecureConfig {
    private static final String DEV_PROFILE = "dev";
    private final ServerProperties serverProperties;
    @Value("${spring.profiles.active}")
    private String activeProfile;
    @Autowired(required = false)
    private List<ErrorViewResolver> errorViewResolvers;

    public PageSecureConfig(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    @Bean
    public ErrorController basicErrorController(ErrorAttributes errorAttributes) {
        return new JufanErrController(errorAttributes, this.serverProperties.getError(),
                this.errorViewResolvers);
    }

    @RequestMapping("${server.error.path:${error.path:/error}}")
    private class JufanErrController extends AbstractErrorController {
        private final ErrorProperties errorProperties;

        JufanErrController(ErrorAttributes errorAttributes,
                ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
            super(errorAttributes, errorViewResolvers);
            Assert.notNull(errorProperties, "ErrorProperties must not be null");
            this.errorProperties = errorProperties;
        }

        @Override
        public String getErrorPath() {
            return this.errorProperties.getPath();
        }

        @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
        @ResponseBody
        public String error(HttpServletRequest request) {
            if (DEV_PROFILE.equals(activeProfile)) {
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
}