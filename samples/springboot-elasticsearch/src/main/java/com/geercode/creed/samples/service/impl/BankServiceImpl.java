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

package com.geercode.creed.samples.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geercode.creed.samples.entity.Bank;
import com.geercode.creed.samples.repo.es.BankEsDao;
import com.geercode.creed.samples.service.BankService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * <p>Description : BankServiceImpl</p>
 * <p>Created on  : 2018-09-29 15:58</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Component
public class BankServiceImpl implements BankService {
    @Autowired
    private BankEsDao bankEsDao;

    @Override
    public String add(){
        Bank bank=new Bank();
        bank.setId(1);
        bank.setName("工商銀行");
        bank.setCode("0001");
        bank.setAddress("上海徐匯");
        bankEsDao.save(bank);
        return "success";
    }
    @Override
    public String delete(){
        bankEsDao.deleteById(1L);
        return "success";
    }
    @Override
    public String update(){
        Optional<Bank> bankOp = bankEsDao.findById(1L);
        Bank bank = bankOp.get();
        bank.setCode("123");
        bankEsDao.save(bank);
        return "success";
    }

    @SneakyThrows
    @Override
    public String query(){
        Optional<Bank> bankOp = bankEsDao.findById(1L);
        Bank bank = bankOp.get();
        String result = new ObjectMapper().writeValueAsString(bank);
        return result;
    }
}
