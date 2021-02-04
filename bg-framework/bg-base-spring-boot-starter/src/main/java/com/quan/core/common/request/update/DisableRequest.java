package com.quan.core.common.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */

@Data
@ApiModel("单条数据冻结请求参数")
public class DisableRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
