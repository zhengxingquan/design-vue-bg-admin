package com.quan.core.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
public enum AuthErrorCode {

    FAIL(0, ""),
    CLIENT_ID_EMPTY(1, "请求参数中无clientId信息"),
    CLIENT_SECRET_EMPTY(2, "请求参数中无clientSecret信息"),
    CLIENT_ID_NOT_EXISTS(3, "clientId对应的信息不存在"),
    CLIENT_SECRET_ERROR(4, "clientSecret不匹配"),

    CLIENT_EXISTS_ERROR(10, "CLIENT 已存在"),
    CLIENT_NOT_EXISTS_ERROR(11, "CLIENT 不存在");


    private Integer code;
    private String msg;

    AuthErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    private static Map<Integer, AuthErrorCode> statusMap = new HashMap<>();

    static {
        for (final AuthErrorCode status : AuthErrorCode.values()) {
            statusMap.put(status.getCode(), status);
        }
    }

    public static AuthErrorCode valueOf(Integer code) {
        AuthErrorCode status = statusMap.get(code);
        if (Objects.isNull(status)) {
            return FAIL;
        }
        return status;
    }

}
