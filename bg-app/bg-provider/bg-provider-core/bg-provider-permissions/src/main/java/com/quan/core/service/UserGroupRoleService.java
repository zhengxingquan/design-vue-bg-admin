package com.quan.core.service;

import com.quan.core.dto.UserGroupRoleDTO;
import com.quan.core.controller.request.*;
import com.quan.core.controller.request.create.UserGroupRoleCreateRequest;
import com.quan.core.controller.request.update.UserGroupRoleUpdateRequest;

import java.util.List;

/**
 * 用户组与角色
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */
public interface UserGroupRoleService {
    /**
     * 添加
     *
     * @param data
     */
    int save(UserGroupRoleCreateRequest data);

    /**
     * 批量添加
     *
     * @param userGroupRoles
     */
    int batchSave(List<UserGroupRoleCreateRequest> userGroupRoles);

    /**
     * 修改
     *
     * @param userGroupRole
     */
    int update(UserGroupRoleUpdateRequest userGroupRole);

    /**
     * 单条删除
     *
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
     *
     * @param id 用户记录ID
     * @return
     */
    UserGroupRoleDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     *
     * @param userGroupRole 对象数据
     * @return
     */
    UserGroupRoleDTO findOneByCnd(UserGroupRoleQueryRequest userGroupRole);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    Object findAll(UserGroupRolePageQueryRequest params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<UserGroupRoleDTO> list(UserGroupRoleQueryRequest params);


    /**
     * 启用
     */
    int enable(UserGroupRoleEnableRequest req);


    /**
     * 禁用
     */
    int disable(UserGroupRoleDisableRequest req);


    /***
     *   批量启用
     */
    int batchEnable(UserGroupRoleBatchEnableAndDisableRequest params);


    /***
     *   批量禁用
     */
    int batchDisable(UserGroupRoleBatchEnableAndDisableRequest params);


}

