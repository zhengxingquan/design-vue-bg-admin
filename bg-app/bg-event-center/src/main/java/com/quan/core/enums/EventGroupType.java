package com.quan.core.enums;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
public enum EventGroupType {

    /**
     * 工作流事件
     */
    WORK_FLOW(100),

    /**
     * 员工事件
     */
    EMPLOYEE(200);

    private int code;

    EventGroupType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
