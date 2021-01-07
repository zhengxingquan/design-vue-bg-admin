package com.quan.core.service;

import com.quan.core.dto.MenuGroupDetailsDTO;
import com.quan.core.request.create.MenuGroupDetailsCreateRequest;
import com.quan.core.request.update.MenuGroupDetailsUpdateRequest;
import com.quan.core.request.MenuGroupDetailsPageQueryRequest;
import com.quan.core.request.MenuGroupDetailsQueryRequest;

import java.util.List;

/**
 * 系统菜单分组与菜单对应表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 18:49:57
 */
public interface MenuGroupDetailsService {
    /**
     * 添加
     * @param data
     */
    int save(MenuGroupDetailsCreateRequest data);

    /**
     * 批量添加
     * @param menuGroupDetailss
     */
    int batchSave(List<MenuGroupDetailsCreateRequest> menuGroupDetailss);

    /**
     * 修改
     * @param menuGroupDetails
     */
    int update(MenuGroupDetailsUpdateRequest menuGroupDetails);

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
    int delete(List<Long> id);

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
        MenuGroupDetailsDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param menuGroupDetails 对象数据
     * @return
     */
        MenuGroupDetailsDTO findOneByCnd(MenuGroupDetailsQueryRequest menuGroupDetails);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(MenuGroupDetailsPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<MenuGroupDetailsDTO> list(MenuGroupDetailsQueryRequest params);

}

