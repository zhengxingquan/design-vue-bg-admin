package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.DictDao;
import com.quan.core.dto.DictDTO;
import com.quan.core.dto.create.DictCreateDTO;
import com.quan.core.factory.DictFactory;
import com.quan.core.model.Dict;
import com.quan.core.request.DictPageQueryRequest;
import com.quan.core.request.DictQueryRequest;
import com.quan.core.request.create.DictCreateRequest;
import com.quan.core.request.update.DictUpdateRequest;
import com.quan.core.service.DictService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dictDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(DictCreateRequest data) {

        DictCreateDTO dto = DictFactory.newInstance(uidGenerator, data);
        dto.setSort(dictDao.sortState(data.getParentId()));
        dto.setPath(dictDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        dictDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return dictDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param dicts
     */
    @Transactional
    @Override
    public int batchSave(List<DictCreateRequest> dicts) {
        return dictDao.batchSave(DictFactory.newBatchInstance(uidGenerator, dicts));
    }

    /**
     * 修改
     *
     * @param dict
     */
    @Transactional
    @Override
    public int update(DictUpdateRequest dict) {

        return dictDao.update(DictFactory.newInstance(dict));
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
        Dict data = dictDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        dictDao.deleteDataByPath(data.getPath());
        dictDao.deleteNodeUpdateParentNodeAttrChildren(id);
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
        List<Dict> datas = dictDao.findAllById(id);
        if (CollectionUtils.isEmpty(datas)) {
            return 0;
        }
        datas.forEach(dict -> {
            // 批量删除
            dictDao.deleteDataByPath(dict.getPath());
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
    public DictDTO findOneById(Long id) {
        Dict data = dictDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return DictFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param dict 对象数据
     * @return
     */
    @Override
    public DictDTO findOneByCnd(DictQueryRequest dict) {
        Dict data = dictDao.findOneByCnd(DictFactory.newInstance(dict));
        if (data == null) {
            return null;
        }
        return DictFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(DictPageQueryRequest params) {
        return dictDao.findAll(DictFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<DictDTO> list(DictQueryRequest params) {
        List<Dict> list = dictDao.list(DictFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return DictFactory.newInstance(list);
    }

}
