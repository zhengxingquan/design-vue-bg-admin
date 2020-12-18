package com.quan.core.unit.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统单位表
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-18 19:48:27
 */

@Data
@TableName("sys_user")
public class SysUnit implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String parentId;

    private String name;

    private String aliasName;

    private String unitCode;

    private String note;

    private String field1;

    private String field2;

    private String field3;

    private Integer sort;

    private Integer disabled;

    private Integer hasChildren;

    private String logo;

    private Date createTime;

    private Long creatorUserId;

    private Date updateTime;

    private Long updateUserId;

    private Integer dataState;

}
