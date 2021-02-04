package com.quan.core.dto.client;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
@Data
public class AuthClientUpdateStateDTO extends AuthClientDTO {


    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private int state;

}
