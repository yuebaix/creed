/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.repo.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.geercode.creed.samples.repo.dao.AbstractBaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>公司基本信息表</p>
 *
 * @author jerryniu
 * @since 2018-09-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_company")
@ApiModel(value = "TCompanyEntity对象", description = "公司基本信息表")
public class TCompanyEntity extends AbstractBaseEntity<TCompanyEntity> {

    @ApiModelProperty(value = "主键ID ")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "公司名 ")
    private String name;

    @ApiModelProperty(value = "法定代表人 ")
    private String operName;

    @ApiModelProperty(value = "组织机构代码 ")
    private String orgNo;

    @ApiModelProperty(value = "企业地址 ")
    private String address;

    @ApiModelProperty(value = "经营范围 ")
    private String scope;

    @ApiModelProperty(value = "成立日期 ")
    private String startDate;

    @ApiModelProperty(value = "结束日期 ")
    private String endDate;

    @ApiModelProperty(value = "经营状态 ")
    private String status;

    @ApiModelProperty(value = "营业期限 ")
    private String termStart;

    @ApiModelProperty(value = "营业期限 ")
    private String termEnd;

    @ApiModelProperty(value = "注册资本 ")
    private String registCapi;

    @ApiModelProperty(value = "注册号 ")
    private String regNo;

    @ApiModelProperty(value = "发照日期 ")
    private String checkDate;

    @ApiModelProperty(value = "公司类型 ")
    private String econKind;

    @ApiModelProperty(value = "统一社会信用代码 ")
    private String creditNo;

    @ApiModelProperty(value = "登记机关 ")
    private String belongOrg;

    @ApiModelProperty(value = "所属省 ")
    private String province;

    @ApiModelProperty(value = "所属市 ")
    private String city;

    @ApiModelProperty(value = "邮箱 ")
    private String email;

    @ApiModelProperty(value = "电话 ")
    private String telephone;

    @ApiModelProperty(value = "其他信息 ")
    private String memo;

    @ApiModelProperty(value = "更新时间 ")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "记录创建时间 ")
    private LocalDateTime createTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
