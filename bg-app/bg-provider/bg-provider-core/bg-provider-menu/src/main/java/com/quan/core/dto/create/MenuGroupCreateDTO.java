package com.quan.core.dto.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统菜单表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 18:42:13
 */

@Getter
@Setter
@Data
public class MenuGroupCreateDTO {

    /**
     * ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long id;
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
    /**
     * 操作时间
     */
        private Date createTime;
    /**
     * 操作人
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long createUserId;

}
