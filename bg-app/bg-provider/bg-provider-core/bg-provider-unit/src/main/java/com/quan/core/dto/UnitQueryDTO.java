package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * 系统单位表 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-31 15:39:39
 */

@Getter
@Setter
@Data
public class UnitQueryDTO {

        /**
    * 父级ID
    */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
            /**
    * 单位名称
    */
        private String name;
            /**
    * 单位别名
    */
        private String aliasName;
            /**
    * 机构编码
    */
        private String unitCode;
            /**
    * 路径
    */
        private String path;
            /**
    * 附加值一
    */
        private String field1;
            /**
    * 附加值二
    */
        private String field2;
            /**
    * 附加值三
    */
        private String field3;
            /**
    * 单位介绍
    */
        private String note;
            /**
    * 排序字段
    */
        private Integer sort;
            /**
    * 是否有子节点
    */
        private Integer hasChildren;
                        
}
