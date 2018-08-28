package com.geercode.creed.samples.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Title       : SwaggerConfig</p>
 * <p>Description : swagger配置类</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-27 20:38</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String GROUP_NAME = "all";
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_NAME)
                .apiInfo(apiInfo())
                .select()
                //扫描注解了@ApiOperation的方法生成API接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("Creed Swagger2 接口文档示例")
                //设置文档的描述
                .description("SpringBoot示例 简单网站")
                //设置文档的版本信息
                .version(VERSION)
                //设置文档的联系方式
                .contact(new Contact("jerryniu", "https://about.me/jerryniu", "huifumanlove@hotmail.com"))
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
