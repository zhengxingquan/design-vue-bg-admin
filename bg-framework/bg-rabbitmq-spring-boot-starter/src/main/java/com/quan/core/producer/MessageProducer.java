package com.quan.core.producer;

import com.quan.core.response.DetailResponse;

/***
 *   消息生产者
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 18:26
 */
public interface MessageProducer {

    /***
     *  消息发送逻辑
     * @author zxq(956607644 @ qq.com)
     * @date 2021/4/28 18:26
     * @param message

     * @return com.quan.core.common.DetailResponse
     */
    DetailResponse send(Object message);

}