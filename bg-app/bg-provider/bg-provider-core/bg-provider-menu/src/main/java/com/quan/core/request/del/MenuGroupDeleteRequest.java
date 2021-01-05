package com.quan.core.request.del;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * 系统菜单表 删除请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 18:42:13
 */

@Getter
@Setter
@Data
public class MenuGroupDeleteRequest {

    @ApiModelProperty("删除id")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
