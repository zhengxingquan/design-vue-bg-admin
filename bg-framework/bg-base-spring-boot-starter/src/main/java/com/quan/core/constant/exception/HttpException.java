package com.quan.core.constant.exception;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class HttpException extends BaseException{

    public HttpException(String msg) {
        super(msg);
    }

    public HttpException(Exception e) {
        this(e.getMessage());
    }

    public HttpException(String msg, Object... args) {
        this(String.format(msg, args));
    }
}
