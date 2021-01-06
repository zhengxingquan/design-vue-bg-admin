package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.common.uid.UidGeneratorFeignClient;
import com.quan.core.dao.MenuDao;
import com.quan.core.dto.MenuDTO;
import com.quan.core.dto.create.MenuCreateDTO;
import com.quan.core.factory.MenuFactory;
import com.quan.core.model.Menu;
import com.quan.core.request.MenuPageQueryRequest;
import com.quan.core.request.MenuQueryRequest;
import com.quan.core.request.create.MenuCreateRequest;
import com.quan.core.request.update.MenuUpdateRequest;
import com.quan.core.service.MenuService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(MenuCreateRequest data) {


        MenuCreateDTO dto = MenuFactory.newInstance(uidGenerator, data);
        dto.setSort(menuDao.sortState(data.getParentId()));
        dto.setPath(menuDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        menuDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return menuDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param menus
     */
    @Transactional
    @Override
    public int batchSave(List<MenuCreateRequest> menus) {
        return menuDao.batchSave(MenuFactory.newBatchInstance(uidGenerator, menus));
    }

    /**
     * 修改
     *
     * @param menu
     */
    @Transactional
    @Override
    public int update(MenuUpdateRequest menu) {
        return menuDao.update(MenuFactory.newInstance(menu));
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
        Menu data = menuDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        menuDao.deleteDataByPath(data.getPath());
        menuDao.deleteNodeUpdateParentNodeAttrChildren(id);
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
        List<Menu> datas = menuDao.findAllById(id);
        if (CollectionUtils.isEmpty(datas)) {
            return 0;
        }
        datas.forEach(dict -> {
            // 批量删除
            menuDao.deleteDataByPath(dict.getPath());
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
    public MenuDTO findOneById(Long id) {
        Menu data = menuDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return MenuFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param menu 对象数据
     * @return
     */
    @Override
    public MenuDTO findOneByCnd(MenuQueryRequest menu) {
        Menu data = menuDao.findOneByCnd(MenuFactory.newInstance(menu));
        if (data == null) {
            return null;
        }
        return MenuFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(MenuPageQueryRequest params) {
        return menuDao.findAll(MenuFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<MenuDTO> list(MenuQueryRequest params) {
        List<Menu> list = menuDao.list(MenuFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return MenuFactory.newInstance(list);
    }

}
