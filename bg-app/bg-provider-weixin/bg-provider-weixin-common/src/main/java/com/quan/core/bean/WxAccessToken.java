package com.quan.core.bean;

import com.quan.core.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxAccessToken extends BaseModel {

    protected String token;

    protected int expires;

    protected long lastCacheTimeMillis;
}
