package com.quan.core.producer;

import com.quan.core.response.DetailResponse;

/***
 * 消息发送者
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 18:21
 */
public interface MessageSender {


    /***
     * 发送消息
     * @author zxq(956607644 @ qq.com)
     * @date 2021/4/28 18:22
     * @param message

     * @return com.quan.core.common.DetailResponse
     */
    DetailResponse send(Object message);

    /***
     * 发送消息
     * @author zxq(956607644@qq.com)
     * @date 2021/4/28 18:22
     * @param messageWithTime

     * @return com.quan.core.common.DetailResponse
     */
    DetailResponse send(MessageWithTime messageWithTime);
}