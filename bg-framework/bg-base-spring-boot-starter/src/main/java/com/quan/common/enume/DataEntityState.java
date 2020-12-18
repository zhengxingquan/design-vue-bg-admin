package com.quan.common.enume;

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
}
