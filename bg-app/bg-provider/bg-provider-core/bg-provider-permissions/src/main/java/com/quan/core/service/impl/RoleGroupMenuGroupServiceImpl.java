package com.quan.core.service.impl;

import com.quan.core.constant.annotation.PageQuery;
import com.quan.core.dao.RoleGroupMenuGroupDao;
import com.quan.core.dto.RoleGroupMenuGroupDTO;
import com.quan.core.factory.RoleGroupMenuGroupFactory;
import com.quan.core.model.RoleGroupMenuGroup;
import com.quan.core.controller.request.*;
import com.quan.core.controller.request.create.RoleGroupMenuGroupCreateRequest;
import com.quan.core.controller.request.update.RoleGroupMenuGroupUpdateRequest;
import com.quan.core.service.RoleGroupMenuGroupService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class RoleGroupMenuGroupServiceImpl implements RoleGroupMenuGroupService {

    @Autowired
    private RoleGroupMenuGroupDao roleGroupMenuGroupDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleGroupMenuGroupCreateRequest data) {
        return roleGroupMenuGroupDao.save(RoleGroupMenuGroupFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param roleGroupMenuGroups
     */
    @Transactional
    @Override
    public int batchSave(List<RoleGroupMenuGroupCreateRequest> roleGroupMenuGroups) {
        return roleGroupMenuGroupDao.batchSave(RoleGroupMenuGroupFactory.newBatchInstance(roleGroupMenuGroups));
    }

    /**
     * 修改
     *
     * @param roleGroupMenuGroup
     */
    @Transactional
    @Override
    public int update(RoleGroupMenuGroupUpdateRequest roleGroupMenuGroup) {
        return roleGroupMenuGroupDao.update(RoleGroupMenuGroupFactory.newInstance(roleGroupMenuGroup));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return roleGroupMenuGroupDao.delete(id);
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
        return roleGroupMenuGroupDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public RoleGroupMenuGroupDTO findOneById(Long id) {
        RoleGroupMenuGroup data = roleGroupMenuGroupDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return RoleGroupMenuGroupFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param roleGroupMenuGroup 对象数据
     * @return
     */
    @Override
    public RoleGroupMenuGroupDTO findOneByCnd(RoleGroupMenuGroupQueryRequest roleGroupMenuGroup) {
        RoleGroupMenuGroup data = roleGroupMenuGroupDao.findOneByCnd(RoleGroupMenuGroupFactory.newInstance(roleGroupMenuGroup));
        if (data == null) {
            return null;
        }
        return RoleGroupMenuGroupFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(RoleGroupMenuGroupPageQueryRequest params) {
        return roleGroupMenuGroupDao.findAll(RoleGroupMenuGroupFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<RoleGroupMenuGroupDTO> list(RoleGroupMenuGroupQueryRequest params) {
        List<RoleGroupMenuGroup> list = roleGroupMenuGroupDao.list(RoleGroupMenuGroupFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return RoleGroupMenuGroupFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(RoleGroupMenuGroupEnableRequest params) {
        return roleGroupMenuGroupDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(RoleGroupMenuGroupDisableRequest params) {
        return roleGroupMenuGroupDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(RoleGroupMenuGroupBatchEnableAndDisableRequest params) {
        return roleGroupMenuGroupDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(RoleGroupMenuGroupBatchEnableAndDisableRequest params) {
        return roleGroupMenuGroupDao.disable(params.getId());
    }

}
