package com.quan.core.callback;

 /***
  * redis 订阅消息回调
  * @author zxq(956607644@qq.com)
  * @date 2021/5/6 18:29
  */
public interface RedisSubscribeCallback {

    /***
     * 回调执行方法
     * @author zxq(956607644@qq.com)
     * @date 2021/5/6 18:29
     * @param msg 消息

     * @return void
     */
    void callback(String msg);
}
