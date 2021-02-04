package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.dao.MenuDao;
import com.quan.core.dao.MenuGroupDetailsDao;
import com.quan.core.dto.MenuGroupDetailsDTO;
import com.quan.core.factory.MenuGroupDetailsFactory;
import com.quan.core.model.MenuGroupDetails;
import com.quan.core.controller.request.MenuGroupDetailsPageQueryRequest;
import com.quan.core.controller.request.MenuGroupDetailsQueryRequest;
import com.quan.core.controller.request.create.MenuGroupDetailsCreateRequest;
import com.quan.core.controller.request.update.MenuGroupDetailsUpdateRequest;
import com.quan.core.service.MenuGroupDetailsService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class MenuGroupDetailsServiceImpl implements MenuGroupDetailsService {

    @Autowired
    private MenuGroupDetailsDao menuGroupDetailsDao;

    @Autowired
    private MenuDao menuDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(MenuGroupDetailsCreateRequest data) {
        if (data.getMenuId() != null) {
            List<Long> menus = menuDao.findChildrenAttrIdAllById(data.getMenuId());
            if (CollectionUtils.isNotEmpty(menus)) {
                List<MenuGroupDetails> menuGroupDetails =
                        menuGroupDetailsDao.findMenuIdDetails(data.getMenuGroupId());

//                if (CollectionUtils.isNotEmpty(menus)) {
//                    menus
//                }
                menuGroupDetailsDao.batchSave(MenuGroupDetailsFactory.newInstance(menus, data.getMenuGroupId()));
            }
        }
        return 0;
    }

    /**
     * 批量添加
     *
     * @param menuGroupDetailss
     */
    @Transactional
    @Override
    public int batchSave(List<MenuGroupDetailsCreateRequest> menuGroupDetailss) {
        return menuGroupDetailsDao.batchSave(MenuGroupDetailsFactory.newBatchInstance(menuGroupDetailss));
    }

    /**
     * 修改
     *
     * @param menuGroupDetails
     */
    @Transactional
    @Override
    public int update(MenuGroupDetailsUpdateRequest menuGroupDetails) {
        return menuGroupDetailsDao.update(MenuGroupDetailsFactory.newInstance(menuGroupDetails));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return menuGroupDetailsDao.delete(id);
    }

    /**
     * 批量删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(List<Long> id) {
        if (CollectionUtils.isEmpty(id)) {
            return 0;
        }
        return menuGroupDetailsDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public MenuGroupDetailsDTO findOneById(Long id) {
        MenuGroupDetails data = menuGroupDetailsDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return MenuGroupDetailsFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param menuGroupDetails 对象数据
     * @return
     */
    @Override
    public MenuGroupDetailsDTO findOneByCnd(MenuGroupDetailsQueryRequest menuGroupDetails) {
        MenuGroupDetails data = menuGroupDetailsDao.findOneByCnd(MenuGroupDetailsFactory.newInstance(menuGroupDetails));
        if (data == null) {
            return null;
        }
        return MenuGroupDetailsFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(MenuGroupDetailsPageQueryRequest params) {
        return menuGroupDetailsDao.findAll(MenuGroupDetailsFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<MenuGroupDetailsDTO> list(MenuGroupDetailsQueryRequest params) {
        List<MenuGroupDetails> list = menuGroupDetailsDao.list(MenuGroupDetailsFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return MenuGroupDetailsFactory.newInstance(list);
    }

}
