package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 *
 * 代金券
 */
@Data
public class WxPayCoupon  extends BaseModel {

    private String coupon_stock_id;
    private int  openid_count;
    private String partner_trade_no;
    private String openid;
    private String appid;
    private String mch_id;
    private String op_user_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String version;
    private String type;
}
