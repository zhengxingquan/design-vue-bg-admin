package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.MenuGroupDao;
import com.quan.core.dto.MenuGroupDTO;
import com.quan.core.dto.create.MenuGroupCreateDTO;
import com.quan.core.factory.MenuGroupFactory;
import com.quan.core.model.MenuGroup;
import com.quan.core.request.MenuGroupPageQueryRequest;
import com.quan.core.request.MenuGroupQueryRequest;
import com.quan.core.request.create.MenuGroupCreateRequest;
import com.quan.core.request.update.MenuGroupUpdateRequest;
import com.quan.core.service.MenuGroupService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class MenuGroupServiceImpl implements MenuGroupService {

    @Autowired
    private MenuGroupDao menuGroupDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(MenuGroupCreateRequest data) {
        MenuGroupCreateDTO dto = MenuGroupFactory.newInstance(uidGenerator, data);
        dto.setSort(menuGroupDao.sortState(data.getParentId()));
        dto.setPath(menuGroupDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        menuGroupDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return menuGroupDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param menuGroups
     */
    @Transactional
    @Override
    public int batchSave(List<MenuGroupCreateRequest> menuGroups) {
        return menuGroupDao.batchSave(MenuGroupFactory.newBatchInstance(uidGenerator, menuGroups));
    }

    /**
     * 修改
     *
     * @param menuGroup
     */
    @Transactional
    @Override
    public int update(MenuGroupUpdateRequest menuGroup) {
        return menuGroupDao.update(MenuGroupFactory.newInstance(menuGroup));
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
        MenuGroup data = menuGroupDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        menuGroupDao.deleteDataByPath(data.getPath());
        menuGroupDao.deleteNodeUpdateParentNodeAttrChildren(id);
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
        List<MenuGroup> datas = menuGroupDao.findAllById(id);
        if (CollectionUtils.isEmpty(datas)) {
            return 0;
        }
        datas.forEach(dict -> {
            // 批量删除
            menuGroupDao.deleteDataByPath(dict.getPath());
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
    public MenuGroupDTO findOneById(Long id) {
        MenuGroup data = menuGroupDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return MenuGroupFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param menuGroup 对象数据
     * @return
     */
    @Override
    public MenuGroupDTO findOneByCnd(MenuGroupQueryRequest menuGroup) {
        MenuGroup data = menuGroupDao.findOneByCnd(MenuGroupFactory.newInstance(menuGroup));
        if (data == null) {
            return null;
        }
        return MenuGroupFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(MenuGroupPageQueryRequest params) {
        return menuGroupDao.findAll(MenuGroupFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<MenuGroupDTO> list(MenuGroupQueryRequest params) {
        List<MenuGroup> list = menuGroupDao.list(MenuGroupFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return MenuGroupFactory.newInstance(list);
    }

}
