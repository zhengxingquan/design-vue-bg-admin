package com.quan.core.common.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 19:56
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "状态码")
    protected Integer code = CodeEnum.SUCCESS.getCode();
    @ApiModelProperty(value = "错误消息")
    protected String msg;

    public static <T> Result<T> succeed(String msg) {
        return succeedWith(CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed() {
        return succeedWith(CodeEnum.SUCCESS.getCode(), "");
    }


    public static <T> Result<T> succeed(Integer code, String msg) {
        return succeedWith(code, msg);
    }


    public static <T> Result<T> succeedWith(Integer code, String msg) {
        return failedWith(code, msg);
    }

    public static <T> Result<T> failed() {
        return failedWith(CodeEnum.ERROR.getCode(), "");
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(CodeEnum.ERROR.getCode(), msg);
    }


    public static <T> Result<T> failed(Integer code, String msg) {
        return failedWith(code, msg);
    }

    public static <T> Result<T> failedWith(Integer code, String msg) {
        return new Result<T>(code, msg);
    }

}
