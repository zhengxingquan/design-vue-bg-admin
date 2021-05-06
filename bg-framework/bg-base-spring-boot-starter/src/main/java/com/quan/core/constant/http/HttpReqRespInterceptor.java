package com.quan.core.constant.http;

import java.net.HttpURLConnection;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface HttpReqRespInterceptor {

    void beforeConnect(Request request);

    void afterConnect(Request request, HttpURLConnection conn);

    void afterResponse(Request request, HttpURLConnection conn, Response response);
}
