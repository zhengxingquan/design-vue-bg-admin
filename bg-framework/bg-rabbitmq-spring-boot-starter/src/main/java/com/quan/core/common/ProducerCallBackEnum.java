package com.quan.core.common;

/***
 * 生产者枚举常量
 * @author zxq(956607644@qq.com)
 * @date 2021/4/28 17:46
 */
public enum ProducerCallBackEnum {

    SEND(0,"消息发送,无反馈"),
    SUCCESS(1,"消息发送到broker成功"),
    FAIL(2,"消息发送到broker失败");

    private Integer code;
    private String desc;

    ProducerCallBackEnum(Integer code, String desc) {
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
