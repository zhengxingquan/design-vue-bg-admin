package com.quan.core.controller.request;

import com.quan.core.common.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Data
public class GeneratorQueryRequest extends PageRequest {

    @ApiModelProperty("查询的数据表的名称")
    private String tableName;
}
