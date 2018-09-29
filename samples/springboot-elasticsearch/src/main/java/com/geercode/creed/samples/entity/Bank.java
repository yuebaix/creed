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

package com.geercode.creed.samples.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * <p>Description : 银行实体类</p>
 * <p>Created on  : 2018-09-29 15:34</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Document(indexName = "architect", type = "bank", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
public class Bank {
    @Id
    private long id;
    @Field
    private String code;
    @Field(fielddata = true)
    private String name;
    @Field
    private String address;
}
