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

package com.geercode.creed.samples.axon.domain;

import com.geercode.creed.samples.axon.cmd.UserAddCmd;
import com.geercode.creed.samples.axon.entity.ContactEntity;
import com.geercode.creed.samples.axon.entity.UserEntity;
import com.geercode.creed.samples.axon.event.UserAddEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

/**
 * <p>Description : 用户</p>
 * <p>Created on  : 2018-12-13 13:44</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Aggregate
@Data
@Slf4j
public class UserDomain {
    @AggregateIdentifier
    private long id;
    private String name;

    private UserEntity user;
    private List<ContactEntity> contactList;

    @CommandHandler
    public void add(UserAddCmd cmd) {
        AggregateLifecycle.apply(new UserAddEvent(cmd.getId(), cmd.getName()));
    }

    @EventHandler
    public void onAdd(UserAddEvent e) {
        log.info(e.toString());
    }
}
