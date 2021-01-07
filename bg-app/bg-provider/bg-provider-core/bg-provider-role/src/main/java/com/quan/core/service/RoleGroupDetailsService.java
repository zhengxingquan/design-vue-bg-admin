package com.quan.core.service;

import com.quan.core.dto.RoleGroupDetailsDTO;
import com.quan.core.request.RoleGroupDetailsPageQueryRequest;
import com.quan.core.request.RoleGroupDetailsQueryRequest;
import com.quan.core.request.create.RoleGroupDetailsCreateRequest;
import com.quan.core.request.update.RoleGroupDetailsUpdateRequest;

import java.util.List;

/**
 * 系统角色分组与角色对应表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:21:41
 */
public interface RoleGroupDetailsService {
    /**
     * 添加
     * @param data
     */
    int save(RoleGroupDetailsCreateRequest data);

    /**
     * 批量添加
     * @param roleGroupDetailss
     */
    int batchSave(List<RoleGroupDetailsCreateRequest> roleGroupDetailss);

    /**
     * 修改
     * @param roleGroupDetails
     */
    int update(RoleGroupDetailsUpdateRequest roleGroupDetails);

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
        RoleGroupDetailsDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param roleGroupDetails 对象数据
     * @return
     */
        RoleGroupDetailsDTO findOneByCnd(RoleGroupDetailsQueryRequest roleGroupDetails);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(RoleGroupDetailsPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupDetailsDTO> list(RoleGroupDetailsQueryRequest params);

}

