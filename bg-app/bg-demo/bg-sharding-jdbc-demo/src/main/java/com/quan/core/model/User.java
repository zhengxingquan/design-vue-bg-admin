package com.quan.core.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.quan.core.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mall
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends BaseEntity {
    private static final long serialVersionUID = 8898492657846787286L;
    private String companyId;
    private String name;
}
