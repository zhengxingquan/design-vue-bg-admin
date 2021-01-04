package com.quan.core.api;

import com.quan.core.model.WxInMsg;
import com.quan.core.model.WxOutMsg;

import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxBaseApi {

    WxResp send(WxOutMsg out);

    WxInMsg parse(HttpServletRequest req);

    void handle(HttpServletRequest req, HttpServletResponse resp, WxHandler handler);

    List<String> getcallbackip();

    void setPayBase(String url);

    void setWxBase(String url);

    void setMpBase(String url);
}
