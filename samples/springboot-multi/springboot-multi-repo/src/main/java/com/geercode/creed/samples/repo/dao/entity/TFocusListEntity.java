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
 * <p>重点关注名单</p>
 *
 * @author jerryniu
 * @since 2018-09-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_focus_list")
@ApiModel(value = "TFocusListEntity对象", description = "重点关注名单")
public class TFocusListEntity extends AbstractBaseEntity<TFocusListEntity> {

    @ApiModelProperty(value = "主键ID ")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "公司ID ")
    private Long companyId;

    @ApiModelProperty(value = "公司名 ")
    private String companyName;

    @ApiModelProperty(value = "统一社会信用代码 ")
    private String creditNo;

    @ApiModelProperty(value = "企业地址 ")
    private String address;

    @ApiModelProperty(value = "注册号 ")
    private String regNo;

    @ApiModelProperty(value = "数据来源 ")
    private String dataSource;

    @ApiModelProperty(value = "法定代表人 ")
    private String operName;

    @ApiModelProperty(value = "列入经营异常名录原因类型名称 ")
    private String reson;

    @ApiModelProperty(value = "设立日期 ")
    private String setDate;

    @ApiModelProperty(value = "列入决定机关名称 ")
    private String organName;

    @ApiModelProperty(value = "更新时间 ")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "记录创建时间 ")
    private LocalDateTime createTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
