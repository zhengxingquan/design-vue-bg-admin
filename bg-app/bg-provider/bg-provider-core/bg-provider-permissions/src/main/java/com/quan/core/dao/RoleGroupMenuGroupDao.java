package com.quan.core.dao;

import com.quan.core.dto.RoleGroupMenuGroupPageQueryDTO;
import com.quan.core.dto.RoleGroupMenuGroupQueryDTO;
import com.quan.core.model.RoleGroupMenuGroup;
import com.quan.core.dto.create.RoleGroupMenuGroupCreateDTO;
import com.quan.core.dto.update.RoleGroupMenuGroupUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色组与菜单组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:58:57
 */
@Mapper
public interface RoleGroupMenuGroupDao {

    /**
     * 添加
     * @param data
     */
    int save(RoleGroupMenuGroupCreateDTO data);

    /**
     * 批量添加
     * @param roleGroupMenuGroups
     */
    int batchSave(List<RoleGroupMenuGroupCreateDTO> roleGroupMenuGroups);

    /**
     * 修改
     * @param data
     */
    int update(RoleGroupMenuGroupUpdateDTO data);

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
        RoleGroupMenuGroup findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<RoleGroupMenuGroup> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
        RoleGroupMenuGroup findOneByCnd(@Param("data") RoleGroupMenuGroupQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupMenuGroup> findAll(@Param("data") RoleGroupMenuGroupPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupMenuGroup> list(@Param("data") RoleGroupMenuGroupQueryDTO params);


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
