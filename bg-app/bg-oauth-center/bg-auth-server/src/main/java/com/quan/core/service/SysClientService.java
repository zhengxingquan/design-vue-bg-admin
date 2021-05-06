package com.quan.core.service;


import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.Result;
import com.quan.core.controller.request.client.QueryClientPageRequest;
import com.quan.core.controller.request.client.QueryClientRequest;
import com.quan.core.controller.request.token.create.ClientCreateRequest;
import com.quan.core.controller.request.token.update.ClientUpdateRequest;
import com.quan.core.dto.client.QueryClientDTO;
import com.quan.core.dto.client.QueryPageDTO;

import java.util.List;

@SuppressWarnings("all")
public interface SysClientService {


    Result save(ClientCreateRequest request);

    Result update(ClientUpdateRequest request);

    void delete(Long id);

    void deletes(List<Long> ids);

    QueryClientDTO getById(Long id);


    public PageResult<QueryPageDTO> list(QueryClientPageRequest client);

    /***
     * 查找数据
     */  
    List<QueryClientDTO> data(QueryClientRequest client);

    /**
     * 启用
     */
    Result enable(Long id);


    /**
     * 禁用
     */
    Result disable(Long id);


    /***
     *   批量启用
     */
    Result batchEnable(List<Long> id);


    /***
     *   批量禁用
     */
    Result batchDisable(List<Long> id);

}
