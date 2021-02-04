package com.quan.core.dto.token;

import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
@Data
public class ValidCodeTokenDTO extends ClientTokenDTO {

    private String deviceId;
    private String validCode;
}
