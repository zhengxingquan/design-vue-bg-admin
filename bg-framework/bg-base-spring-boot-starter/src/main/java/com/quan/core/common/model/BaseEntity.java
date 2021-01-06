package com.quan.core.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.common.annotation.batis.PrevInsert;
import com.quan.core.common.enume.DataEntityState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/15
 * 描述：业务类实体类父类
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    /***
     * 百度的UUid 雪花算法
     */
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;
    /***
     * 创建时间 （存放时间戳）
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "create_time")
    @PrevInsert
    protected Date createTime;
    /***
     * 修改时间 （存放时间戳）
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "update_time")
    protected Date updateTime;

    /***
     * 创建人员ID
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "create_user_id")
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long createUserId;
    /***
     * 修改人员ID
     * 注意！这里需要标记为填充字段
     */
    @TableField(value = "update_user_id")
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long updateUserId;

    /***
     * 数据状态
     */
    @TableField(value = "data_state")
    protected Integer dataState = DataEntityState.ENABLE.getValue();
}
