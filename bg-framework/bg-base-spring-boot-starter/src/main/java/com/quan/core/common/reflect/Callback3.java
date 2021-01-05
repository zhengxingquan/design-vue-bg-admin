package com.quan.core.common.reflect;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 *
 * 带三个参数的通用回调接口
 */
public interface Callback3<T0, T1, T2> {

    void invoke(T0 arg0, T1 arg1, T2 arg2);
}
