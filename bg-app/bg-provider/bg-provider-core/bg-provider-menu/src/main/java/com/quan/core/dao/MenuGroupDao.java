package com.quan.core.dao;

import com.quan.core.constant.dao.IBaseDao;
import com.quan.core.constant.dao.IHasChildrenDao;
import com.quan.core.constant.dao.IPathDao;
import com.quan.core.constant.dao.ISortDao;
import com.quan.core.model.MenuGroup;
import com.quan.core.dto.MenuGroupPageQueryDTO;
import com.quan.core.dto.MenuGroupQueryDTO;
import com.quan.core.dto.create.MenuGroupCreateDTO;
import com.quan.core.dto.update.MenuGroupUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统菜单表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 18:42:13
 */
@Mapper
public interface MenuGroupDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     * @param data
     */
    int save(MenuGroupCreateDTO data);

    /**
     * 批量添加
     * @param menuGroups
     */
    int batchSave(List<MenuGroupCreateDTO> menuGroups);

    /**
     * 修改
     * @param data
     */
    int update(MenuGroupUpdateDTO data);

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
    MenuGroup findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<MenuGroup> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
    MenuGroup findOneByCnd(@Param("data") MenuGroupQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<MenuGroup> findAll(@Param("data") MenuGroupPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<MenuGroup> list(@Param("data") MenuGroupQueryDTO params);

}
