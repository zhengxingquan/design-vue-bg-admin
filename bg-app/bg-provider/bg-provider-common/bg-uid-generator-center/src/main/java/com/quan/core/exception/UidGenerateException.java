package com.quan.core.exception;

import com.quan.core.constant.exception.BaseException;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/2
 * 描述：
 */
public class UidGenerateException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1412104290896291466L;

    public UidGenerateException(String msg) {
        super(msg);
    }

    public UidGenerateException(Exception e) {
        this(e.getMessage());
    }

}