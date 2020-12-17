package com.quan.common.util;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：带一个参数的通用回调接口
 */
public interface Callback<T> {

    void invoke(T obj);

}
