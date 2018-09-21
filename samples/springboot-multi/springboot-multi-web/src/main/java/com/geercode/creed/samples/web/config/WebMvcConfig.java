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

package com.geercode.creed.samples.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * <p>Description : mvc配置</p>
 * <p>Created on  : 2018-09-21 19:00</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
    }
}
