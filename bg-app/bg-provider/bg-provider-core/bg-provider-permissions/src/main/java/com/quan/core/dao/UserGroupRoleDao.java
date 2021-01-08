package com.quan.core.dao;

import com.quan.core.model.UserGroupRole;
import com.quan.core.dto.UserGroupRolePageQueryDTO;
import com.quan.core.dto.UserGroupRoleQueryDTO;
import com.quan.core.dto.create.UserGroupRoleCreateDTO;
import com.quan.core.dto.update.UserGroupRoleUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户组与角色
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */
@Mapper
public interface UserGroupRoleDao {

    /**
     * 添加
     * @param data
     */
    int save(UserGroupRoleCreateDTO data);

    /**
     * 批量添加
     * @param userGroupRoles
     */
    int batchSave(List<UserGroupRoleCreateDTO> userGroupRoles);

    /**
     * 修改
     * @param data
     */
    int update(UserGroupRoleUpdateDTO data);

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
    int batchDelete(List<Long> id);

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
        UserGroupRole findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<UserGroupRole> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
        UserGroupRole findOneByCnd(@Param("data") UserGroupRoleQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<UserGroupRole> findAll(@Param("data") UserGroupRolePageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UserGroupRole> list(@Param("data") UserGroupRoleQueryDTO params);


    /***
     *  启用
     * @param ids 主键id集合
    
     * @return int  
     */
    int enable(List<Long> ids);


    /**
    * 禁用
    * @param ids 主键id集合
    *
    * @return int
    */
    int disable(List<Long> ids);

}
