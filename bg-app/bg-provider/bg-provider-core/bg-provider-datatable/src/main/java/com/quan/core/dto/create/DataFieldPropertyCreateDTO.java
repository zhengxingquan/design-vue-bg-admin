package com.quan.core.dto.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统字段属性表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:19:31
 */

@Getter
@Setter
@Data
public class DataFieldPropertyCreateDTO {

    /**
     * ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long id;
    /**
     * 父节点
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
    /**
     * 名称
     */
        private String name;
    /**
     * 
     */
        private String code;
    /**
     * 系统编码(用于查询使用，全局唯一)
     */
        private String sysCode;
    /**
     * 数据库中数据类型
     */
        private String dbFieldType;
    /**
     * 简介
     */
        private String note;
    /**
     * 路径
     */
        private String path;
    /**
     * 排序字段
     */
        private Integer sort;
    /**
     * 是否有子节点
     */
        private Integer hasChildren;
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
