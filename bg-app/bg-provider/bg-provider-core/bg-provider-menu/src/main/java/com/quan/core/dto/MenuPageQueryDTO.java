package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.dto.query.PageQueryDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统菜单表 分页查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 17:50:17
 */

@Getter
@Setter
@Data
public class MenuPageQueryDTO extends PageQueryDTO {

        /**
     * 父级ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
            /**
     * 菜单名称
     */
        private String name;
            /**
     * 菜单别名
     */
        private String aliasName;
            /**
     * 
     */
        private String code;
            /**
     * 树路径
     */
        private String path;
            /**
     * 资源类型(0 资源对象 1 菜单对象)
     */
        private Integer type;
            /**
     * 菜单链接
     */
        private String href;
            /**
     * 打开方式
     */
        private String target;
            /**
     * 菜单图标
     */
        private String menuIcon;
            /**
     * 权限标识
     */
        private String permission;
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
