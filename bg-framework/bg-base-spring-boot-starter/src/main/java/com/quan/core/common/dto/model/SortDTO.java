package com.quan.core.common.dto.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/30
 * 描述：
 */
@Data
@Getter
@Setter
public class SortDTO implements Serializable {

    @NotNull
    private String queryColName = "sort";
    @JsonSerialize(using = ToStringSerializer.class)
    private Long value;
}
