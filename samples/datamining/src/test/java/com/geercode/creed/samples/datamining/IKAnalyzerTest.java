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

package com.geercode.creed.samples.datamining;

import lombok.SneakyThrows;
import org.junit.Test;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;

/**
 * <p>Description : ik分词器测试</p>
 * <p>Created on  : 2018-10-10 15:36</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class IKAnalyzerTest {
    @Test
    @SneakyThrows
    public void test2() {
        String text="撒打发交电费静安寺哦大家发i哦jssdfa1233-1";
        StringReader reader = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(reader,false);//当为true时，分词器进行最大词长切分
        Lexeme lexeme = null;
        while((lexeme = ik.next())!=null)
            System.out.println(lexeme.getLexemeText());
    }
}
