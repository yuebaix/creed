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

import org.junit.Assert;
import org.junit.Test;
import org.springframework.format.Formatter;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * <p>Description : mvc配置类测试</p>
 * <p>Created on  : 2018-09-25 12:24</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class WebMvcConfigTest {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void test() {
        String joda = "2018-09-25T13:22:35.381+0800";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        System.out.println(df.parse(joda));
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        System.out.println(df2.format(new Date()));
    }

    @Test
    public void testFormat() {
        DefaultFormattingConversionService registry = new DefaultFormattingConversionService();
        registry.addFormatter(new Formatter<LocalDateTime>() {
            @Override
            public String print(LocalDateTime localDateTime, Locale locale) {
                return DATE_TIME_FORMATTER.format(localDateTime);
            }

            @Override
            public LocalDateTime parse(String text, Locale locale) {
                return LocalDateTime.parse(text, DATE_TIME_FORMATTER);
            }
        });

        LocalDateTime local = LocalDateTime.parse("2018-09-25 13:22:35", DATE_TIME_FORMATTER);
        Assert.assertEquals("2018-09-25 13:22:35", registry.convert(local, String.class));
    }
}
