package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.dao.RoleGroupMenuDao;
import com.quan.core.dto.RoleGroupMenuDTO;
import com.quan.core.factory.RoleGroupMenuFactory;
import com.quan.core.model.RoleGroupMenu;
import com.quan.core.request.*;
import com.quan.core.request.create.RoleGroupMenuCreateRequest;
import com.quan.core.request.update.RoleGroupMenuUpdateRequest;
import com.quan.core.service.RoleGroupMenuService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class RoleGroupMenuServiceImpl implements RoleGroupMenuService {

    @Autowired
    private RoleGroupMenuDao roleGroupMenuDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleGroupMenuCreateRequest data) {
        return roleGroupMenuDao.save(RoleGroupMenuFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param roleGroupMenus
     */
    @Transactional
    @Override
    public int batchSave(List<RoleGroupMenuCreateRequest> roleGroupMenus) {
        return roleGroupMenuDao.batchSave(RoleGroupMenuFactory.newBatchInstance(roleGroupMenus));
    }

    /**
     * 修改
     *
     * @param roleGroupMenu
     */
    @Transactional
    @Override
    public int update(RoleGroupMenuUpdateRequest roleGroupMenu) {
        return roleGroupMenuDao.update(RoleGroupMenuFactory.newInstance(roleGroupMenu));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return roleGroupMenuDao.delete(id);
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
        return roleGroupMenuDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public RoleGroupMenuDTO findOneById(Long id) {
        RoleGroupMenu data = roleGroupMenuDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return RoleGroupMenuFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param roleGroupMenu 对象数据
     * @return
     */
    @Override
    public RoleGroupMenuDTO findOneByCnd(RoleGroupMenuQueryRequest roleGroupMenu) {
        RoleGroupMenu data = roleGroupMenuDao.findOneByCnd(RoleGroupMenuFactory.newInstance(roleGroupMenu));
        if (data == null) {
            return null;
        }
        return RoleGroupMenuFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(RoleGroupMenuPageQueryRequest params) {
        return roleGroupMenuDao.findAll(RoleGroupMenuFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<RoleGroupMenuDTO> list(RoleGroupMenuQueryRequest params) {
        List<RoleGroupMenu> list = roleGroupMenuDao.list(RoleGroupMenuFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return RoleGroupMenuFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(RoleGroupMenuEnableRequest params) {
        return roleGroupMenuDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(RoleGroupMenuDisableRequest params) {
        return roleGroupMenuDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(RoleGroupMenuBatchEnableAndDisableRequest params) {
        return roleGroupMenuDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(RoleGroupMenuBatchEnableAndDisableRequest params) {
        return roleGroupMenuDao.disable(params.getId());
    }

}
