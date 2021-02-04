package com.quan.core.service;

import com.quan.core.dto.RoleMenuGroupDTO;
import com.quan.core.controller.request.create.RoleMenuGroupCreateRequest;
import com.quan.core.controller.request.update.RoleMenuGroupUpdateRequest;
import com.quan.core.controller.request.RoleMenuGroupPageQueryRequest;
import com.quan.core.controller.request.RoleMenuGroupQueryRequest;
import com.quan.core.controller.request.RoleMenuGroupEnableRequest;
import com.quan.core.controller.request.RoleMenuGroupDisableRequest;
import com.quan.core.controller.request.RoleMenuGroupBatchEnableAndDisableRequest;

import java.util.List;

/**
 * 角色与菜单组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */
public interface RoleMenuGroupService {
    /**
     * 添加
     * @param data
     */
    int save(RoleMenuGroupCreateRequest data);

    /**
     * 批量添加
     * @param roleMenuGroups
     */
    int batchSave(List<RoleMenuGroupCreateRequest> roleMenuGroups);

    /**
     * 修改
     * @param roleMenuGroup
     */
    int update(RoleMenuGroupUpdateRequest roleMenuGroup);

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
    RoleMenuGroupDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param roleMenuGroup 对象数据
     * @return
     */
    RoleMenuGroupDTO findOneByCnd(RoleMenuGroupQueryRequest roleMenuGroup);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(RoleMenuGroupPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleMenuGroupDTO> list(RoleMenuGroupQueryRequest params);


    /**
    * 启用
    */
    int enable(RoleMenuGroupEnableRequest req);


    /**
    * 禁用
    */
    int disable(RoleMenuGroupDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(RoleMenuGroupBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(RoleMenuGroupBatchEnableAndDisableRequest params);


}

