package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * 系统菜单表 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 18:42:13
 */

@Getter
@Setter
@Data
public class MenuGroupQueryDTO {

        /**
    * 父级ID
    */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
            /**
    * 组名称
    */
        private String groupName;
            /**
    * 组别名
    */
        private String groupAliasName;
            /**
    * 编码
    */
        private String groupCode;
            /**
    * 树路径
    */
        private String path;
            /**
    * 菜单介绍
    */
        private String note;
            /**
    * 是否有子节点
    */
        private Integer hasChildren;
            /**
    * 排序字段
    */
        private Integer sort;
                        
}
