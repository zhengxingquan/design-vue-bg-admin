package com.quan.core.dto.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统数据表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:05:24
 */

@Getter
@Setter
@Data
public class DataTableCreateDTO {

    /**
     * ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long id;
    /**
     * 仓库的ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
    /**
     * 中文名称
     */
        private String name;
    /**
     * 物理名称
     */
        private String physicalName;
    /**
     * 表类型，1=主表， 2=从表
     */
        private Integer tableType;
    /**
     * 编码
     */
        private String tableCode;
    /**
     * 简介
     */
        private String note;
    /**
     * 提示信息
     */
        private String tooltip;
    /**
     * 复制表结构id
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long copyTableId;
    /**
     * 
     */
        private String path;
    /**
     * 是否有子节点
     */
        private Integer hasChildren;
    /**
     * 排序字段
     */
        private Integer sort;
    /**
     * 创建时间
     */
        private Date createTime;
    /**
     * 创建人员ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long createUserId;

}
