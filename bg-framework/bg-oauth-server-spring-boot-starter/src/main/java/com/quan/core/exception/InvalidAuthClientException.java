package com.quan.core.exception;

import org.springframework.security.oauth2.common.exceptions.InvalidClientException;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/5
 * 描述：
 */
public class InvalidAuthClientException extends InvalidClientException {

    public InvalidAuthClientException(String msg) {
        super(msg);
    }
}
