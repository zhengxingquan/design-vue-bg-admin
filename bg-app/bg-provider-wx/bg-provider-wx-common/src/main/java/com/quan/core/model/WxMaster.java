package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述： 描述一个微信公众号的信息
 */
@Data
public class WxMaster extends BaseModel {
    /**
     * 该公众帐号的openid, 一般以gh_开头,作为数据库主键
     */
    private String openid;
    /**
     * 昵称,显示用
     */
    private String nickname;
    /**
     * 核心参数,必须有,应用的token值
     */
    private String token;
    /**
     * 关键参数,服务号才有
     */
    private String appid;
    /**
     * 关键参数,服务号才有
     */
    private String appsecret;
    /**
     * 访问微信API所必须,但有效期短,变化的值
     */
    private String access_token;
    /**
     * 记录access_token失效的时间
     */
    private long access_token_expires;
}
