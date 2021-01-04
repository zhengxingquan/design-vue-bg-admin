package com.quan.core.model;

import com.quan.core.model.base.BaseModel;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 *
 * 普通红包
 */
public class WxPayRedPack extends BaseModel {

    private String nonce_str;
    private String sign;
    private String mch_billno;
    private String mch_id;
    private String wxappid;
    private String send_name;
    private String re_openid;
    private int total_amount;
    private int total_num;
    private String wishing;
    private String client_ip;
    private String act_name;
    private String remark;
    private String scene_id;
    private String risk_info;
    private String consume_mch_id;
}
