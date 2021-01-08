package com.quan.core.dao;

import com.quan.core.dto.RoleGroupMenuPageQueryDTO;
import com.quan.core.model.RoleGroupMenu;
import com.quan.core.dto.RoleGroupMenuQueryDTO;
import com.quan.core.dto.create.RoleGroupMenuCreateDTO;
import com.quan.core.dto.update.RoleGroupMenuUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色组与菜单
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:43:42
 */
@Mapper
public interface RoleGroupMenuDao {

    /**
     * 添加
     * @param data
     */
    int save(RoleGroupMenuCreateDTO data);

    /**
     * 批量添加
     * @param roleGroupMenus
     */
    int batchSave(List<RoleGroupMenuCreateDTO> roleGroupMenus);

    /**
     * 修改
     * @param data
     */
    int update(RoleGroupMenuUpdateDTO data);

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
        RoleGroupMenu findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<RoleGroupMenu> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
        RoleGroupMenu findOneByCnd(@Param("data") RoleGroupMenuQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupMenu> findAll(@Param("data") RoleGroupMenuPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupMenu> list(@Param("data") RoleGroupMenuQueryDTO params);


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
