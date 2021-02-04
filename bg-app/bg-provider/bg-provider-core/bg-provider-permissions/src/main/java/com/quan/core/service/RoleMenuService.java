package com.quan.core.service;

import com.quan.core.dto.RoleMenuDTO;
import com.quan.core.controller.request.create.RoleMenuCreateRequest;
import com.quan.core.controller.request.update.RoleMenuUpdateRequest;
import com.quan.core.controller.request.RoleMenuPageQueryRequest;
import com.quan.core.controller.request.RoleMenuQueryRequest;
import com.quan.core.controller.request.RoleMenuEnableRequest;
import com.quan.core.controller.request.RoleMenuDisableRequest;
import com.quan.core.controller.request.RoleMenuBatchEnableAndDisableRequest;

import java.util.List;

/**
 * 
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */
public interface RoleMenuService {
    /**
     * 添加
     * @param data
     */
    int save(RoleMenuCreateRequest data);

    /**
     * 批量添加
     * @param roleMenus
     */
    int batchSave(List<RoleMenuCreateRequest> roleMenus);

    /**
     * 修改
     * @param roleMenu
     */
    int update(RoleMenuUpdateRequest roleMenu);

    /**
     * 单条删除
     * @param id
     */
    int delete(Long id);

    /**
    * 批量删除
    *
    * @param id
    */
    int delete(List<Long> id);

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
    RoleMenuDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param roleMenu 对象数据
     * @return
     */
    RoleMenuDTO findOneByCnd(RoleMenuQueryRequest roleMenu);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(RoleMenuPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleMenuDTO> list(RoleMenuQueryRequest params);


    /**
    * 启用
    */
    int enable(RoleMenuEnableRequest req);


    /**
    * 禁用
    */
    int disable(RoleMenuDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(RoleMenuBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(RoleMenuBatchEnableAndDisableRequest params);


}

