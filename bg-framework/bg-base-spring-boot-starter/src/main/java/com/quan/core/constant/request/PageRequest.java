package com.quan.core.constant.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "要查询的起始页码" )
    @NotNull
    protected Integer pageNumber = 0;
    @ApiModelProperty(value = "每页显示数量" )
    @NotNull
    protected Integer pageSize = 10;
}
