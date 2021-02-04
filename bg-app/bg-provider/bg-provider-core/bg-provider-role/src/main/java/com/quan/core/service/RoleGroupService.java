package com.quan.core.service;

import com.quan.core.controller.request.RoleGroupPageQueryRequest;
import com.quan.core.controller.request.RoleGroupQueryRequest;
import com.quan.core.controller.request.create.RoleGroupCreateRequest;
import com.quan.core.controller.request.update.RoleGroupUpdateRequest;
import com.quan.core.dto.RoleGroupDTO;

import java.util.List;

/**
 * 系统角色分组表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:07:02
 */
public interface RoleGroupService {
    /**
     * 添加
     * @param data
     */
    int save(RoleGroupCreateRequest data);

    /**
     * 批量添加
     * @param roleGroups
     */
    int batchSave(List<RoleGroupCreateRequest> roleGroups);

    /**
     * 修改
     * @param roleGroup
     */
    int update(RoleGroupUpdateRequest roleGroup);

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
        RoleGroupDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param roleGroup 对象数据
     * @return
     */
        RoleGroupDTO findOneByCnd(RoleGroupQueryRequest roleGroup);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(RoleGroupPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupDTO> list(RoleGroupQueryRequest params);

}

