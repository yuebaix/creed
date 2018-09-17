/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : 展示swagger功能的实体</p>
 * <p>Created on  : 2018-09-17 17:13</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@ApiModel(value = "swagger展示实体", description = "仅作示例")
@Data
public class ShowSwaggerModel {
    @ApiModelProperty(value = "ID")
    private long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
