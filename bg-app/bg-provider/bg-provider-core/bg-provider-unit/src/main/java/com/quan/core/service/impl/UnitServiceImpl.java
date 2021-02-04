package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.UnitDao;
import com.quan.core.dto.UnitDTO;
import com.quan.core.dto.create.UnitCreateDTO;
import com.quan.core.factory.UnitFactory;
import com.quan.core.model.Unit;
import com.quan.core.controller.request.UnitPageQueryRequest;
import com.quan.core.controller.request.UnitQueryRequest;
import com.quan.core.controller.request.create.UnitCreateRequest;
import com.quan.core.controller.request.update.UnitUpdateRequest;
import com.quan.core.service.UnitService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(UnitCreateRequest data) {
        UnitCreateDTO dto = UnitFactory.newInstance(uidGenerator,data);
        dto.setSort(unitDao.sortState(data.getParentId()));
        dto.setPath(unitDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        unitDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return unitDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param units
     */
    @Transactional
    @Override
    public int batchSave(List<UnitCreateRequest> units) {
        return unitDao.batchSave(UnitFactory.newBatchInstance(uidGenerator,units));
    }

    /**
     * 修改
     *
     * @param unit
     */
    @Transactional
    @Override
    public int update(UnitUpdateRequest unit) {
        return unitDao.update(UnitFactory.newInstance(unit));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return unitDao.delete(id);
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
        return unitDao.batchDelete(id);
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public UnitDTO findOneById(Long id) {
        Unit data = unitDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return UnitFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param unit 对象数据
     * @return
     */
    @Override
    public UnitDTO findOneByCnd(UnitQueryRequest unit) {
        Unit data = unitDao.findOneByCnd(UnitFactory.newInstance(unit));
        if (data == null) {
            return null;
        }
        return UnitFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(UnitPageQueryRequest params) {
        return unitDao.findAll(UnitFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<UnitDTO> list(UnitQueryRequest params) {
        List<Unit> list = unitDao.list(UnitFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return UnitFactory.newInstance(list);
    }

}
