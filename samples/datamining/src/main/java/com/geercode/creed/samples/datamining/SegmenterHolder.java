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

import com.huaban.analysis.jieba.JiebaSegmenter;

/**
 * <p>Description : 分词器</p>
 * <p>Created on  : 2018-09-29 12:56</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class SegmenterHolder {
    private static final SegmenterHolder HOLDER = new SegmenterHolder();

    private SegmenterHolder() {
    }

    public static SegmenterHolder getHolder() {
        return HOLDER;
    }

    public void jieba(String text) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        System.out.println(segmenter.sentenceProcess(text));
    }
}
