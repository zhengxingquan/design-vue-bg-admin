package com.quan.core.service.impl;

import com.quan.core.cache.annotation.*;
import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.RoleDao;
import com.quan.core.dto.RoleDTO;
import com.quan.core.dto.create.RoleCreateDTO;
import com.quan.core.factory.RoleFactory;
import com.quan.core.model.Role;
import com.quan.core.controller.request.RolePageQueryRequest;
import com.quan.core.controller.request.RoleQueryRequest;
import com.quan.core.controller.request.create.RoleCreateRequest;
import com.quan.core.controller.request.update.RoleUpdateRequest;
import com.quan.core.service.RoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
@CacheDefaults(cacheName = "sys:role")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleCreateRequest data) {
        RoleCreateDTO dto = RoleFactory.newInstance(uidGenerator, data);
        dto.setSort(roleDao.sortState(data.getParentId()));
        dto.setPath(roleDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        roleDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return roleDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param roles
     */
    @Transactional
    @Override
    public int batchSave(List<RoleCreateRequest> roles) {
        return roleDao.batchSave(RoleFactory.newBatchInstance(uidGenerator, roles));
    }

    /**
     * 修改
     *
     * @param role
     */
    @Transactional
    @Override
    @CacheRemove(cacheKey = "${#role.id}")
    public int update(RoleUpdateRequest role) {
        return roleDao.update(RoleFactory.newInstance(role));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    @CacheRemove(cacheKey = "${#args[0]}")
    public int delete(Long id) {
        return roleDao.delete(id);
    }

    /**
     * 批量删除
     *
     * @param id
     */
    @Transactional
    @Override
    @CacheRemove(cacheKey = "${#args[0]}")
    public int delete(List<Long> id) {
        if (CollectionUtils.isEmpty(id)) {
            return 0;
        }
        return roleDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    @CacheResult(cacheKey = "${#id}")
    public RoleDTO findOneById(Long id) {
        Role data = roleDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return RoleFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param role 对象数据
     * @return
     */
    @Override
    @CacheResult
    public RoleDTO findOneByCnd(RoleQueryRequest role) {
        Role data = roleDao.findOneByCnd(RoleFactory.newInstance(role));
        if (data == null) {
            return null;
        }
        return RoleFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(RolePageQueryRequest params) {
        return roleDao.findAll(RoleFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<RoleDTO> list(RoleQueryRequest params) {
        List<Role> list = roleDao.list(RoleFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return RoleFactory.newInstance(list);
    }

    @Override
    @CacheRemove(cacheKey = "${#id}*")
    //可以通过el表达式加 * 通配符来批量删除一批缓存
    public void deleteCache(Long id) {

    }

    @CacheRemoveAll
    @Override
    public void clearCache() {

    }

}
