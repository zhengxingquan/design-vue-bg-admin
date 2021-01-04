package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxUser extends BaseModel {

    private int subscribe;
    private  String openid;
    private  String nickname;
    private  int sex;
    private  String language;
    private  String city;
    private  String province;
    private  String country;
    private  String headimgurl;
    private long subscribe_time;
}
