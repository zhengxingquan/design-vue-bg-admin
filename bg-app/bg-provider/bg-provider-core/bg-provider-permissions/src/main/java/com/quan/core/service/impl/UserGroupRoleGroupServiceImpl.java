package com.quan.core.service.impl;

import com.quan.core.constant.annotation.PageQuery;
import com.quan.core.dao.UserGroupRoleGroupDao;
import com.quan.core.dto.UserGroupRoleGroupDTO;
import com.quan.core.factory.UserGroupRoleGroupFactory;
import com.quan.core.model.UserGroupRoleGroup;
import com.quan.core.controller.request.*;
import com.quan.core.controller.request.create.UserGroupRoleGroupCreateRequest;
import com.quan.core.controller.request.update.UserGroupRoleGroupUpdateRequest;
import com.quan.core.service.UserGroupRoleGroupService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class UserGroupRoleGroupServiceImpl implements UserGroupRoleGroupService {

    @Autowired
    private UserGroupRoleGroupDao userGroupRoleGroupDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(UserGroupRoleGroupCreateRequest data) {
        return userGroupRoleGroupDao.save(UserGroupRoleGroupFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param userGroupRoleGroups
     */
    @Transactional
    @Override
    public int batchSave(List<UserGroupRoleGroupCreateRequest> userGroupRoleGroups) {
        return userGroupRoleGroupDao.batchSave(UserGroupRoleGroupFactory.newBatchInstance(userGroupRoleGroups));
    }

    /**
     * 修改
     *
     * @param userGroupRoleGroup
     */
    @Transactional
    @Override
    public int update(UserGroupRoleGroupUpdateRequest userGroupRoleGroup) {
        return userGroupRoleGroupDao.update(UserGroupRoleGroupFactory.newInstance(userGroupRoleGroup));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return userGroupRoleGroupDao.delete(id);
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
        return userGroupRoleGroupDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public UserGroupRoleGroupDTO findOneById(Long id) {
        UserGroupRoleGroup data = userGroupRoleGroupDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return UserGroupRoleGroupFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param userGroupRoleGroup 对象数据
     * @return
     */
    @Override
    public UserGroupRoleGroupDTO findOneByCnd(UserGroupRoleGroupQueryRequest userGroupRoleGroup) {
        UserGroupRoleGroup data = userGroupRoleGroupDao.findOneByCnd(UserGroupRoleGroupFactory.newInstance(userGroupRoleGroup));
        if (data == null) {
            return null;
        }
        return UserGroupRoleGroupFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(UserGroupRoleGroupPageQueryRequest params) {
        return userGroupRoleGroupDao.findAll(UserGroupRoleGroupFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<UserGroupRoleGroupDTO> list(UserGroupRoleGroupQueryRequest params) {
        List<UserGroupRoleGroup> list = userGroupRoleGroupDao.list(UserGroupRoleGroupFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return UserGroupRoleGroupFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(UserGroupRoleGroupEnableRequest params) {
        return userGroupRoleGroupDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(UserGroupRoleGroupDisableRequest params) {
        return userGroupRoleGroupDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(UserGroupRoleGroupBatchEnableAndDisableRequest params) {
        return userGroupRoleGroupDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(UserGroupRoleGroupBatchEnableAndDisableRequest params) {
        return userGroupRoleGroupDao.disable(params.getId());
    }

}
