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

/**
 * <p>Description : 启动类</p>
 * <p>Created on  : 2018-09-29 12:53</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public class MainEntry {
    public static void main(String[] args) {
        String indexPath = "D:\\file\\index";
        String docsPath = "D:\\file\\creed-simple-app";
        IndexerHolder.getHolder().luceneIndexing(indexPath, docsPath, true);
        String text = "前任拉甘送苏宁首败落后恒大6分争冠难了";
        SegmenterHolder.getHolder().jieba(text);

        IndexerHolder.getHolder().luceneSearch("D:\\file\\index");
    }
}
