package com.quan.core.comsumer;

import com.quan.core.MqParam;
import com.quan.core.constant.FastOcpRabbitMqConstants;
import com.quan.core.producer.MessageProcess;
import com.quan.core.response.DetailResponse;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/***
 * MQ 消费者 代码
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 18:20
 */
@Slf4j
@SuppressWarnings("all")
public class FastBuildRabbitMqConsumer {

    private final ConnectionFactory connectionFactory;

    public FastBuildRabbitMqConsumer(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }


    public <T> MessageConsumer buildMessageConsumer(final MqParam mqParam,
                                                    final MessageProcess<T> messageProcess) throws IOException {

        // 获取连接
        final Connection connection = connectionFactory.createConnection();

        //1 创建连接和channel
        buildQueue(mqParam, connection);

        //2 设置message序列化方法
        final MessagePropertiesConverter messagePropertiesConverter = new DefaultMessagePropertiesConverter();
        final MessageConverter messageConverter = new Jackson2JsonMessageConverter();

        //3 consume
        return new MessageConsumer() {
            Channel channel;

            {
                channel = connection.createChannel(false);
            }


            @Override
            public DetailResponse consume() {
                try {
                    //1 通过basicGet获取原始数据
                    GetResponse response = channel.basicGet(mqParam.getQueue(), false);

                    while (response == null) {
                        response = channel.basicGet(mqParam.getQueue(), false);
                        Thread.sleep(FastOcpRabbitMqConstants.ONE_SECOND);
                    }

                    Message message = new Message(response.getBody(),
                            messagePropertiesConverter.toMessageProperties(response.getProps(), response.getEnvelope(), "UTF-8"));

                    //2 将原始数据转换为特定类型的包
                    T messageBean = (T) messageConverter.fromMessage(message);

                    //3 处理数据
                    DetailResponse detailRes;

                    try {
                        // 处理数据方法
                        detailRes = messageProcess.process(messageBean);
                    } catch (Exception e) {
                        log.error("exception", e);
                        detailRes = new DetailResponse(false, "process exception: " + e, "");
                    }

                    //4 手动发送ack确认
                    if (detailRes.isSuccessState()) {
                        channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
                    } else {
                        //避免过多失败log
                        Thread.sleep(FastOcpRabbitMqConstants.ONE_SECOND);
                        log.info("process message failed: " + detailRes.getErrorMsg());
                        channel.basicNack(response.getEnvelope().getDeliveryTag(), false, true);
                    }

                    return detailRes;
                } catch (InterruptedException e) {
                    log.error("exception", e);
                    return new DetailResponse(false, "interrupted exception " + e.toString(), "");
                } catch (ShutdownSignalException | ConsumerCancelledException | IOException e) {
                    log.error("exception", e);

                    try {
                        channel.close();
                    } catch (IOException | TimeoutException ex) {
                        log.error("exception", ex);
                    }
                    channel = connection.createChannel(false);
                    return new DetailResponse(false, "shutdown or cancelled exception " + e.toString(), "");
                } catch (Exception e) {
                    log.info("exception : ", e);
                    try {
                        channel.close();
                    } catch (IOException | TimeoutException ex) {
                        ex.printStackTrace();
                    }
                    channel = connection.createChannel(false);
                    return new DetailResponse(false, "exception " + e.toString(), "");
                }
            }
        };
    }


    private void buildQueue(final MqParam param,
                            final Connection connection) throws IOException {
        Channel channel = connection.createChannel(false);

        channel.exchangeDeclare(param.getExchange(), param.getType().getValue(), true, false, null);

        channel.queueDeclare(param.getQueue(), true, false, false, null);
        channel.queueBind(param.getQueue(), param.getExchange(), param.getRoutingKey());

        try {
            channel.close();
        } catch (TimeoutException e) {
            log.info("close channel time out ", e);
        }
    }
}
