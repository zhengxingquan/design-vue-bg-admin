package com.quan.core.dao;

import com.quan.core.dto.UserRolePageQueryDTO;
import com.quan.core.dto.UserRoleQueryDTO;
import com.quan.core.dto.create.UserRoleCreateDTO;
import com.quan.core.dto.update.UserRoleUpdateDTO;
import com.quan.core.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户与角色
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */
@Mapper
public interface UserRoleDao {

    /**
     * 添加
     * @param data
     */
    int save(UserRoleCreateDTO data);

    /**
     * 批量添加
     * @param userRoles
     */
    int batchSave(List<UserRoleCreateDTO> userRoles);

    /**
     * 修改
     * @param data
     */
    int update(UserRoleUpdateDTO data);

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
        UserRole findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<UserRole> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
        UserRole findOneByCnd(@Param("data") UserRoleQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<UserRole> findAll(@Param("data") UserRolePageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UserRole> list(@Param("data") UserRoleQueryDTO params);


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
