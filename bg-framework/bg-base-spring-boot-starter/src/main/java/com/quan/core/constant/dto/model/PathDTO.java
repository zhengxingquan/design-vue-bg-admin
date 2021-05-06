package com.quan.core.constant.dto.model;

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
public class PathDTO implements Serializable {

    @NotNull
    private String queryColName = "path";
    /***
     * 父节点的ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long patentId;

    private String value;

    private String path;

}
