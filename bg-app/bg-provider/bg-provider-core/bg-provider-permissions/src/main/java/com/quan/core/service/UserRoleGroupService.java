package com.quan.core.service;

import com.quan.core.dto.UserRoleGroupDTO;
import com.quan.core.controller.request.create.UserRoleGroupCreateRequest;
import com.quan.core.controller.request.update.UserRoleGroupUpdateRequest;
import com.quan.core.controller.request.UserRoleGroupPageQueryRequest;
import com.quan.core.controller.request.UserRoleGroupQueryRequest;
import com.quan.core.controller.request.UserRoleGroupEnableRequest;
import com.quan.core.controller.request.UserRoleGroupDisableRequest;
import com.quan.core.controller.request.UserRoleGroupBatchEnableAndDisableRequest;

import java.util.List;

/**
 * 用户与角色组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */
public interface UserRoleGroupService {
    /**
     * 添加
     * @param data
     */
    int save(UserRoleGroupCreateRequest data);

    /**
     * 批量添加
     * @param userRoleGroups
     */
    int batchSave(List<UserRoleGroupCreateRequest> userRoleGroups);

    /**
     * 修改
     * @param userRoleGroup
     */
    int update(UserRoleGroupUpdateRequest userRoleGroup);

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
    UserRoleGroupDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param userRoleGroup 对象数据
     * @return
     */
    UserRoleGroupDTO findOneByCnd(UserRoleGroupQueryRequest userRoleGroup);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(UserRoleGroupPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UserRoleGroupDTO> list(UserRoleGroupQueryRequest params);


    /**
    * 启用
    */
    int enable(UserRoleGroupEnableRequest req);


    /**
    * 禁用
    */
    int disable(UserRoleGroupDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(UserRoleGroupBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(UserRoleGroupBatchEnableAndDisableRequest params);


}

