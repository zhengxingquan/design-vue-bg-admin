package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.RoleGroupDao;
import com.quan.core.dto.RoleGroupDTO;
import com.quan.core.dto.create.RoleGroupCreateDTO;
import com.quan.core.factory.RoleGroupFactory;
import com.quan.core.model.RoleGroup;
import com.quan.core.request.RoleGroupPageQueryRequest;
import com.quan.core.request.RoleGroupQueryRequest;
import com.quan.core.request.create.RoleGroupCreateRequest;
import com.quan.core.request.update.RoleGroupUpdateRequest;
import com.quan.core.service.RoleGroupService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class RoleGroupServiceImpl implements RoleGroupService {

    @Autowired
    private RoleGroupDao roleGroupDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleGroupCreateRequest data) {
        RoleGroupCreateDTO dto = RoleGroupFactory.newInstance(uidGenerator, data);
        dto.setSort(roleGroupDao.sortState(data.getParentId()));
        dto.setPath(roleGroupDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        roleGroupDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return roleGroupDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param roleGroups
     */
    @Transactional
    @Override
    public int batchSave(List<RoleGroupCreateRequest> roleGroups) {
        return roleGroupDao.batchSave(RoleGroupFactory.newBatchInstance(uidGenerator, roleGroups));
    }

    /**
     * 修改
     *
     * @param roleGroup
     */
    @Transactional
    @Override
    public int update(RoleGroupUpdateRequest roleGroup) {
        return roleGroupDao.update(RoleGroupFactory.newInstance(roleGroup));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        // 修改父节点 children 属性
        RoleGroup data = roleGroupDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        roleGroupDao.deleteDataByPath(data.getPath());
        roleGroupDao.deleteNodeUpdateParentNodeAttrChildren(id);
        return 1;

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
        if (CollectionUtils.isEmpty(id)) {
            return 0;
        }
        List<RoleGroup> data = roleGroupDao.findAllById(id);
        if (CollectionUtils.isEmpty(data)) {
            return 0;
        }
        data.forEach(dict -> {
            // 批量删除
            roleGroupDao.deleteDataByPath(dict.getPath());
            roleGroupDao.deleteNodeUpdateParentNodeAttrChildren(dict.getParentId());
        });
        return 1;
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public RoleGroupDTO findOneById(Long id) {
        RoleGroup data = roleGroupDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return RoleGroupFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param roleGroup 对象数据
     * @return
     */
    @Override
    public RoleGroupDTO findOneByCnd(RoleGroupQueryRequest roleGroup) {
        RoleGroup data = roleGroupDao.findOneByCnd(RoleGroupFactory.newInstance(roleGroup));
        if (data == null) {
            return null;
        }
        return RoleGroupFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(RoleGroupPageQueryRequest params) {
        return roleGroupDao.findAll(RoleGroupFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<RoleGroupDTO> list(RoleGroupQueryRequest params) {
        List<RoleGroup> list = roleGroupDao.list(RoleGroupFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return RoleGroupFactory.newInstance(list);
    }

}
