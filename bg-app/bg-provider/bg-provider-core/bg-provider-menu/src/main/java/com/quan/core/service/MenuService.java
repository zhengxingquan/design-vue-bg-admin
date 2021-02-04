package com.quan.core.service;

import com.quan.core.dto.MenuDTO;
import com.quan.core.controller.request.create.MenuCreateRequest;
import com.quan.core.controller.request.update.MenuUpdateRequest;

import java.util.List;

/**
 * 系统菜单表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 17:50:17
 */
public interface MenuService {
    /**
     * 添加
     * @param data
     */
    int save(MenuCreateRequest data);

    /**
     * 批量添加
     * @param menus
     */
    int batchSave(List<MenuCreateRequest> menus);

    /**
     * 修改
     * @param menu
     */
    int update(MenuUpdateRequest menu);

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
        MenuDTO findOneById(Long id);


//    /**
//     * 通过条件查找记录
//     * @param menu 对象数据
//     * @return
//     */
//        MenuDTO findOneByCnd(MenuQueryRequest menu);
//
//
//    /**
//     * 查询列表分页
//     * @param params 对象查询
//     * @return
//     */
//    Object findAll(MenuPageQueryRequest params);
//
//
//    /**
//     * 查询列表不分页
//     * @param params 对象查询
//     * @return
//     */
//    List<MenuDTO> list(MenuQueryRequest params);

}

