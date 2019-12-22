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

package com.geercode.creed.samples.axon.config;

import com.geercode.creed.samples.axon.domain.UserDomain;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.spring.eventsourcing.SpringPrototypeAggregateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * <p>Description : axon框架配置</p>
 * <p>Created on  : 2018-12-13 13:10</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Configuration
public class AxonConfig {
    @Bean
    public EventStorageEngine eventStorageEngine() {
        InMemoryEventStorageEngine engine = new InMemoryEventStorageEngine();
        return engine;
    }

    @Autowired
    private EventStore eventStore;

    @Bean
    @Scope("prototype")
    public UserDomain userDomain(){
        return new UserDomain();
    }

    @Bean
    public AggregateFactory<UserDomain> userDomainAggregateFactory(){
        SpringPrototypeAggregateFactory<UserDomain> aggregateFactory = new SpringPrototypeAggregateFactory<>("userDomain");
        return aggregateFactory;
    }

    @Bean
    public EventSourcingRepository<UserDomain> productAggregateRepository(){
        EventSourcingRepository<UserDomain> repository = EventSourcingRepository.builder(UserDomain.class)
                .aggregateFactory(userDomainAggregateFactory())
                .eventStore(eventStore)
                .build();
        return repository;
    }

    @PostConstruct
    public void configLast() {
    }
}
