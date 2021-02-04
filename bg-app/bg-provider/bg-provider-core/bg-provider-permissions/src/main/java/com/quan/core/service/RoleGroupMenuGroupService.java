package com.quan.core.service;

import com.quan.core.dto.RoleGroupMenuGroupDTO;
import com.quan.core.controller.request.RoleGroupMenuGroupBatchEnableAndDisableRequest;
import com.quan.core.controller.request.RoleGroupMenuGroupDisableRequest;
import com.quan.core.controller.request.RoleGroupMenuGroupPageQueryRequest;
import com.quan.core.controller.request.create.RoleGroupMenuGroupCreateRequest;
import com.quan.core.controller.request.update.RoleGroupMenuGroupUpdateRequest;
import com.quan.core.controller.request.RoleGroupMenuGroupQueryRequest;
import com.quan.core.controller.request.RoleGroupMenuGroupEnableRequest;

import java.util.List;

/**
 * 角色组与菜单组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:58:57
 */
public interface RoleGroupMenuGroupService {
    /**
     * 添加
     * @param data
     */
    int save(RoleGroupMenuGroupCreateRequest data);

    /**
     * 批量添加
     * @param roleGroupMenuGroups
     */
    int batchSave(List<RoleGroupMenuGroupCreateRequest> roleGroupMenuGroups);

    /**
     * 修改
     * @param roleGroupMenuGroup
     */
    int update(RoleGroupMenuGroupUpdateRequest roleGroupMenuGroup);

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
    RoleGroupMenuGroupDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param roleGroupMenuGroup 对象数据
     * @return
     */
    RoleGroupMenuGroupDTO findOneByCnd(RoleGroupMenuGroupQueryRequest roleGroupMenuGroup);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(RoleGroupMenuGroupPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupMenuGroupDTO> list(RoleGroupMenuGroupQueryRequest params);


    /**
    * 启用
    */
    int enable(RoleGroupMenuGroupEnableRequest req);


    /**
    * 禁用
    */
    int disable(RoleGroupMenuGroupDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(RoleGroupMenuGroupBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(RoleGroupMenuGroupBatchEnableAndDisableRequest params);


}

