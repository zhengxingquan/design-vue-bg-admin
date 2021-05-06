package com.quan.core.dao;

import com.quan.core.constant.dao.IBaseDao;
import com.quan.core.constant.dao.IHasChildrenDao;
import com.quan.core.constant.dao.IPathDao;
import com.quan.core.constant.dao.ISortDao;
import com.quan.core.dto.MenuPageQueryDTO;
import com.quan.core.dto.MenuQueryDTO;
import com.quan.core.dto.create.MenuCreateDTO;
import com.quan.core.dto.update.MenuUpdateDTO;
import com.quan.core.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统菜单表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 17:50:17
 */
@Mapper
public interface MenuDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     *
     * @param data
     */
    int save(MenuCreateDTO data);

    /**
     * 批量添加
     *
     * @param menus
     */
    int batchSave(List<MenuCreateDTO> menus);

    /**
     * 修改
     *
     * @param data
     */
    int update(MenuUpdateDTO data);

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
    Menu findOneById(Long id);

    /**
     * 通过ID查找所有的记录记录
     *
     * @param ids 用户记录ID
     * @return
     */
    List<Menu> findAllById(List<Long> ids);


    /**
     * 通过ID查找当前节点下面的所有的子节点
     *
     * @param path 用户记录ID
     * @return
     */
    List<Menu> findChildrenAllByPath(String path);


    /**
     * 通过ID查找当前节点下面的所有的子节点
     *
     * @param id 用户记录ID
     * @return
     */
    List<Menu> findChildrenAllById(Long id);


    /**
     * 通过ID查找当前节点下面的所有的子节点
     *
     * @param id 用户记录ID
     * @return
     */
    List<Long> findChildrenAttrIdAllById(Long id);




    /**
     * 通过ID查找当前节点下面的所有的子节点
     *
     * @param path 用户记录ID
     * @return
     */
    List<Long> findChildrenAttrIdAllByPath(String path);


    /**
     * 通过条件查找记录
     *
     * @param params 对象数据
     * @return
     */
    Menu findOneByCnd(@Param("data") MenuQueryDTO params);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    List<Menu> findAll(@Param("data") MenuPageQueryDTO params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<Menu> list(@Param("data") MenuQueryDTO params);

}
