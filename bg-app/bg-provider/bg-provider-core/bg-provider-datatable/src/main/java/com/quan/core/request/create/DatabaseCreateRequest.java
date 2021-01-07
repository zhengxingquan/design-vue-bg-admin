package com.quan.core.request.create;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统数据仓库表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 22:12:27
 */

@Getter
@Setter
@Data
public class DatabaseCreateRequest {


    /**
     * 父节点
     */
    @ApiModelProperty(value = "父节点")
    private String parentId;

    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称")
    @NotNull
    private String name;

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String databaseCode;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    private String note;


}
