/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.repo.dao.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.geercode.creed.samples.repo.dao.AbstractBaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : 公司实体</p>
 * <p>Created on  : 2018-09-10 15:28</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Data
@TableName("t_company")
public class TCompany extends AbstractBaseEntity<TCompany> {
    /**主键ID*/
    @TableId
    private Long id;

    /**公司名*/
    @TableId
    private String name;

    /**法定代表人*/
    @TableId
    private String operName;

    /** 组织机构代码  */
    @TableId
    private String orgNo;

    /**企业地址*/
    @TableId
    private String address;

    /**经营范围*/
    @TableId
    private String scope;

    /**成立日期*/
    @TableId
    private String startDate;

    /**结束日期*/
    @TableId
    private String endDate;

    /**经营状态*/
    @TableId
    private String status;

    /**营业期限*/
    @TableId
    private String termStart;

    /**营业期限*/
    @TableId
    private String termEnd;

    /**注册资本*/
    @TableId
    private String registCapi;

    /**注册号*/
    @TableId
    private String regNo;

    /**发照日期*/
    @TableId
    private String checkDate;

    /**公司类型*/
    @TableId
    private String econKind;

    /**统一社会信用代码*/
    @TableId
    private String creditNo;

    /**登记机关*/
    @TableId
    private String belongOrg;

    /**所属省*/
    @TableId
    private String province;

    /**所属市*/
    @TableId
    private String city;

    /**邮箱*/
    @TableId
    private String email;

    /**电话*/
    @TableId
    private String telephone;

    /**其他信息*/
    @TableId
    private String memo;

    /**更新时间*/
    @TableId
    private Date updateTime;

    /**记录创建时间*/
    @TableId
    private Date createTime;

    @Override
    protected Serializable pkVal() {
        return this.createTime;
    }
    /*********************************以下可以写自定义的方法*****************************/
}

