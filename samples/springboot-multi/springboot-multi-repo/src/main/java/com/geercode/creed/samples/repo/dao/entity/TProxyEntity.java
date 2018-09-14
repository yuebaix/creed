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
 * <p>代理池</p>
 *
 * @author jerryniu
 * @since 2018-09-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_proxy")
@ApiModel(value = "TProxyEntity对象", description = "代理池")
public class TProxyEntity extends AbstractBaseEntity<TProxyEntity> {

    @ApiModelProperty(value = "主键ID ")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "ip ")
    private String ip;

    @ApiModelProperty(value = "端口 ")
    private String port;

    @ApiModelProperty(value = "状态 1有效2无效3未测")
    private String state;

    @ApiModelProperty(value = "http,https")
    private String type;

    @ApiModelProperty(value = "更新时间 ")
    private String udpateTime;

    @ApiModelProperty(value = "记录创建时间 ")
    private LocalDateTime createTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
