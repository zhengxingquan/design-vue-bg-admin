package com.quan.core.common;


/***
 * 消费者枚举常量
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 17:43
 */
public enum ConsumerResultEnum {

    SEND(0, "收到消息,未确认"),
    SUCCESS(1, "收到消息，确认消费成功"),
    FAIL(2, "收到消息，确认消费失败");

    private Integer code;
    private String desc;

    ConsumerResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
