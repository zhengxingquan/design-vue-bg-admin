package com.quan.core.unit.request.del;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * 系统单位表 删除请求类
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-21 19:28:04
 */

@Getter
@Setter
@Data
public class UnitDeleteRequest {

    @ApiModelProperty("删除id")
    @NotNull
    private Long id;

}
