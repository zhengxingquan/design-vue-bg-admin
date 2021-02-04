package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.dao.RoleMenuDao;
import com.quan.core.dto.RoleMenuDTO;
import com.quan.core.factory.RoleMenuFactory;
import com.quan.core.model.RoleMenu;
import com.quan.core.controller.request.*;
import com.quan.core.controller.request.create.RoleMenuCreateRequest;
import com.quan.core.controller.request.update.RoleMenuUpdateRequest;
import com.quan.core.service.RoleMenuService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuDao roleMenuDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleMenuCreateRequest data) {
        return roleMenuDao.save(RoleMenuFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param roleMenus
     */
    @Transactional
    @Override
    public int batchSave(List<RoleMenuCreateRequest> roleMenus) {
        return roleMenuDao.batchSave(RoleMenuFactory.newBatchInstance(roleMenus));
    }

    /**
     * 修改
     *
     * @param roleMenu
     */
    @Transactional
    @Override
    public int update(RoleMenuUpdateRequest roleMenu) {
        return roleMenuDao.update(RoleMenuFactory.newInstance(roleMenu));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return roleMenuDao.delete(id);
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
        return roleMenuDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public RoleMenuDTO findOneById(Long id) {
        RoleMenu data = roleMenuDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return RoleMenuFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param roleMenu 对象数据
     * @return
     */
    @Override
    public RoleMenuDTO findOneByCnd(RoleMenuQueryRequest roleMenu) {
        RoleMenu data = roleMenuDao.findOneByCnd(RoleMenuFactory.newInstance(roleMenu));
        if (data == null) {
            return null;
        }
        return RoleMenuFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(RoleMenuPageQueryRequest params) {
        return roleMenuDao.findAll(RoleMenuFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<RoleMenuDTO> list(RoleMenuQueryRequest params) {
        List<RoleMenu> list = roleMenuDao.list(RoleMenuFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return RoleMenuFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(RoleMenuEnableRequest params) {
        return roleMenuDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(RoleMenuDisableRequest params) {
        return roleMenuDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(RoleMenuBatchEnableAndDisableRequest params) {
        return roleMenuDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(RoleMenuBatchEnableAndDisableRequest params) {
        return roleMenuDao.disable(params.getId());
    }

}
