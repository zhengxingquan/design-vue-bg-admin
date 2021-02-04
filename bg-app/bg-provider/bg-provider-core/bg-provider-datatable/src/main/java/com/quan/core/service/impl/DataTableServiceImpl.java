package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.DataTableDao;
import com.quan.core.dao.DatabaseDao;
import com.quan.core.dto.DataTableDTO;
import com.quan.core.dto.create.DataTableCreateDTO;
import com.quan.core.factory.DataTableFactory;
import com.quan.core.model.DataTable;
import com.quan.core.controller.request.DataTablePageQueryRequest;
import com.quan.core.controller.request.DataTableQueryRequest;
import com.quan.core.controller.request.create.DataTableCreateRequest;
import com.quan.core.controller.request.update.DataTableUpdateRequest;
import com.quan.core.service.DataTableService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class DataTableServiceImpl implements DataTableService {

    @Autowired
    private DataTableDao dataTableDao;

    @Autowired
    private DatabaseDao databaseDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(DataTableCreateRequest data) {
        DataTableCreateDTO dto = DataTableFactory.newInstance(uidGenerator, data);
        dto.setSort(dataTableDao.sortState(data.getParentId()));
        dto.setPath(databaseDao.getSubPath(data.getParentId()));

        return dataTableDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param dataTables
     */
    @Transactional
    @Override
    public int batchSave(List<DataTableCreateRequest> dataTables) {
        return dataTableDao.batchSave(DataTableFactory.newBatchInstance(uidGenerator, dataTables));
    }

    /**
     * 修改
     *
     * @param dataTable
     */
    @Transactional
    @Override
    public int update(DataTableUpdateRequest dataTable) {
        return dataTableDao.update(DataTableFactory.newInstance(dataTable));
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
        DataTable data = dataTableDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        dataTableDao.deleteDataByPath(data.getPath());
        // 还要删除字段
        //

        return dataTableDao.delete(id);
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

        databaseDao.batchDelete(id);
        // 还要删除表
        // 还要删除字段
        return 1;
    }

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    @Override
    public DataTableDTO findOneById(Long id) {
        DataTable data = dataTableDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return DataTableFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param dataTable 对象数据
     * @return
     */
    @Override
    public DataTableDTO findOneByCnd(DataTableQueryRequest dataTable) {
        DataTable data = dataTableDao.findOneByCnd(DataTableFactory.newInstance(dataTable));
        if (data == null) {
            return null;
        }
        return DataTableFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(DataTablePageQueryRequest params) {
        return dataTableDao.findAll(DataTableFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<DataTableDTO> list(DataTableQueryRequest params) {
        List<DataTable> list = dataTableDao.list(DataTableFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return DataTableFactory.newInstance(list);
    }

}
