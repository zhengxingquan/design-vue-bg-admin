package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：客服 实体类
 */
@Data
public class WxKfAccount extends BaseModel {

    String account;

    String headimgurl;

    String id;

    String nick;


    int status;

    int auto_accept;

    int accepted_case;

}
