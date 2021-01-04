package com.quan.core.request;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * 系统角色表 条件查询请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */

@Getter
@Setter
@Data
public class RoleQueryRequest {

    @ApiModelProperty("ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;
    /**
     * 角色别名
     */
    @ApiModelProperty("角色别名")
    private String aliasName;

}
