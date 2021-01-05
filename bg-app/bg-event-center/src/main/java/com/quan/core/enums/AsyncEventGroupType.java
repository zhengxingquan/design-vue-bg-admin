package com.quan.core.enums;

import java.util.HashSet;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述： 异步任务类型
 */
public enum AsyncEventGroupType {

    /**
     * 组织架构相关异步任务
     */
    ORGANIZATION(100, 2);


    static {
        HashSet<Integer> codes = new HashSet<>();
        for (final AsyncEventGroupType value : AsyncEventGroupType.values()) {
            boolean result = codes.add(value.getCode());
            if (!result) {
                throw new RuntimeException("Queue Type code repeat,repeat code is " + value.getCode());
            }
        }
    }

    private final int code;
    private final int processNum;

    AsyncEventGroupType(int code, int processNum) {
        this.code = code;
        this.processNum = processNum;
    }


    public int getCode() {
        return code;
    }

    public int getProcessNum() {
        return processNum;
    }
}
