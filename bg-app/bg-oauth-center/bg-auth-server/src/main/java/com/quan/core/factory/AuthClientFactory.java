package com.quan.core.factory;

import com.quan.core.constant.AuthConstant;
import com.quan.core.controller.request.client.QueryClientPageRequest;
import com.quan.core.controller.request.client.QueryClientRequest;
import com.quan.core.dto.client.QueryClientDTO;
import com.quan.core.dto.client.QueryClientPageDTO;
import com.quan.core.dto.token.ClientTokenDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统菜单表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 17:50:17
 */
public final class AuthClientFactory {

    public static ClientTokenDTO newInstance(HttpServletRequest request) {
        ClientTokenDTO clientToken = new ClientTokenDTO();
        clientToken.setClientId(request.getHeader(AuthConstant.CLIENT_ID));
        clientToken.setClientSecret(request.getHeader(AuthConstant.CLIENT_SECRET));
        return clientToken;
    }


    public static QueryClientPageDTO newInstance(QueryClientPageRequest request) {
        QueryClientPageDTO client = new QueryClientPageDTO();
        client.setPageNumber(request.getPageNumber());
        client.setPageSize(request.getPageSize());
        return client;
    }

    public static QueryClientDTO newInstance(QueryClientRequest request) {
        QueryClientDTO client = new QueryClientDTO();
        return client;
    }
}
