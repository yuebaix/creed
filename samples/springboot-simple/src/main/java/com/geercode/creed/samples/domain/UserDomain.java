package com.geercode.creed.samples.domain;

import lombok.Data;

/**
 * <p>Title       : UserDomain</p>
 * <p>Description : 用户领域对象</p>
 * <p>Copyright   : Copyright 2018-2050</p>
 * <p>Company     : www.juxiangfen.com</p>
 * <p>created on  : 2018-08-17 14:19</p>
 *
 * @author jerryniu
 * @version 1.0.0
 */
@Data
public class UserDomain {
    private long id;
    private String name;

    public String sayHi() {
        return "hi, I'm " + name;
    }
}
