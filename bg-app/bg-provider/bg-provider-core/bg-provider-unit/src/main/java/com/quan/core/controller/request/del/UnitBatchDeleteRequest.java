package com.quan.core.controller.request.del;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 系统单位表 删除请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-31 15:39:39
 */

@Getter
@Setter
@Data
public class UnitBatchDeleteRequest {

    @ApiModelProperty("记录ID的集合")
    @NotNull
    @Min(0)
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> ids;

}
