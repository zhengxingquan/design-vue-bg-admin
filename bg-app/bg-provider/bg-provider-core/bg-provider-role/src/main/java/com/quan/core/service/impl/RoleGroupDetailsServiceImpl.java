package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.dao.RoleGroupDetailsDao;
import com.quan.core.dto.RoleGroupDetailsDTO;
import com.quan.core.factory.RoleGroupDetailsFactory;
import com.quan.core.model.RoleGroupDetails;
import com.quan.core.controller.request.RoleGroupDetailsPageQueryRequest;
import com.quan.core.controller.request.RoleGroupDetailsQueryRequest;
import com.quan.core.controller.request.create.RoleGroupDetailsCreateRequest;
import com.quan.core.controller.request.update.RoleGroupDetailsUpdateRequest;
import com.quan.core.service.RoleGroupDetailsService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class RoleGroupDetailsServiceImpl implements RoleGroupDetailsService {

    @Autowired
    private RoleGroupDetailsDao roleGroupDetailsDao;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleGroupDetailsCreateRequest data) {
        return roleGroupDetailsDao.save(RoleGroupDetailsFactory.newInstance(data));
    }

    /**
     * 批量添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int batchSave(List<RoleGroupDetailsCreateRequest> data) {
        return roleGroupDetailsDao.batchSave(RoleGroupDetailsFactory.newBatchInstance(data));
    }

    /**
     * 修改
     *
     * @param roleGroupDetails
     */
    @Transactional
    @Override
    public int update(RoleGroupDetailsUpdateRequest roleGroupDetails) {
        return roleGroupDetailsDao.update(RoleGroupDetailsFactory.newInstance(roleGroupDetails));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return roleGroupDetailsDao.delete(id);
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
        return roleGroupDetailsDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public RoleGroupDetailsDTO findOneById(Long id) {
        RoleGroupDetails data = roleGroupDetailsDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return RoleGroupDetailsFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param roleGroupDetails 对象数据
     * @return
     */
    @Override
    public RoleGroupDetailsDTO findOneByCnd(RoleGroupDetailsQueryRequest roleGroupDetails) {
        RoleGroupDetails data = roleGroupDetailsDao.findOneByCnd(RoleGroupDetailsFactory.newInstance(roleGroupDetails));
        if (data == null) {
            return null;
        }
        return RoleGroupDetailsFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(RoleGroupDetailsPageQueryRequest params) {
        return roleGroupDetailsDao.findAll(RoleGroupDetailsFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<RoleGroupDetailsDTO> list(RoleGroupDetailsQueryRequest params) {
        List<RoleGroupDetails> list = roleGroupDetailsDao.list(RoleGroupDetailsFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return RoleGroupDetailsFactory.newInstance(list);
    }

}
