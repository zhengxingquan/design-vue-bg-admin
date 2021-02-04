package com.quan.core.common.request.del;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */

@Data
@ApiModel("批量删除数据请求参数")
public class BatchDeleteRequest {

    @ApiModelProperty("记录ID的集合")
    @NotNull
    @Min(0)
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> ids;

}
