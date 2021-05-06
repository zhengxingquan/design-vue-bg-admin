package com.quan.core.producer;

import com.quan.core.MqParam;
import com.quan.core.cache.RetryCache;
import com.quan.core.constant.FastOcpRabbitMqConstants;
import com.quan.core.constant.MqExchangeTypes;
import com.quan.core.response.DetailResponse;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/***
 *  消息生产者
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 17:47
 */
@Slf4j
public class FastBuildRabbitMqProducer {

    private final ConnectionFactory connectionFactory;

    public FastBuildRabbitMqProducer(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /***
     *
     * @author zxq(956607644 @ qq.com)
     * @date 2021/4/28 17:52
     * @param exchange
     * @param routingKey
     * @param queue
     * @return com.quan.core.producer.MessageSender
     */
    public MessageSender buildDirectMessageSender(final String exchange,
                                                  final String routingKey,
                                                  final String queue) throws IOException {
        return buildMessageSender(exchange, routingKey, queue, MqExchangeTypes.MQ_DIRECT);
    }

    /***
     *
     * @author zxq(956607644 @ qq.com)
     * @date 2021/4/28 17:55
     * @param exchange
     * @param routingKey
     * @return @see com.quan.core.producer.MessageSender
     */
    public MessageSender buildTopicMessageSender(final String exchange,
                                                 final String routingKey) throws IOException {
        return buildMessageSender(exchange, routingKey, null, MqExchangeTypes.MQ_TOPIC);
    }

    /**
     * 发送消息
     *
     * @param exchange   消息交换机
     * @param routingKey 消息路由key
     * @param queue      消息队列
     * @param type       消息类型
     *                   return
     */
    private MessageSender buildMessageSender(final String exchange,
                                             final String routingKey,
                                             final String queue,
                                             final MqExchangeTypes type) throws IOException {

        Connection connection = connectionFactory.createConnection();
        //1
        if (MqExchangeTypes.MQ_DIRECT.equals(type)) {
            buildQueue(
                    MqParam.builder().exchange(exchange).routingKey(routingKey).queue(queue).type(type).build(), connection);
        } else if (MqExchangeTypes.MQ_TOPIC.equals(type)) {
            buildTopic(exchange, connection);
        }

        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setExchange(exchange);
        rabbitTemplate.setRoutingKey(routingKey);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        RetryCache retryCache = new RetryCache();

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                log.info("send message failed: " + cause + correlationData.toString());
            } else {
                log.info("send message success: " + cause + correlationData.toString());
                retryCache.del(Long.valueOf(correlationData.getId()));
            }
        });

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, tmpExchange, tmpRoutingKey) -> {
            try {
                Thread.sleep(FastOcpRabbitMqConstants.ONE_SECOND);
            } catch (InterruptedException e) {
                log.error("mq 失败 {}", e);
            }

            log.info("send message failed: " + replyCode + " " + replyText);
            rabbitTemplate.send(message);
        });

        return new MessageSender() {
            {
                retryCache.setSender(this);
            }

            @Override
            public DetailResponse send(Object message) {
                long id = retryCache.generateId();
                long time = System.currentTimeMillis();

                return send(new MessageWithTime(id, time, message));
            }

            @Override
            public DetailResponse send(MessageWithTime messageWithTime) {
                try {
                    retryCache.add(messageWithTime);
                    rabbitTemplate.correlationConvertAndSend(messageWithTime.getMessage(),
                            new CorrelationData(String.valueOf(messageWithTime.getId())));
                } catch (Exception e) {
                    return new DetailResponse(false, "", "");
                }
                return new DetailResponse(true, "", "");
            }
        };
    }


    private Channel createChannel(final Connection connection) {
        return connection.createChannel(false);
    }


    private final void buildQueue(final MqParam mqParam,
                                  final Connection connection) throws IOException {

        Channel channel = createChannel(connection);
        channel.exchangeDeclare(mqParam.getExchange(), mqParam.getType().getValue(), true, false, null);
        channel.queueDeclare(mqParam.getQueue(), true, false, false, null);
        channel.queueBind(mqParam.getQueue(), mqParam.getExchange(), mqParam.getRoutingKey());
        try {
            channel.close();
        } catch (TimeoutException e) {
            log.info("close channel time out ", e);
        }
    }


    private final void buildTopic(String exchange, Connection connection) throws IOException {
        Channel channel = createChannel(connection);
        channel.exchangeDeclare(exchange, MqExchangeTypes.MQ_TOPIC.getValue(), true, false, null);
        try {
            channel.close();
        } catch (TimeoutException e) {
            log.info("close channel time out ", e);
        }
    }


}
