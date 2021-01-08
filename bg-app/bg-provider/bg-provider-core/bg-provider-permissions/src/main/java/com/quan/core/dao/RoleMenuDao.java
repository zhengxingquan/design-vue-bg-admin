package com.quan.core.dao;

import com.quan.core.model.RoleMenu;
import com.quan.core.dto.RoleMenuPageQueryDTO;
import com.quan.core.dto.RoleMenuQueryDTO;
import com.quan.core.dto.create.RoleMenuCreateDTO;
import com.quan.core.dto.update.RoleMenuUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */
@Mapper
public interface RoleMenuDao {

    /**
     * 添加
     * @param data
     */
    int save(RoleMenuCreateDTO data);

    /**
     * 批量添加
     * @param roleMenus
     */
    int batchSave(List<RoleMenuCreateDTO> roleMenus);

    /**
     * 修改
     * @param data
     */
    int update(RoleMenuUpdateDTO data);

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
        RoleMenu findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<RoleMenu> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
        RoleMenu findOneByCnd(@Param("data") RoleMenuQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<RoleMenu> findAll(@Param("data") RoleMenuPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleMenu> list(@Param("data") RoleMenuQueryDTO params);


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
