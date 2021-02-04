package com.quan.core.service;

import com.quan.core.dto.UserGroupRoleGroupDTO;
import com.quan.core.controller.request.create.UserGroupRoleGroupCreateRequest;
import com.quan.core.controller.request.update.UserGroupRoleGroupUpdateRequest;
import com.quan.core.controller.request.UserGroupRoleGroupPageQueryRequest;
import com.quan.core.controller.request.UserGroupRoleGroupQueryRequest;
import com.quan.core.controller.request.UserGroupRoleGroupEnableRequest;
import com.quan.core.controller.request.UserGroupRoleGroupDisableRequest;
import com.quan.core.controller.request.UserGroupRoleGroupBatchEnableAndDisableRequest;

import java.util.List;

/**
 * 用户组与角色组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */
public interface UserGroupRoleGroupService {
    /**
     * 添加
     * @param data
     */
    int save(UserGroupRoleGroupCreateRequest data);

    /**
     * 批量添加
     * @param userGroupRoleGroups
     */
    int batchSave(List<UserGroupRoleGroupCreateRequest> userGroupRoleGroups);

    /**
     * 修改
     * @param userGroupRoleGroup
     */
    int update(UserGroupRoleGroupUpdateRequest userGroupRoleGroup);

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
    UserGroupRoleGroupDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param userGroupRoleGroup 对象数据
     * @return
     */
    UserGroupRoleGroupDTO findOneByCnd(UserGroupRoleGroupQueryRequest userGroupRoleGroup);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(UserGroupRoleGroupPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UserGroupRoleGroupDTO> list(UserGroupRoleGroupQueryRequest params);


    /**
    * 启用
    */
    int enable(UserGroupRoleGroupEnableRequest req);


    /**
    * 禁用
    */
    int disable(UserGroupRoleGroupDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(UserGroupRoleGroupBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(UserGroupRoleGroupBatchEnableAndDisableRequest params);


}

