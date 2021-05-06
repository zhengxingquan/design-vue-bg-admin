package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.dto.query.PageQueryDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统数据表 分页查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:05:24
 */

@Getter
@Setter
@Data
public class DataTablePageQueryDTO extends PageQueryDTO {

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
                        
}
