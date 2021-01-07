package com.quan.core.dao;

import com.quan.core.dto.MenuGroupDetailsPageQueryDTO;
import com.quan.core.dto.MenuGroupDetailsQueryDTO;
import com.quan.core.dto.create.MenuGroupDetailsCreateDTO;
import com.quan.core.dto.update.MenuGroupDetailsUpdateDTO;
import com.quan.core.model.MenuGroupDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统菜单分组与菜单对应表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 18:49:57
 */
@Mapper
public interface MenuGroupDetailsDao {

    /**
     * 添加
     * @param data
     */
    int save(MenuGroupDetailsCreateDTO data);

    /**
     * 批量添加
     * @param menuGroupDetailss
     */
    int batchSave(List<MenuGroupDetailsCreateDTO> menuGroupDetailss);

    /**
     * 修改
     * @param data
     */
    int update(MenuGroupDetailsUpdateDTO data);

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
    MenuGroupDetails findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<MenuGroupDetails> findAllById(List<Long> ids);


    List<MenuGroupDetails> findMenuIdDetails(Long menuGroupId);

    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
    MenuGroupDetails findOneByCnd(@Param("data") MenuGroupDetailsQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<MenuGroupDetails> findAll(@Param("data") MenuGroupDetailsPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<MenuGroupDetails> list(@Param("data") MenuGroupDetailsQueryDTO params);

}

