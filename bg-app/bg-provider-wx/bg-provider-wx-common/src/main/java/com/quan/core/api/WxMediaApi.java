package com.quan.core.api;

import com.quan.core.NutResource;

import java.io.File;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxMediaApi {

    WxResp media_upload(String type, File f);

    NutResource media_get(String mediaId);

    NutResource media_get_jssdk(String mediaId);
}
