package com.quan.core.factory;

import com.quan.core.constant.AuthConstant;
import com.quan.core.controller.request.token.*;
import com.quan.core.dto.token.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统菜单表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 17:50:17
 */
public final class AuthTokenFactory {

    public static ClientTokenDTO newInstance(HttpServletRequest request) {
        ClientTokenDTO clientToken = new ClientTokenDTO();
        clientToken.setClientId(request.getHeader(AuthConstant.CLIENT_ID));
        clientToken.setClientSecret(request.getHeader(AuthConstant.CLIENT_SECRET));
        return clientToken;
    }


    public static UserPasswordTokenDTO newInstance(HttpServletRequest request, UserTokenRequest data) {
        UserPasswordTokenDTO clientToken = (UserPasswordTokenDTO) newInstance(request);
        clientToken.setUserName(data.getUserName());
        clientToken.setPassword(data.getPassword());
        return clientToken;
    }

    public static ValidCodeTokenDTO newInstance(HttpServletRequest request, ValidCodeTokenRequest data) {
        ValidCodeTokenDTO clientToken = (ValidCodeTokenDTO) newInstance(request);
        clientToken.setDeviceId(data.getDeviceId());
        clientToken.setValidCode(data.getValidCode());
        return clientToken;
    }

    public static RefreshUserTokenDTO newInstance(RefreshTokenRequest request) {
        RefreshUserTokenDTO clientToken = new RefreshUserTokenDTO();
        clientToken.setAccessToken(request.getAccessToken());
        return clientToken;
    }

    public static RemoveUserTokenDTO newInstance(RemoveTokenRequest request) {
        RemoveUserTokenDTO clientToken = new RemoveUserTokenDTO();
        clientToken.setAccessToken(request.getAccessToken());
        return clientToken;
    }

    public static QueryUserTokenDTO newInstance(QueryUserTokenRequest request) {
        QueryUserTokenDTO clientToken = new QueryUserTokenDTO();
        clientToken.setAccessToken(request.getAccessToken());
        return clientToken;
    }

    public static QueryUserTokenPageDTO newInstance(QueryUserTokenPageRequest request) {
        QueryUserTokenPageDTO clientToken = new QueryUserTokenPageDTO();
        clientToken.setPageNumber(request.getPageNumber());
        clientToken.setPageSize(request.getPageSize());
        return clientToken;
    }
}
