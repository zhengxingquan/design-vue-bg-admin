package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.dao.UserGroupRoleDao;
import com.quan.core.dto.UserGroupRoleDTO;
import com.quan.core.factory.UserGroupRoleFactory;
import com.quan.core.model.UserGroupRole;
import com.quan.core.request.*;
import com.quan.core.request.create.UserGroupRoleCreateRequest;
import com.quan.core.request.update.UserGroupRoleUpdateRequest;
import com.quan.core.service.UserGroupRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class UserGroupRoleServiceImpl implements UserGroupRoleService {

    @Autowired
    private UserGroupRoleDao userGroupRoleDao;


    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(UserGroupRoleCreateRequest data) {
        return userGroupRoleDao.save(UserGroupRoleFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param userGroupRoles
     */
    @Transactional
    @Override
    public int batchSave(List<UserGroupRoleCreateRequest> userGroupRoles) {
        return userGroupRoleDao.batchSave(UserGroupRoleFactory.newBatchInstance(userGroupRoles));
    }

    /**
     * 修改
     *
     * @param userGroupRole
     */
    @Transactional
    @Override
    public int update(UserGroupRoleUpdateRequest userGroupRole) {
        return userGroupRoleDao.update(UserGroupRoleFactory.newInstance(userGroupRole));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return userGroupRoleDao.delete(id);
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
        return userGroupRoleDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public UserGroupRoleDTO findOneById(Long id) {
        UserGroupRole data = userGroupRoleDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return UserGroupRoleFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param userGroupRole 对象数据
     * @return
     */
    @Override
    public UserGroupRoleDTO findOneByCnd(UserGroupRoleQueryRequest userGroupRole) {
        UserGroupRole data = userGroupRoleDao.findOneByCnd(UserGroupRoleFactory.newInstance(userGroupRole));
        if (data == null) {
            return null;
        }
        return UserGroupRoleFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(UserGroupRolePageQueryRequest params) {
        return userGroupRoleDao.findAll(UserGroupRoleFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<UserGroupRoleDTO> list(UserGroupRoleQueryRequest params) {
        List<UserGroupRole> list = userGroupRoleDao.list(UserGroupRoleFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return UserGroupRoleFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(UserGroupRoleEnableRequest params) {
        return userGroupRoleDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(UserGroupRoleDisableRequest params) {
        return userGroupRoleDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(UserGroupRoleBatchEnableAndDisableRequest params) {
        return userGroupRoleDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(UserGroupRoleBatchEnableAndDisableRequest params) {
        return userGroupRoleDao.disable(params.getId());
    }

}
