package com.quan.core.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.quan.core.common.model.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * 系统数据仓库表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 22:12:27
 */

@Getter
@Setter
@Data
@TableName("sys_database")
public class Database extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父节点
     */
    @TableField(value = "parent_id")
    private String parentId;
    /**
     * 中文名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 物理名称
     */
    @TableField(value = "physical_name")
    private String physicalName;
    /**
     * 编码
     */
    @TableField(value = "database_code")
    private String databaseCode;
    /**
     * 树路径
     */
    @TableField(value = "path")
    private String path;
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
    /**
     * 简介
     */
    @TableField(value = "note")
    private String note;

}
