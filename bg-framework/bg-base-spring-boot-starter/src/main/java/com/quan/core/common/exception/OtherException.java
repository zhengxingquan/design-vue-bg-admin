package com.quan.core.common.exception;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/15
 * 描述：
 */
public class OtherException extends BaseException {

    public OtherException(String msg) {
        super(msg);
    }

    public OtherException(Exception e) {
        this(e.getMessage());
    }

    public OtherException(String msg, Object... args) {
        this(String.format(msg, args));
    }
}
