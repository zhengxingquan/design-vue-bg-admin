package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxMatchRule extends BaseModel {
    String tag_id;
    String sex;
    String country;
    String province;
    String city;
    String client_platform_type;
    String language;
}
