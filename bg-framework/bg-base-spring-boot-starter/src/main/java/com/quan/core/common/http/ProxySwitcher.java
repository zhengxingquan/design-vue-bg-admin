package com.quan.core.common.http;

import java.net.Proxy;
import java.net.URL;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/2
 * 描述：
 */
public interface ProxySwitcher {

    Proxy getProxy(URL url);

    Proxy getProxy(Request req);
}
