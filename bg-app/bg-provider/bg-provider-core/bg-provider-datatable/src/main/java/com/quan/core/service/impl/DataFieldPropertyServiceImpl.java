package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.DataFieldPropertyDao;
import com.quan.core.dto.DataFieldPropertyDTO;
import com.quan.core.dto.create.DataFieldPropertyCreateDTO;
import com.quan.core.factory.DataFieldPropertyFactory;
import com.quan.core.model.DataFieldProperty;
import com.quan.core.request.DataFieldPropertyPageQueryRequest;
import com.quan.core.request.DataFieldPropertyQueryRequest;
import com.quan.core.request.create.DataFieldPropertyCreateRequest;
import com.quan.core.request.update.DataFieldPropertyUpdateRequest;
import com.quan.core.service.DataFieldPropertyService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class DataFieldPropertyServiceImpl implements DataFieldPropertyService {

    @Autowired
    private DataFieldPropertyDao dataFieldPropertyDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(DataFieldPropertyCreateRequest data) {
        DataFieldPropertyCreateDTO dto = DataFieldPropertyFactory.newInstance(uidGenerator, data);
        dto.setSort(dataFieldPropertyDao.sortState(data.getParentId()));
        dto.setPath(dataFieldPropertyDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        dataFieldPropertyDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return dataFieldPropertyDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param dataFieldPropertys
     */
    @Transactional
    @Override
    public int batchSave(List<DataFieldPropertyCreateRequest> dataFieldPropertys) {
        return dataFieldPropertyDao.batchSave(DataFieldPropertyFactory.newBatchInstance(uidGenerator, dataFieldPropertys));
    }

    /**
     * 修改
     *
     * @param dataFieldProperty
     */
    @Transactional
    @Override
    public int update(DataFieldPropertyUpdateRequest dataFieldProperty) {
        return dataFieldPropertyDao.update(DataFieldPropertyFactory.newInstance(dataFieldProperty));
    }

    /**
     * 单条删除
     *
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {

        DataFieldProperty data = dataFieldPropertyDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        dataFieldPropertyDao.deleteDataByPath(data.getPath());
        dataFieldPropertyDao.deleteNodeUpdateParentNodeAttrChildren(id);
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
        List<DataFieldProperty> datas = dataFieldPropertyDao.findAllById(id);
        if (CollectionUtils.isEmpty(datas)) {
            return 0;
        }
        datas.forEach(dict -> {
            // 批量删除
            dataFieldPropertyDao.deleteDataByPath(dict.getPath());
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
    public DataFieldPropertyDTO findOneById(Long id) {
        DataFieldProperty data = dataFieldPropertyDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return DataFieldPropertyFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param dataFieldProperty 对象数据
     * @return
     */
    @Override
    public DataFieldPropertyDTO findOneByCnd(DataFieldPropertyQueryRequest dataFieldProperty) {
        DataFieldProperty data = dataFieldPropertyDao.findOneByCnd(DataFieldPropertyFactory.newInstance(dataFieldProperty));
        if (data == null) {
            return null;
        }
        return DataFieldPropertyFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(DataFieldPropertyPageQueryRequest params) {
        return dataFieldPropertyDao.findAll(DataFieldPropertyFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<DataFieldPropertyDTO> list(DataFieldPropertyQueryRequest params) {
        List<DataFieldProperty> list = dataFieldPropertyDao.list(DataFieldPropertyFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return DataFieldPropertyFactory.newInstance(list);
    }

}
