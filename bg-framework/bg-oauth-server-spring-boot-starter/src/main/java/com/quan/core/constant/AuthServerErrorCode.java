package com.quan.core.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/5
 * 描述：
 */
public enum AuthServerErrorCode {

    FAIL(0, ""),

    AUTH_SERVER_CLIENT_NOT_EXISTS(1, "应用获取失败"),
    AUTH_SERVER_CLIENT_IS_DISABLED(2, "应用不存在"),
    AUTH_SERVER_CLIENT_DATA_STATE_ERROR(3, "应用状态不合法");

    private Integer code;
    private String msg;


    AuthServerErrorCode(Integer code, String msg) {
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

    private static Map<Integer, AuthServerErrorCode> statusMap = new HashMap<>();

    static {
        for (final AuthServerErrorCode status : AuthServerErrorCode.values()) {
            statusMap.put(status.getCode(), status);
        }
    }

    public static AuthServerErrorCode valueOf(Integer code) {
        AuthServerErrorCode status = statusMap.get(code);
        if (Objects.isNull(status)) {
            return FAIL;
        }
        return status;
    }

}
