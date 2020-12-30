package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.baidu.uid.UidGeneratorFeignClient;
import com.quan.core.dao.RoleDao;
import com.quan.core.dto.RoleDTO;
import com.quan.core.dto.create.RoleCreateDTO;
import com.quan.core.factory.RoleFactory;
import com.quan.core.model.Role;
import com.quan.core.request.RolePageQueryRequest;
import com.quan.core.request.RoleQueryRequest;
import com.quan.core.request.create.RoleCreateRequest;
import com.quan.core.request.update.RoleUpdateRequest;
import com.quan.core.service.RoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UidGeneratorFeignClient uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(RoleCreateRequest data) {
        RoleCreateDTO dto = RoleFactory.newInstance(uidGenerator, data);
//        dto.setHasChildren(roleDao.hasChildrenState(data.getParentId()));
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

}
