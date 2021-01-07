package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * 系统数据仓库表 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 22:12:27
 */

@Getter
@Setter
@Data
public class DatabaseQueryDTO {

        /**
    * 父节点
    */
        private String parentId;
            /**
    * 中文名称
    */
        private String name;
            /**
    * 物理名称
    */
        private String physicalName;
            /**
    * 编码
    */
        private String databaseCode;
            /**
    * 树路径
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
    * 简介
    */
        private String note;
                        
}
