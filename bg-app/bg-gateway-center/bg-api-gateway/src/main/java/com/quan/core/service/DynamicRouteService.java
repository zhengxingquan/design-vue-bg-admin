package com.quan.core.service;


import com.quan.core.constant.web.PageResult;
import com.quan.core.dto.GatewayRouteDefinition;
import com.quan.core.vo.GatewayRoutesVO;

import java.util.Map;

/**
 * 操作 路由 Service
 */
public interface DynamicRouteService {

    /**
     * 新增路由
     *
     * @param gatewayRouteDefinition
     * @return
     */
    Long add(GatewayRouteDefinition gatewayRouteDefinition);

    /**
     * 修改路由
     *
     * @param gatewayRouteDefinition
     * @return
     */
    Long update(GatewayRouteDefinition gatewayRouteDefinition);

    /**
     * 删除路由
     *
     * @param id
     * @return
     */
    String delete(String id);


    /**
     * 查询全部数据
     *
     * @return
     */
    PageResult<GatewayRoutesVO> findAll(Map<String, Object> params);

    /**
     * 同步redis数据 从mysql中同步过去
     *
     * @return
     */
    String synchronization();


    /**
     * 更改路由状态
     *
     * @param params
     * @return
     */
    String updateFlag(Map<String, Object> params);


}
