package com.quan.core.eexception;

import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
public class AuthClientAuthenticationException extends UnapprovedClientAuthenticationException {

    public AuthClientAuthenticationException(String msg) {
        super(msg);
    }

    public AuthClientAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
}
