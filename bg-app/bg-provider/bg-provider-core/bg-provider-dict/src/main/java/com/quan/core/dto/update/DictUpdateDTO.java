package com.quan.core.dto.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统字典表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */

@Getter
@Setter
@Data
public class DictUpdateDTO {

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
     * 树路径
     */
    private String path;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 系统编码(用于查询使用，全局唯一)
     */
    private String sysCode;
    /**
     * 有子节点
     */
    private Integer hasChildren;
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
     * 字典简介
     */
    private String note;
    /**
     * 排序字段
     */
    private Integer sort;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新人员的ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updateUserId;

}
