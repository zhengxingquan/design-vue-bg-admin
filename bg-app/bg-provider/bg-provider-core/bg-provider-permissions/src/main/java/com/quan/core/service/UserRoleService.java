package com.quan.core.service;

import com.quan.core.dto.UserRoleDTO;
import com.quan.core.controller.request.create.UserRoleCreateRequest;
import com.quan.core.controller.request.update.UserRoleUpdateRequest;
import com.quan.core.controller.request.UserRolePageQueryRequest;
import com.quan.core.controller.request.UserRoleQueryRequest;
import com.quan.core.controller.request.UserRoleEnableRequest;
import com.quan.core.controller.request.UserRoleDisableRequest;
import com.quan.core.controller.request.UserRoleBatchEnableAndDisableRequest;

import java.util.List;

/**
 * 用户与角色
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */
public interface UserRoleService {
    /**
     * 添加
     * @param data
     */
    int save(UserRoleCreateRequest data);

    /**
     * 批量添加
     * @param userRoles
     */
    int batchSave(List<UserRoleCreateRequest> userRoles);

    /**
     * 修改
     * @param userRole
     */
    int update(UserRoleUpdateRequest userRole);

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
    UserRoleDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param userRole 对象数据
     * @return
     */
    UserRoleDTO findOneByCnd(UserRoleQueryRequest userRole);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(UserRolePageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UserRoleDTO> list(UserRoleQueryRequest params);


    /**
    * 启用
    */
    int enable(UserRoleEnableRequest req);


    /**
    * 禁用
    */
    int disable(UserRoleDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(UserRoleBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(UserRoleBatchEnableAndDisableRequest params);


}

