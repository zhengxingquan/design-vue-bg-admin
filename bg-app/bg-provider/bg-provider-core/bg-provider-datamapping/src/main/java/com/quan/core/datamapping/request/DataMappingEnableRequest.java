package com.quan.core.datamapping.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统映射配置表 启用请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */

@Getter
@Setter
@Data
public class DataMappingEnableRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
