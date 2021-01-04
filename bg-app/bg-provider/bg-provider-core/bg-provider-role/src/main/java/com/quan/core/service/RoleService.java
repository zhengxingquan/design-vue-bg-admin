package com.quan.core.service;

import com.quan.core.dto.RoleDTO;
import com.quan.core.request.RolePageQueryRequest;
import com.quan.core.request.RoleQueryRequest;
import com.quan.core.request.create.RoleCreateRequest;
import com.quan.core.request.update.RoleUpdateRequest;

import java.util.List;

/**
 * 系统角色表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */
public interface RoleService {
    /**
     * 添加
     *
     * @param data
     */
    int save(RoleCreateRequest data);

    /**
     * 批量添加
     *
     * @param roles
     */
    int batchSave(List<RoleCreateRequest> roles);

    /**
     * 修改
     *
     * @param role
     */
    int update(RoleUpdateRequest role);

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
    RoleDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     *
     * @param role 对象数据
     * @return
     */
    RoleDTO findOneByCnd(RoleQueryRequest role);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    Object findAll(RolePageQueryRequest params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<RoleDTO> list(RoleQueryRequest params);

}

