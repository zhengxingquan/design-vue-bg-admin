package com.quan.core.constant.exception;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
public class FailToCastObjectException extends BaseException {
    public FailToCastObjectException(String msg) {
        super(msg);
    }

    public FailToCastObjectException(Exception e) {
        super(e);
    }

    public FailToCastObjectException(String msg, Object... args) {
        super(msg, args);
    }
}
