package com.quan.core.controller.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统数据表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:05:24
 */

@Getter
@Setter
@Data
public class DataTableCreateRequest {

    /**
     * 仓库的ID
     */
    @ApiModelProperty(value = "仓库的ID")
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull
    private Long parentId;

    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称")
    @NotNull
    private String name;

    /**
     * 表类型，1=主表， 2=从表
     */
    @ApiModelProperty(value = "表类型，1=主表， 2=从表")
    @NotNull
    private Integer tableType;

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String tableCode;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    private String note;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息")
    private String tooltip;

    /**
     * 复制表结构id
     */
    @ApiModelProperty(value = "复制表结构id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long copyTableId;


}
