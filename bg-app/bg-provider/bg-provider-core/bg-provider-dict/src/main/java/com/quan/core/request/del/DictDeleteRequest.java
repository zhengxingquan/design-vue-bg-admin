package com.quan.core.request.del;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * 系统字典表 删除请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */

@Getter
@Setter
@Data
public class DictDeleteRequest {

    @ApiModelProperty("删除id")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
