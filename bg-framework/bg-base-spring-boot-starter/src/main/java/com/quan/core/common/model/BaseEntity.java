package com.quan.core.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.common.enume.DataEntityState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/15
 * 描述：
 */
@Data
public abstract class BaseEntity implements Serializable {


//    private static final long serialVersionUID = -1L;

    /* 主键字段，类型位  Long 雪花算法*/
    @TableId(value = "id", type = IdType.ASSIGN_ID)  //雪花算法  id生成策略
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /***
     * 创建时间
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /***
     * 修改时间
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /***
     * 创建人员ID
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;
    /***
     * 修改人员ID
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

    /***
     * 数据状态
     */
    @TableField(value = "data_state")
    private Integer dataState = DataEntityState.ENABLE.getValue();
}
