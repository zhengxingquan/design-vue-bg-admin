package com.quan.core.datamapping.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 系统映射配置表 批量操作请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */

@Getter
@Setter
@Data
public class DataMappingBatchEnableAndDisableRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @NotEmpty
    @Min(1)
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> id;

}
