package com.quan.core.service.impl;

import com.quan.core.common.annotation.PageQuery;
import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dao.DatabaseDao;
import com.quan.core.dto.DatabaseDTO;
import com.quan.core.dto.create.DatabaseCreateDTO;
import com.quan.core.factory.DatabaseFactory;
import com.quan.core.model.Database;
import com.quan.core.request.DatabasePageQueryRequest;
import com.quan.core.request.DatabaseQueryRequest;
import com.quan.core.request.create.DatabaseCreateRequest;
import com.quan.core.request.update.DatabaseUpdateRequest;
import com.quan.core.service.DatabaseService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class DatabaseServiceImpl implements DatabaseService {

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
    public int save(DatabaseCreateRequest data) {
        DatabaseCreateDTO dto = DatabaseFactory.newInstance(uidGenerator, data);
        dto.setSort(databaseDao.sortState(0L));
        dto.setPath(databaseDao.getSubPath(0L));

        return databaseDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param databases
     */
    @Transactional
    @Override
    public int batchSave(List<DatabaseCreateRequest> databases) {
        return databaseDao.batchSave(DatabaseFactory.newBatchInstance(uidGenerator, databases));
    }

    /**
     * 修改
     *
     * @param database
     */
    @Transactional
    @Override
    public int update(DatabaseUpdateRequest database) {
        return databaseDao.update(DatabaseFactory.newInstance(database));
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
        Database data = databaseDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        databaseDao.deleteDataByPath(data.getPath());
        // 还要删除表
        // 还要删除字段
        //
//        databaseDao.deleteNodeUpdateParentNodeAttrChildren(id);
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
    public DatabaseDTO findOneById(Long id) {
        Database data = databaseDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return DatabaseFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param database 对象数据
     * @return
     */
    @Override
    public DatabaseDTO findOneByCnd(DatabaseQueryRequest database) {
        Database data = databaseDao.findOneByCnd(DatabaseFactory.newInstance(database));
        if (data == null) {
            return null;
        }
        return DatabaseFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(DatabasePageQueryRequest params) {
        return databaseDao.findAll(DatabaseFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<DatabaseDTO> list(DatabaseQueryRequest params) {
        List<Database> list = databaseDao.list(DatabaseFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return DatabaseFactory.newInstance(list);
    }

}
