package com.quan.properties;

import com.quan.base.cons.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：
 */
@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class CoreProperties {
//    private ReliableMessageProperties message = new ReliableMessageProperties();
//    private AliyunProperties aliyun = new AliyunProperties();
//    private AsyncTaskProperties task = new AsyncTaskProperties();
//    private SwaggerProperties swagger = new SwaggerProperties();
//    private QiniuProperties qiniu = new QiniuProperties();
//    private GaodeProperties gaode = new GaodeProperties();
//    private JobProperties job = new JobProperties();
//    private ZookeeperProperties zk = new ZookeeperProperties();
}
