package com.quan.core.common.exception;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
public class FailToSetValueException extends BaseException {
    public FailToSetValueException(String msg) {
        super(msg);
    }

    public FailToSetValueException(Exception e) {
        super(e);
    }

    public FailToSetValueException(String msg, Object... args) {
        super(msg, args);
    }
}
