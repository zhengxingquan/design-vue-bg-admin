package com.quan.core.service.impl;

import com.quan.core.constant.annotation.PageQuery;
import com.quan.core.dao.UserRoleDao;
import com.quan.core.dto.UserRoleDTO;
import com.quan.core.factory.UserRoleFactory;
import com.quan.core.model.UserRole;
import com.quan.core.controller.request.*;
import com.quan.core.controller.request.create.UserRoleCreateRequest;
import com.quan.core.controller.request.update.UserRoleUpdateRequest;
import com.quan.core.service.UserRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(UserRoleCreateRequest data) {
        return userRoleDao.save(UserRoleFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param userRoles
     */
    @Transactional
    @Override
    public int batchSave(List<UserRoleCreateRequest> userRoles) {
        return userRoleDao.batchSave(UserRoleFactory.newBatchInstance(userRoles));
    }

    /**
     * 修改
     *
     * @param userRole
     */
    @Transactional
    @Override
    public int update(UserRoleUpdateRequest userRole) {
        return userRoleDao.update(UserRoleFactory.newInstance(userRole));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return userRoleDao.delete(id);
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
        return userRoleDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public UserRoleDTO findOneById(Long id) {
        UserRole data = userRoleDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return UserRoleFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param userRole 对象数据
     * @return
     */
    @Override
    public UserRoleDTO findOneByCnd(UserRoleQueryRequest userRole) {
        UserRole data = userRoleDao.findOneByCnd(UserRoleFactory.newInstance(userRole));
        if (data == null) {
            return null;
        }
        return UserRoleFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(UserRolePageQueryRequest params) {
        return userRoleDao.findAll(UserRoleFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<UserRoleDTO> list(UserRoleQueryRequest params) {
        List<UserRole> list = userRoleDao.list(UserRoleFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return UserRoleFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(UserRoleEnableRequest params) {
        return userRoleDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(UserRoleDisableRequest params) {
        return userRoleDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(UserRoleBatchEnableAndDisableRequest params) {
        return userRoleDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(UserRoleBatchEnableAndDisableRequest params) {
        return userRoleDao.disable(params.getId());
    }

}
