package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色表 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */

@Getter
@Setter
@Data
public class RoleQueryDTO {

    /**
     * 父节点
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 角色别名
     */
    private String aliasName;
    /**
     * 是否有子节点
     */
    private Integer hasChildren;
    /**
     * 路径编码用于查询与删除
     */
    private String path;
    /**
     * 备注
     */
    private String note;
    /**
     * 排序字段
     */
    private Integer sort;

}
