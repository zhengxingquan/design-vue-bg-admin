package com.quan.core.constant;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
public enum AuthClientState {

    ENABLE(0),
    DISABLED(0);

    private Integer code;

    AuthClientState(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
