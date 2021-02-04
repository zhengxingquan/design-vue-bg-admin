package com.quan.core.pay.constant;

/***
 * 支付类型
 * @author zxq(956607644 @ qq.com)
 * @date 2021/2/3 17:56
 * @return
 */
public enum PayType {

    ALIBABA("支付宝", 1),
    WECHAT("微信", 2),
    UNION("银联", 3);

    private Integer code;
    private String name;

    PayType(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getName(Integer code, String name) {
        for (PayType c : PayType.values()) {
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
