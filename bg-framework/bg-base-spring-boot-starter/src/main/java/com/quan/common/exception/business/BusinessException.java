package com.quan.common.exception.business;

import com.quan.common.exception.BaseException;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/15
 * 描述： 业务日志
 */
public class BusinessException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 8325096920926406459L;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Exception e) {
        this(e.getMessage());
    }
}
