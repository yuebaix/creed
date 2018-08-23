package com.geercode.creed.samples.service;

import com.geercode.creed.samples.domain.UserDomain;
import org.springframework.stereotype.Service;

/**
 * <p>Title       : DemoServiceImpl</p>
 * <p>Description : DemoServiceImpl</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-17 14:24</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello() {
        UserDomain user = new UserDomain();
        user.setId(1);
        user.setName("jerry");
        return user.sayHi();
    }
}
