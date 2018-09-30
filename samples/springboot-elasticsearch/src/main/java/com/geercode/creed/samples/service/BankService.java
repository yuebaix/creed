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

package com.geercode.creed.samples.service;

import com.geercode.creed.samples.entity.Bank;

/**
 * <p>Description : BankService</p>
 * <p>Created on  : 2018-09-29 15:58</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface BankService {
    String add(Bank bank);
    String delete(Long id);
    String update(Long id);
    String query(String searchContent);
}
