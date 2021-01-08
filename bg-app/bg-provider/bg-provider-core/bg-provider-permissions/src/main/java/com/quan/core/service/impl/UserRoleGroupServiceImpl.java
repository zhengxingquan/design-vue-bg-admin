package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.dao.UserRoleGroupDao;
import com.quan.core.dto.UserRoleGroupDTO;
import com.quan.core.factory.UserRoleGroupFactory;
import com.quan.core.model.UserRoleGroup;
import com.quan.core.request.*;
import com.quan.core.request.create.UserRoleGroupCreateRequest;
import com.quan.core.request.update.UserRoleGroupUpdateRequest;
import com.quan.core.service.UserRoleGroupService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class UserRoleGroupServiceImpl implements UserRoleGroupService {

    @Autowired
    private UserRoleGroupDao userRoleGroupDao;


    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(UserRoleGroupCreateRequest data) {
        return userRoleGroupDao.save(UserRoleGroupFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param userRoleGroups
     */
    @Transactional
    @Override
    public int batchSave(List<UserRoleGroupCreateRequest> userRoleGroups) {
        return userRoleGroupDao.batchSave(UserRoleGroupFactory.newBatchInstance(userRoleGroups));
    }

    /**
     * 修改
     *
     * @param userRoleGroup
     */
    @Transactional
    @Override
    public int update(UserRoleGroupUpdateRequest userRoleGroup) {
        return userRoleGroupDao.update(UserRoleGroupFactory.newInstance(userRoleGroup));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return userRoleGroupDao.delete(id);
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
        return userRoleGroupDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public UserRoleGroupDTO findOneById(Long id) {
        UserRoleGroup data = userRoleGroupDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return UserRoleGroupFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param userRoleGroup 对象数据
     * @return
     */
    @Override
    public UserRoleGroupDTO findOneByCnd(UserRoleGroupQueryRequest userRoleGroup) {
        UserRoleGroup data = userRoleGroupDao.findOneByCnd(UserRoleGroupFactory.newInstance(userRoleGroup));
        if (data == null) {
            return null;
        }
        return UserRoleGroupFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(UserRoleGroupPageQueryRequest params) {
        return userRoleGroupDao.findAll(UserRoleGroupFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<UserRoleGroupDTO> list(UserRoleGroupQueryRequest params) {
        List<UserRoleGroup> list = userRoleGroupDao.list(UserRoleGroupFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return UserRoleGroupFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(UserRoleGroupEnableRequest params) {
        return userRoleGroupDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(UserRoleGroupDisableRequest params) {
        return userRoleGroupDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(UserRoleGroupBatchEnableAndDisableRequest params) {
        return userRoleGroupDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(UserRoleGroupBatchEnableAndDisableRequest params) {
        return userRoleGroupDao.disable(params.getId());
    }

}
