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

package com.geercode.creed.samples.axon.controller;

import com.geercode.creed.samples.axon.cmd.UserAddCmd;
import com.geercode.creed.samples.axon.domain.UserDomain;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description : 测试控制器</p>
 * <p>Created on  : 2018-12-13 14:24</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CommandGateway commandGateway;

    @GetMapping("/cqrs")
    public String cqrs() {
        commandGateway.send(new UserAddCmd(1, "jerry"));
        return "success";
    }

    @GetMapping("/cqrs2")
    public String cqrs2() {
        Configuration config = DefaultConfigurer.defaultConfiguration().configureAggregate(UserDomain.class)
                .configureEmbeddedEventStore(c -> new InMemoryEventStorageEngine()).buildConfiguration();
        config.start();
        config.commandGateway().send(new UserAddCmd(1, "jerry"));
        return "success";
    }
}
