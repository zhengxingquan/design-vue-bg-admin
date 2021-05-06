package com.quan.core.constant.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;


/***
 *   日志实体
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 17:50
 */
@Data
@NoArgsConstructor
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
public class SysLog extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5398795297842978376L;


    @TableField("trace_Id")
    private String traceId;
    /***
     * 用户名
     */
    @TableField("username")
    private String username;
    /***
     * 执行方法的参数值
     */
    @TableField("params")
    private String params;

    /***
     * 执行方法的结果
     */
    @TableField("response_result")
    private String responseResult;

    /***
     * 错误信息
     */
    @TableField("error")
    private String error;
    /**
     * 是否执行成功
     */
    @TableField("flag")
    private Boolean flag;
    /**
     * 归属模块
     */
    @TableField("module")
    private String module;
    /**
     * 操作系统
     */
    @TableField("os")
    private String os;

    /**
     * 浏览器类型
     */
    @TableField("browser")
    private String browser;

    /**
     * IP地址
     */
    @TableField("ip")
    private String ip;
    /**
     * 物理地址
     */
    @TableField("mac")
    private String mac;

    /**
     * 请求地址
     */
    @TableField("request_url")
    private String requestUrl;

    /**
     * 开始时间
     */
    @TableField("start_time")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long endTime;
}
