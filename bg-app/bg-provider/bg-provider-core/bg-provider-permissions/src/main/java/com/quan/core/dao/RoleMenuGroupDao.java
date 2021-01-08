package com.quan.core.dao;

import com.quan.core.model.RoleMenuGroup;
import com.quan.core.dto.RoleMenuGroupPageQueryDTO;
import com.quan.core.dto.RoleMenuGroupQueryDTO;
import com.quan.core.dto.create.RoleMenuGroupCreateDTO;
import com.quan.core.dto.update.RoleMenuGroupUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色与菜单组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */
@Mapper
public interface RoleMenuGroupDao {

    /**
     * 添加
     *
     * @param data
     */
    int save(RoleMenuGroupCreateDTO data);

    /**
     * 批量添加
     *
     * @param roleMenuGroups
     */
    int batchSave(List<RoleMenuGroupCreateDTO> roleMenuGroups);

    /**
     * 修改
     *
     * @param data
     */
    int update(RoleMenuGroupUpdateDTO data);

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
    int batchDelete(List<Long> id);

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    RoleMenuGroup findOneById(Long id);

    /**
     * 通过ID查找所有的记录记录
     *
     * @param ids 用户记录ID
     * @return
     */
    List<RoleMenuGroup> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     *
     * @param params 对象数据
     * @return
     */
    RoleMenuGroup findOneByCnd(@Param("data") RoleMenuGroupQueryDTO params);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    List<RoleMenuGroup> findAll(@Param("data") RoleMenuGroupPageQueryDTO params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<RoleMenuGroup> list(@Param("data") RoleMenuGroupQueryDTO params);


    /***
     *  启用
     * @param ids 主键id集合

     * @return int
     */
    int enable(List<Long> ids);


    /**
     * 禁用
     *
     * @param ids 主键id集合
     * @return int
     */
    int disable(List<Long> ids);

}
