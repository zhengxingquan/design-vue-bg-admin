package com.quan.core.pay.constant;

/***
 * 支付途径
 * @author zxq(956607644 @ qq.com)
 * @date 2021/2/3 17:58
 */
public enum PayWay {
    PC("PC,平板", 1),
    MOBILE("手机", 2);

    private Integer code;
    private String name;

    private PayWay(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getName(Integer code, String name) {
        for (PayWay c : PayWay.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
