package com.quan.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/***
 * RabbitMQ 配置类
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 17:38
 */
@Data
@ConfigurationProperties(prefix = "bg.fast.rabbitmq")
public class RabbitMQProperties {

    /***
     * 是否开启
     */
    private boolean enable;

    /***
     * mq地址
     */
    private String addresses;

    /***
     * 用户名
     */
    private String username;
    /***
     * 密码
     */
    private String password;
    /***
     * 主机名称
     */
    private String virtualHost;

    /***
     * 发送确认
     */
    private boolean publisherConfirms = true;
}
