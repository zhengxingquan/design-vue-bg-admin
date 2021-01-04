package com.quan.core.api;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxQrApi {

    WxResp qrcode_create(Object scene_id, int expire_seconds);

    String qrcode_show(String ticket);

    String shorturl(String url);
}
