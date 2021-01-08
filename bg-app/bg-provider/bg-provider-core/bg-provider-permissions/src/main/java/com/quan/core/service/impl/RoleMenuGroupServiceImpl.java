package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.RoleMenuGroupDTO;
import com.quan.core.model.RoleMenuGroup;
import com.quan.core.factory.RoleMenuGroupFactory;
import com.quan.core.dao.RoleMenuGroupDao;
import com.quan.core.service.RoleMenuGroupService;
import com.quan.core.request.RoleMenuGroupPageQueryRequest;
import com.quan.core.request.RoleMenuGroupQueryRequest;
import com.quan.core.request.create.RoleMenuGroupCreateRequest;
import com.quan.core.request.update.RoleMenuGroupUpdateRequest;
import com.quan.core.request.RoleMenuGroupEnableRequest;
import com.quan.core.request.RoleMenuGroupDisableRequest;
import com.quan.core.request.RoleMenuGroupBatchEnableAndDisableRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class RoleMenuGroupServiceImpl implements RoleMenuGroupService {

    @Autowired
    private RoleMenuGroupDao roleMenuGroupDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleMenuGroupCreateRequest data) {
        return roleMenuGroupDao.save(RoleMenuGroupFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param roleMenuGroups
     */
    @Transactional
    @Override
    public int batchSave(List<RoleMenuGroupCreateRequest> roleMenuGroups) {
        return roleMenuGroupDao.batchSave(RoleMenuGroupFactory.newBatchInstance(roleMenuGroups));
    }

    /**
     * 修改
     * @param roleMenuGroup
     */
    @Transactional
    @Override
    public int update(RoleMenuGroupUpdateRequest roleMenuGroup) {
        return roleMenuGroupDao.update(RoleMenuGroupFactory.newInstance(roleMenuGroup));
    }

    /**
     * 单条删除
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return roleMenuGroupDao.delete(id);
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
        return roleMenuGroupDao.batchDelete(id);
    }

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
    @Override
    public  RoleMenuGroupDTO findOneById(Long id) {
        RoleMenuGroup data = roleMenuGroupDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return RoleMenuGroupFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     * @param roleMenuGroup 对象数据
     * @return
     */
    @Override
    public RoleMenuGroupDTO findOneByCnd(RoleMenuGroupQueryRequest roleMenuGroup) {
        RoleMenuGroup data = roleMenuGroupDao.findOneByCnd(RoleMenuGroupFactory.newInstance(roleMenuGroup));
        if (data == null) {
            return null;
        }
        return RoleMenuGroupFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(RoleMenuGroupPageQueryRequest params) {
        return roleMenuGroupDao.findAll(RoleMenuGroupFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    @Override
    public List<RoleMenuGroupDTO> list(RoleMenuGroupQueryRequest params) {
        List<RoleMenuGroup> list = roleMenuGroupDao.list(RoleMenuGroupFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return RoleMenuGroupFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644@qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(RoleMenuGroupEnableRequest params){
        return roleMenuGroupDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644@qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(RoleMenuGroupDisableRequest params){
        return roleMenuGroupDao.disable(Arrays.asList(params.getId()));
    }

    /***
    *   批量启用
    * @author zxq(956607644@qq.com)
    * @date 2021/1/8 9:39
    * @param params

    * @return int
    */
    @Override
    public int batchEnable(RoleMenuGroupBatchEnableAndDisableRequest params){
        return roleMenuGroupDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644@qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchDisable(RoleMenuGroupBatchEnableAndDisableRequest params){
        return roleMenuGroupDao.disable(params.getId());
    }

}
