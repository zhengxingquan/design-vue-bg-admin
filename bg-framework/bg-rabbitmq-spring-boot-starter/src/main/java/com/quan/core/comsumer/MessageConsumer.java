package com.quan.core.comsumer;


import com.quan.core.common.DetailResponse;

/***
 *  消息消费接口
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 18:25

 * @return
 */
public interface MessageConsumer {

    /***
     *   消费逻辑
     * @author zxq(956607644 @ qq.com)
     * @date 2021/4/28 18:25
     * @param

     * @return com.quan.core.common.DetailResponse
     */
    DetailResponse consume();
}
