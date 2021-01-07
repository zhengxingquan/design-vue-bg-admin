package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.DataFieldDao;
import com.quan.core.dto.DataFieldDTO;
import com.quan.core.model.DataField;
import com.quan.core.factory.DataFieldFactory;
import com.quan.core.service.DataFieldService;
import com.quan.core.request.DataFieldPageQueryRequest;
import com.quan.core.request.DataFieldQueryRequest;
import com.quan.core.request.create.DataFieldCreateRequest;
import com.quan.core.request.update.DataFieldUpdateRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;


@Service
public class DataFieldServiceImpl implements DataFieldService {

    @Autowired
    private DataFieldDao dataFieldDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(DataFieldCreateRequest data) {
        return dataFieldDao.save(DataFieldFactory.newInstance(uidGenerator,data));
    }

    /**
     * 批量添加
     *
     * @param dataFields
     */
    @Transactional
    @Override
    public int batchSave(List<DataFieldCreateRequest> dataFields) {
        return dataFieldDao.batchSave(DataFieldFactory.newBatchInstance(uidGenerator,dataFields));
    }

    /**
     * 修改
     * @param dataField
     */
    @Transactional
    @Override
    public int update(DataFieldUpdateRequest dataField) {
        return dataFieldDao.update(DataFieldFactory.newInstance(dataField));
    }

    /**
     * 单条删除
     * @param id
     */
    @Transactional
    @Override
    public int delete(Long id) {
        return dataFieldDao.delete(id);
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
        return dataFieldDao.batchDelete(id);
    }

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
    @Override
    public  DataFieldDTO findOneById(Long id) {
        DataField data = dataFieldDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return DataFieldFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     * @param dataField 对象数据
     * @return
     */
    @Override
    public DataFieldDTO findOneByCnd(DataFieldQueryRequest dataField) {
        DataField data = dataFieldDao.findOneByCnd(DataFieldFactory.newInstance(dataField));
        if (data == null) {
            return null;
        }
        return DataFieldFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(DataFieldPageQueryRequest params) {
        return dataFieldDao.findAll(DataFieldFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    @Override
    public List<DataFieldDTO> list(DataFieldQueryRequest params) {
        List<DataField> list = dataFieldDao.list(DataFieldFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return DataFieldFactory.newInstance(list);
    }

}
