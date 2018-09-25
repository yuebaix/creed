/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Description : mvc配置</p>
 * <p>Created on  : 2018-09-21 19:00</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /*private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Bean
    public ObjectMapper registerSe() {
        ObjectMapper om = new ObjectMapper();

        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter localTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(localDateTimeFormatter));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(localDateFormatter));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(localTimeFormatter));

        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(localDateTimeFormatter));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(localDateFormatter));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(localTimeFormatter));

        om.findAndRegisterModules();
        om.registerModule(javaTimeModule);
        om.getRegisteredModuleIds();
        return om;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<LocalDateTime>() {
            @Override
            public String print(LocalDateTime localDateTime, Locale locale) {
                return df.format(localDateTime);
            }

            @Override
            public LocalDateTime parse(String text, Locale locale) {
                return LocalDateTime.parse(text, df);
            }
        });
        registry.addFormatter(new Formatter<LocalDate>() {
            @Override
            public String print(LocalDate localDate, Locale locale) {
                return df.format(localDate);
            }

            @Override
            public LocalDate parse(String text, Locale locale) {
                return LocalDate.parse(text, df);
            }
        });
        registry.addFormatter(new Formatter<LocalTime>() {
            @Override
            public String print(LocalTime localTime, Locale locale) {
                return df.format(localTime);
            }

            @Override
            public LocalTime parse(String text, Locale locale) {
                return LocalTime.parse(text, df);
            }
        });
    }*/
}
