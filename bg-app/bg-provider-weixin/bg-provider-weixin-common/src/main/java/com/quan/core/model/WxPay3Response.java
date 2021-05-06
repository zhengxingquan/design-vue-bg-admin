package com.quan.core.model;

import com.quan.core.constant.http.Header;
import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxPay3Response extends BaseModel {
    private String body;
    private int status;
    private Header header;
}
