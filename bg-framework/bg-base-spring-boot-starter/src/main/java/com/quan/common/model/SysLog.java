package com.quan.common.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


/***
 *   日志实体
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 17:50
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
public class SysLog extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5398795297842978376L;


    private String traceId;
    /***
     * 用户名
     */
    private String username;
    /***
     * 执行方法的参数值
     */
    private String params;
    /***
     * 错误信息
     */
    private String error;
    /**
     * 是否执行成功
     */
    private Boolean flag;
    /**
     * 归属模块
     */
    private String module;
    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * IP地址
     */
    private String ip;
    /**
     * 物理地址
     */
    private String mac;

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 耗时,秒
     */
    private Long excuteTime;
}
