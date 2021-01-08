package com.quan.core.service;

import com.quan.core.dto.RoleGroupMenuDTO;
import com.quan.core.request.create.RoleGroupMenuCreateRequest;
import com.quan.core.request.update.RoleGroupMenuUpdateRequest;
import com.quan.core.request.RoleGroupMenuPageQueryRequest;
import com.quan.core.request.RoleGroupMenuQueryRequest;
import com.quan.core.request.RoleGroupMenuEnableRequest;
import com.quan.core.request.RoleGroupMenuDisableRequest;
import com.quan.core.request.RoleGroupMenuBatchEnableAndDisableRequest;

import java.util.List;

/**
 * 角色组与菜单
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:43:42
 */
public interface RoleGroupMenuService {
    /**
     * 添加
     * @param data
     */
    int save(RoleGroupMenuCreateRequest data);

    /**
     * 批量添加
     * @param roleGroupMenus
     */
    int batchSave(List<RoleGroupMenuCreateRequest> roleGroupMenus);

    /**
     * 修改
     * @param roleGroupMenu
     */
    int update(RoleGroupMenuUpdateRequest roleGroupMenu);

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
    RoleGroupMenuDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param roleGroupMenu 对象数据
     * @return
     */
    RoleGroupMenuDTO findOneByCnd(RoleGroupMenuQueryRequest roleGroupMenu);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(RoleGroupMenuPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupMenuDTO> list(RoleGroupMenuQueryRequest params);


    /**
    * 启用
    */
    int enable(RoleGroupMenuEnableRequest req);


    /**
    * 禁用
    */
    int disable(RoleGroupMenuDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(RoleGroupMenuBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(RoleGroupMenuBatchEnableAndDisableRequest params);


}

