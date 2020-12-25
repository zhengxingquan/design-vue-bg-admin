package com.quan.core.rabbitmq.request;

import com.quan.common.request.RequestPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Data
public class GeneratorQueryRequest extends RequestPage {

    @ApiModelProperty("查询的数据表的名称")
    private String tableName;
}
