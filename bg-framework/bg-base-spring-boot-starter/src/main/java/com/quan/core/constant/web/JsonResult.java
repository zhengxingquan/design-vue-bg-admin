package com.quan.core.constant.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@NoArgsConstructor
public final class JsonResult<T> extends Result implements Serializable {

    private static final long serialVersionUID = -1L;

    public JsonResult(T data, Integer code, String msg) {
        super(code, msg);
        this.data = data;
    }

    @ApiModelProperty(value = "数据信息")
    private T data;

    public static <T> JsonResult<T> succeed(T data) {
        return succeedWith(data, CodeEnum.SUCCESS.getCode(), "");
    }

    public static <T> JsonResult<T> succeed(T model, String msg) {
        return succeedWith(model, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> JsonResult<T> succeed(Integer code, T model) {
        return succeedWith(model, code, "");
    }

    public static <T> JsonResult<T> succeedWith(T data, Integer code, String msg) {
        return failedWith(data, code, msg);
    }


    public static <T> JsonResult<T> failedWith(T data, Integer code, String msg) {
        return new JsonResult<T>(data, code, msg);
    }

}
