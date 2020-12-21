package com.quan.core.unit.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统单位表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-21 20:03:28
 */

@Getter
@Setter
@Data
public class UnitFindOneByIdRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    private Long id;

}
