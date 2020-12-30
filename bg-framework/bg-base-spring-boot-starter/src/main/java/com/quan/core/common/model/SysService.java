package com.quan.core.common.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/***
 *   服务API实体
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 16:31
 */
@Data
public class SysService extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 749360940290141180L;
//    @JsonSerialize(using = ToStringSerializer.class)
//    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    private String name;
    private String path;
    private Integer sort;
    private Integer isService;

}