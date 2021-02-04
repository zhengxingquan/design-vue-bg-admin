package com.quan.core.common.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
@Data
@ApiModel("批量冻结与启用请求参数")
public class BatchEnableAndDisableRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> id;

}
