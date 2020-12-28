package com.quan.core.common.web;

/***
 *  成功 与 失败 的状态码
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/25 13:41
 */
public enum CodeEnum {

    SUCCESS(0),
    ERROR(1);

    private Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
