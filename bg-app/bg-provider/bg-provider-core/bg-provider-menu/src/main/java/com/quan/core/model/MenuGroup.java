package com.quan.core.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




/**
 * 系统菜单表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 18:42:13
 */

@Getter
@Setter
@Data
@TableName("sys_menu_group")
public class MenuGroup extends BaseEntity{

private static final long serialVersionUID=1L;

                            /**
         * 父级ID
         */
        @TableField(value = "parent_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long parentId;
                                /**
         * 组名称
         */
        @TableField(value = "group_name")
                private String groupName;
                                /**
         * 组别名
         */
        @TableField(value = "group_alias_name")
                private String groupAliasName;
                                /**
         * 编码
         */
        @TableField(value = "group_code")
                private String groupCode;
                                /**
         * 树路径
         */
        @TableField(value = "path")
                private String path;
                                /**
         * 菜单介绍
         */
        @TableField(value = "note")
                private String note;
                                /**
         * 是否有子节点
         */
        @TableField(value = "has_children")
                private Integer hasChildren;
                                /**
         * 排序字段
         */
        @TableField(value = "sort")
                private Integer sort;
                                                                                            
}
