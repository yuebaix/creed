/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.scene;

import com.geercode.creed.samples.domain.UserDomain;

/**
 * <p>Description : 缓存服务接口</p>
 * <p>Created on  : 2018-11-06 15:13</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface CacheService {
    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-06 16:15:37</p>
     *
     * @author jerryniu
     * @version 1.0.0
     *
     * @param id id
     * @return  userDomain 领域实体
     */
    UserDomain select(long id);

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-06 16:15:37</p>
     *
     * @author jerryniu
     * @version 1.0.0
     *
     * @param user 领域实体
     * @return  userDomain 领域实体
     */
    UserDomain insertOrUpdate(UserDomain user);

    /**
     * <p>description : </p>
     * <p>create   on : 2018-11-06 16:15:37</p>
     *
     * @author jerryniu
     * @version 1.0.0
     *
     * @param id id
     * @return  userDomain 领域实体
     */
    UserDomain delete(long id);
}
