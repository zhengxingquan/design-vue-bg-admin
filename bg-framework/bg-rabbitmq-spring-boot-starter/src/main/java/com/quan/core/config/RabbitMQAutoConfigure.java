package com.quan.core.config;

import com.quan.core.producer.FastBuildRabbitMqProducer;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * RabbitMQAutoConfigure 配置
 * @author zxq(956607644@qq.com)
 * @date 2021/4/28 17:37
 */

@Configuration
@ConditionalOnClass(FastBuildRabbitMqProducer.class)
@EnableConfigurationProperties(RabbitMQProperties.class)
public class RabbitMQAutoConfigure {


    @Autowired
    private RabbitMQProperties rabbitMQProperties;

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    @ConditionalOnMissingBean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(rabbitMQProperties.getAddresses());
        connectionFactory.setUsername(rabbitMQProperties.getUsername());
        connectionFactory.setPassword(rabbitMQProperties.getPassword());
        connectionFactory.setVirtualHost(rabbitMQProperties.getVirtualHost());
        connectionFactory.setPublisherConfirms(rabbitMQProperties.isPublisherConfirms());
        return connectionFactory;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "bg.fast.rabbitmq", value = "enable", havingValue = "true")
    public FastBuildRabbitMqProducer fastRabbitMQProducer(ConnectionFactory connectionFactory) {
        return new FastBuildRabbitMqProducer(connectionFactory);
    }
}
