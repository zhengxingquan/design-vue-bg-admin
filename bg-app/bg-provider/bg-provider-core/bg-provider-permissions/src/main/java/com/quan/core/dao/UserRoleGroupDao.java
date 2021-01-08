package com.quan.core.dao;

import com.quan.core.dto.UserRoleGroupPageQueryDTO;
import com.quan.core.dto.UserRoleGroupQueryDTO;
import com.quan.core.dto.create.UserRoleGroupCreateDTO;
import com.quan.core.dto.update.UserRoleGroupUpdateDTO;
import com.quan.core.model.UserRoleGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户与角色组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */
@Mapper
public interface UserRoleGroupDao {

    /**
     * 添加
     * @param data
     */
    int save(UserRoleGroupCreateDTO data);

    /**
     * 批量添加
     * @param userRoleGroups
     */
    int batchSave(List<UserRoleGroupCreateDTO> userRoleGroups);

    /**
     * 修改
     * @param data
     */
    int update(UserRoleGroupUpdateDTO data);

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
        UserRoleGroup findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<UserRoleGroup> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
        UserRoleGroup findOneByCnd(@Param("data") UserRoleGroupQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<UserRoleGroup> findAll(@Param("data") UserRoleGroupPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UserRoleGroup> list(@Param("data") UserRoleGroupQueryDTO params);


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
