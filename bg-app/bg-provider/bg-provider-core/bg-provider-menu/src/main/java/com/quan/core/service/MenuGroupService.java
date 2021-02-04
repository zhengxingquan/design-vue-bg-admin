package com.quan.core.service;

import com.quan.core.dto.MenuGroupDTO;
import com.quan.core.controller.request.create.MenuGroupCreateRequest;
import com.quan.core.controller.request.update.MenuGroupUpdateRequest;
import com.quan.core.controller.request.MenuGroupPageQueryRequest;
import com.quan.core.controller.request.MenuGroupQueryRequest;

import java.util.List;

/**
 * 系统菜单表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 18:42:13
 */
public interface MenuGroupService {
    /**
     * 添加
     * @param data
     */
    int save(MenuGroupCreateRequest data);

    /**
     * 批量添加
     * @param menuGroups
     */
    int batchSave(List<MenuGroupCreateRequest> menuGroups);

    /**
     * 修改
     * @param menuGroup
     */
    int update(MenuGroupUpdateRequest menuGroup);

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
        MenuGroupDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param menuGroup 对象数据
     * @return
     */
        MenuGroupDTO findOneByCnd(MenuGroupQueryRequest menuGroup);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(MenuGroupPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<MenuGroupDTO> list(MenuGroupQueryRequest params);

}

