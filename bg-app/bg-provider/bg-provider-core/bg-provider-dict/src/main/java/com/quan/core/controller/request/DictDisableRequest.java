package com.quan.core.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统字典表 禁用请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */

@Getter
@Setter
@Data
public class DictDisableRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
