package com.quan.core.dao;

import com.quan.core.model.UserGroupRoleGroup;
import com.quan.core.dto.UserGroupRoleGroupPageQueryDTO;
import com.quan.core.dto.UserGroupRoleGroupQueryDTO;
import com.quan.core.dto.create.UserGroupRoleGroupCreateDTO;
import com.quan.core.dto.update.UserGroupRoleGroupUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户组与角色组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */
@Mapper
public interface UserGroupRoleGroupDao {

    /**
     * 添加
     * @param data
     */
    int save(UserGroupRoleGroupCreateDTO data);

    /**
     * 批量添加
     * @param userGroupRoleGroups
     */
    int batchSave(List<UserGroupRoleGroupCreateDTO> userGroupRoleGroups);

    /**
     * 修改
     * @param data
     */
    int update(UserGroupRoleGroupUpdateDTO data);

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
        UserGroupRoleGroup findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<UserGroupRoleGroup> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
        UserGroupRoleGroup findOneByCnd(@Param("data") UserGroupRoleGroupQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<UserGroupRoleGroup> findAll(@Param("data") UserGroupRoleGroupPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UserGroupRoleGroup> list(@Param("data") UserGroupRoleGroupQueryDTO params);


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
