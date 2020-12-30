package com.quan.core.dto.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统角色表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */

@Getter
@Setter
@Data
public class RoleCreateDTO {

    /**
     * 主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
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
    private Integer hasChildren = 0;
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
    /**
     *
     */
    private Date createTime;
    /**
     * 创建人员ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createUserId;

}
