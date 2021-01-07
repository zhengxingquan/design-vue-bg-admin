package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.common.dto.query.PageQueryDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统字段表 分页查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:29:07
 */

@Getter
@Setter
@Data
public class DataFieldPageQueryDTO extends PageQueryDTO {

        /**
     * 数据表ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
            /**
     * 中文名称
     */
        private String name;
            /**
     * 编码
     */
        private String dataFieldCode;
            /**
     * 物理名称
     */
        private String physicalName;
            /**
     * 枚举依赖字段id
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long enumDataFieldId;
            /**
     * 被依赖字段id
     */
        private String enumDependFieldId;
            /**
     * 关联编号
     */
        private String associationId;
            /**
     * 枚举值id
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long enumId;
            /**
     * 字段属性：1=逻辑字段，2=物理字段
     */
        private Integer dataFieldProperty;
            /**
     * 字段长度
     */
        private Integer dataFieldLength;
            /**
     * 字段是否必填
     */
        private Integer requiredDataField;
            /**
     * 字段类型ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long dataFieldTypeId;
            /**
     * 小数位数长度，（主要针对于 实数类型 ）
     */
        private Integer decimalLength;
            /**
     * 正则表达式
     */
        private String regexExpression;
            /**
     * 字段记录引用id
     */
        private String expressionId;
            /**
     * 提示信息
     */
        private String tooltip;
            /**
     * 备注
     */
        private String note;
            /**
     * 是否建立索引(0 不是索引 ， 1 是索引)
     */
        private Integer indexAble;
            /**
     * 字段类别(0 共有字段 1 私有字段)
     */
        private Integer dataFieldState;
            /**
     * 排序字段
     */
        private Integer sort;
            /**
     * 树路径
     */
        private String path;
                        
}
