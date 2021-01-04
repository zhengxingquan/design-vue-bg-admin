package com.quan.core.api;

import com.quan.core.store.WxJsapiTicketStore;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxJsapiTicketApi {

    void setJsapiTicketStore(WxJsapiTicketStore ats);

    WxJsapiTicketStore getJsapiTicketStore();

    String getJsapiTicket();

    Map<String,Object> genJsSDKConfig(String url, String... jsApiList);
}
