package com.quan.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/5
 * 描述：
 */
public class AuthClientAuthenticationException extends AuthenticationException {

    public AuthClientAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthClientAuthenticationException(String msg) {
        super(msg);
    }
}
