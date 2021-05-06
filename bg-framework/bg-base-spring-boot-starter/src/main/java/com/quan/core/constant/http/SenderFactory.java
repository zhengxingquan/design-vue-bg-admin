package com.quan.core.constant.http;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface SenderFactory {

    Sender create(Request request);
}
