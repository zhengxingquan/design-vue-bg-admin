package com.quan.core.common.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 19:56
 */
@Data
@Builder
public final class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "数据信息")
    private T data;
    @ApiModelProperty(value = "状态码")
    private Integer code = 0;
    @ApiModelProperty(value = "错误消息")
    private String msg;


    public static <T> Result<T> succeed(String msg) {
        return succeedWith(null, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T data) {
        return succeedWith(data, CodeEnum.SUCCESS.getCode(), "");
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return succeedWith(model, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(Integer code, String msg) {
        return succeedWith(null, code, msg);
    }


    public static <T> Result<T> succeedWith(T data, Integer code, String msg) {
        return failedWith(data, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(T model, String msg) {
        return failedWith(model, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(Integer code, String msg) {
        return failedWith(null, code, msg);
    }


    public static <T> Result<T> failedWith(T data, Integer code, String msg) {
        return new Result<T>(data, code, msg);
    }

}
