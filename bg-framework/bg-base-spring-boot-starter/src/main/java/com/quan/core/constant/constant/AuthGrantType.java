package com.quan.core.constant.constant;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/25
 * 描述： oauth2 认证的 4 中类型
 */
public enum AuthGrantType {

    AUTHORIZATION_CODE("authorization_code"),
    PASSWORD("password"),
    REFRESH_TOKEN("refresh_token"),
    CLIENT_CREDENTIALS("client_credentials"),
    IMPLICIT("implicit"),
    SMS("sms");


    private String value;

    AuthGrantType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
