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

package com.geercode.creed.samples.designmode.behavior.chain;

/**
 * <p>Description : 责任链接口</p>
 * <p>Created on  : 2018-11-01 17:50</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface Chain {
    Object process(Object input);
    Chain next(Chain chain);
    Object handle(Object input);
}