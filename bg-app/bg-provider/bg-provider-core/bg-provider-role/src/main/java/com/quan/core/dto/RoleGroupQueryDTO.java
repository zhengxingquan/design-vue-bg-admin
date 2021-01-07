package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * 系统角色分组表 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:07:02
 */

@Getter
@Setter
@Data
public class RoleGroupQueryDTO {

        /**
    * 父节点
    */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
            /**
    * 角色名称
    */
        private String groupName;
            /**
    * 角色编码
    */
        private String groupCode;
            /**
    * 角色别名
    */
        private String groupAliasName;
            /**
    * 是否有子节点
    */
        private Integer hasChildren;
            /**
    * 路径编码用于查询与删除
    */
        private String path;
            /**
    * 备注
    */
        private String note;
            /**
    * 排序字段
    */
        private Integer sort;
                        
}
