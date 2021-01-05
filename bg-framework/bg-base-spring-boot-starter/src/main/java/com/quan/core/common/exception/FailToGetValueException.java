package com.quan.core.common.exception;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
public class FailToGetValueException extends BaseException {

    public FailToGetValueException(String msg) {
        super(msg);
    }

    public FailToGetValueException(Exception e) {
        super(e);
    }

    public FailToGetValueException(String msg, Object... args) {
        super(msg, args);
    }
}
