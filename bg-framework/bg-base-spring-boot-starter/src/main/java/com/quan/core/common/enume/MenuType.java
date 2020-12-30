package com.quan.core.common.enume;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/29
 * 描述：菜单类型枚举
 */
public enum MenuType {

    MENU("菜单"),
    SOURCE("资源");

    private String value;

    MenuType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
