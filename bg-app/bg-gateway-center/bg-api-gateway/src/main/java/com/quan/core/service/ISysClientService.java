package com.quan.core.service;

import java.util.List;
import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/4/30
 * 描述：
 */
public interface ISysClientService {

    public Map getClient(String clientId);

    List<Map> listByClientId(Long clientId);
}
