package com.quan.core.producer;


import com.quan.core.response.DetailResponse;

/***
 *  消息处理接口
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 18:23
 */
public interface MessageProcess<T> {

    /***
     * 消息处理逻辑
     * @author zxq(956607644 @ qq.com)
     * @date 2021/4/28 18:24
     * @param message

     * @return com.quan.core.common.DetailResponse
     */
    DetailResponse process(T message);
}
