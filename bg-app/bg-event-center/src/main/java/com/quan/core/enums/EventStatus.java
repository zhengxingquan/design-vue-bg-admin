package com.quan.core.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述： 事件状态
 */
public enum EventStatus {

    /**
     * 排队中
     */
    LINE_UP(0),
    /**
     * 执行中
     */

    RUNNING(1),
    /**
     * 执行完成
     */
    FINISH(2),
    /**
     * 执行失败
     */
    FAIL(3);


    private static Map<Integer, EventStatus> statusMap = new HashMap<>();

    static {
        for (final EventStatus status : EventStatus.values()) {
            statusMap.put(status.getCode(), status);
        }
    }

    private int code;

    EventStatus(int code) {
        this.code = code;
    }

    public static EventStatus valueOf(Integer code) {
        EventStatus status = statusMap.get(code);
        if (Objects.isNull(status)) {
            return FAIL;
        }
        return status;
    }

    public int getCode() {
        return code;
    }
}
