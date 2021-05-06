package com.quan.core.constant.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/15
 * 描述：
 */
public enum DataEntityState {
    /***
     * 启用
     */
    ENABLE(0),

    /***
     * 不启用（禁用）
     */
    DISABLED(-1),
    /***
     * 删除
     */
    DELETE(1);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    DataEntityState(int value) {
        this.value = value;
    }

    private static Map<Integer, DataEntityState> statusMap = new HashMap<>();

    static {
        for (final DataEntityState status : DataEntityState.values()) {
            statusMap.put(status.getValue(), status);
        }
    }

    public static DataEntityState valueOf(Integer code) {
        DataEntityState status = statusMap.get(code);
        if (Objects.isNull(status)) {
            return ENABLE;
        }
        return status;
    }

}
