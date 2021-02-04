package com.quan.core.factory;

import com.quan.core.common.model.SysClient;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.constant.AuthConstant;
import com.quan.core.controller.request.client.QueryClientPageRequest;
import com.quan.core.controller.request.client.QueryClientRequest;
import com.quan.core.controller.request.token.ClientBaseRequest;
import com.quan.core.controller.request.token.create.ClientCreateRequest;
import com.quan.core.controller.request.token.update.ClientUpdateRequest;
import com.quan.core.dto.client.*;
import com.quan.core.dto.token.ClientTokenDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    private static AuthClientDTO newInstance(ClientBaseRequest request) {
        AuthClientDTO createDTO = new AuthClientDTO();
        createDTO.setAccessTokenValidity(request.getAccessTokenValidity());
        createDTO.setAuthorities(request.getAuthorities());
        createDTO.setAuthorizedGrantTypes(request.getAuthorizedGrantTypes());
        createDTO.setClientId(request.getClientId());
        createDTO.setClientSecretStr(request.getClientSecretStr());
        createDTO.setWebServerRedirectUri(request.getWebServerRedirectUri());
        createDTO.setScope(request.getScope());
        createDTO.setResourceIds(request.getResourceIds());
        createDTO.setAccessTokenValidity(request.getAccessTokenValidity());
        createDTO.setRefreshTokenValidity(request.getRefreshTokenValidity());
        createDTO.setAutoapprove(request.getAutoapprove());
        createDTO.setIfLimit(request.isIfLimit());
        createDTO.setLimitCount(request.getLimitCount());
        return createDTO;
    }

    private static AuthClientDTO bindInstance(SysClient client) {
        AuthClientDTO createDTO = new AuthClientDTO();
        createDTO.setAccessTokenValidity(client.getAccessTokenValidity());
        createDTO.setAuthorities(client.getAuthorities());
        createDTO.setAuthorizedGrantTypes(client.getAuthorizedGrantTypes());
        createDTO.setClientId(client.getClientId());
        createDTO.setClientSecretStr(client.getClientSecretStr());
        createDTO.setWebServerRedirectUri(client.getWebServerRedirectUri());
        createDTO.setScope(client.getScope());
        createDTO.setResourceIds(client.getResourceIds());
        createDTO.setAccessTokenValidity(client.getAccessTokenValidity());
        createDTO.setRefreshTokenValidity(client.getRefreshTokenValidity());
        createDTO.setAutoapprove(client.getAutoapprove());
        createDTO.setIfLimit(client.getIfLimit() == 1);
        createDTO.setLimitCount(client.getLimitCount());
        return createDTO;
    }

    public static AuthClientCreateDTO newInstance(IUidGenerator uidGenerator, ClientCreateRequest request) {
        AuthClientCreateDTO createDTO = (AuthClientCreateDTO) newInstance(request);
        createDTO.setId(uidGenerator.uid());
        createDTO.setCreateTime(new Date());
        return createDTO;
    }

    public static AuthClientUpdateDTO newInstance(IUidGenerator uidGenerator, ClientUpdateRequest request) {
        AuthClientUpdateDTO createDTO = (AuthClientUpdateDTO) newInstance(request);
        createDTO.setId(uidGenerator.uid());
        createDTO.setUpdateTime(new Date());
        return createDTO;
    }

    public static QueryClientDTO newInstance(SysClient client) {
        return (QueryClientDTO) bindInstance(client);
    }

    /***
     * 查询列表
     */
    public static QueryClientDTO newInstance(QueryClientRequest request) {
        QueryClientDTO client = new QueryClientDTO();
        return client;
    }

    /***
     * 列表数据
     */
    public static List<QueryClientDTO> newInstance(List<SysClient> data) {
        return data.stream().map(t -> {
            return (QueryClientDTO) newInstance(data);
        }).collect(Collectors.toList());
    }
}
