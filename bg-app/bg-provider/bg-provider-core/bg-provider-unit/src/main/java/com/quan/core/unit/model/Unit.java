package com.quan.core.unit.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.quan.common.model.BaseEntity;

import java.util.Date;

/**
 * 系统单位表
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-21 19:28:04
 */

@Getter
@Setter
@Data
@TableName("sys_unit" )
public class Unit extends BaseEntity{

    private static final long serialVersionUID=1L;

                    /**
     * 父级ID
     */
    @TableField(value = "parent_id")
    private String parentId;
                    /**
     * 单位名称
     */
    @TableField(value = "name")
    private String name;
                    /**
     * 单位别名
     */
    @TableField(value = "alias_name")
    private String aliasName;
                    /**
     * 机构编码
     */
    @TableField(value = "unit_code")
    private String unitCode;
                    /**
     * 单位介绍
     */
    @TableField(value = "note")
    private String note;
                    /**
     * 附加值一
     */
    @TableField(value = "field1")
    private String field1;
                    /**
     * 附加值二
     */
    @TableField(value = "field2")
    private String field2;
                    /**
     * 附加值三
     */
    @TableField(value = "field3")
    private String field3;
                    /**
     * 排序字段
     */
    @TableField(value = "sort")
    private Integer sort;
                    /**
     * 是否禁用
     */
    @TableField(value = "disabled")
    private Integer disabled;
                    /**
     * 是否有子节点
     */
    @TableField(value = "has_children")
    private Integer hasChildren;
                    /**
     * 单位logo
     */
    @TableField(value = "logo")
    private String logo;
                    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
                    /**
     * 创建人员ID
     */
    @TableField(value = "creator_user_id")
    private Long creatorUserId;
                    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
                    /**
     * 编辑人员ID
     */
    @TableField(value = "update_user_id")
    private Long updateUserId;
                    /**
     * 数据状态 0启动1删除
     */
    @TableField(value = "data_state")
    private Integer dataState;
        
}
