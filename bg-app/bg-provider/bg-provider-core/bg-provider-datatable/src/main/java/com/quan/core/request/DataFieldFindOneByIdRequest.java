package com.quan.core.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统字段表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:29:07
 */

@Getter
@Setter
@Data
public class DataFieldFindOneByIdRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
