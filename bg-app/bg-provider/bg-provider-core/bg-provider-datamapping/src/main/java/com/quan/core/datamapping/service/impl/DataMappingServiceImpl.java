package com.quan.core.datamapping.service.impl;

import com.quan.core.constant.annotation.PageQuery;
import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.constant.util.Strings;
import com.quan.core.datamapping.dao.DataMappingDao;
import com.quan.core.datamapping.dto.DataMappingDTO;
import com.quan.core.datamapping.dto.create.DataMappingCreateDTO;
import com.quan.core.datamapping.dto.update.DataMappingUpdateDTO;
import com.quan.core.datamapping.factory.DataMappingFactory;
import com.quan.core.datamapping.model.DataMapping;
import com.quan.core.datamapping.request.*;
import com.quan.core.datamapping.request.create.DataMappingCreateRequest;
import com.quan.core.datamapping.request.update.DataMappingUpdateRequest;
import com.quan.core.datamapping.service.DataMappingService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class DataMappingServiceImpl implements DataMappingService {

    @Autowired
    private DataMappingDao dataMappingDao;

    @Autowired
    private IUidGenerator uidGenerator;

    /**
     * 添加
     *
     * @param data
     */
    @Transactional
    @Override
    public int save(DataMappingCreateRequest data) {
        // 系统编码是否修改过
        if (Strings.isNotBlank(data.getSysCode())) {
            if (dataMappingDao.sysCodeIsExists(data.getSysCode()) > 0) {
                // 编码相同
            }
        }
        DataMappingCreateDTO dto = DataMappingFactory.newInstance(uidGenerator, data);

        dto.setSort(dataMappingDao.sortState(data.getParentId()));
        dto.setPath(dataMappingDao.getSubPath(data.getParentId()));
        // 修改父节点 children 属性
        dataMappingDao.createNodeUpdateParentNodeAttrChildren(dto.getParentId());
        return dataMappingDao.save(dto);
    }

    /**
     * 批量添加
     *
     * @param dataMappings
     */
    @Transactional
    @Override
    public int batchSave(List<DataMappingCreateRequest> dataMappings) {
        return dataMappingDao.batchSave(DataMappingFactory.newBatchInstance(uidGenerator, dataMappings));
    }

    /**
     * 修改
     *
     * @param dataMapping
     */
    @Transactional
    @Override
    public int update(DataMappingUpdateRequest dataMapping) {
        DataMapping oldMapping = dataMappingDao.findOneById(dataMapping.getId());
        if (oldMapping == null) {
            return 0;
        }
        DataMappingUpdateDTO data = DataMappingFactory.newInstance(dataMapping);
        // 系统编码是否修改过
        if (!Strings.sNull(oldMapping.getSysCode()).equals(data.getSysCode())) {
            if (dataMappingDao.sysCodeIsExists(data.getSysCode()) > 1) {
                // 编码相同
            }
        }
        // 重新计算 path 与 sort
        if (!oldMapping.getParentId().equals(data.getParentId())) {
            data.setSort(dataMappingDao.sortState(data.getParentId()));
            data.setPath(dataMappingDao.getSubPath(data.getParentId()));
            // 修改父节点 children 属性
            dataMappingDao.createNodeUpdateParentNodeAttrChildren(data.getParentId());
        }
        return dataMappingDao.update(data);
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
        DataMapping data = dataMappingDao.findOneById(id);
        if (data == null) {
            return 0;
        }
        // 批量删除
        dataMappingDao.deleteDataByPath(data.getPath());
        dataMappingDao.deleteNodeUpdateParentNodeAttrChildren(id);
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

        List<DataMapping> datas = dataMappingDao.findAllById(id);
        if (CollectionUtils.isEmpty(datas)) {
            return 0;
        }
        datas.forEach(dict -> {
            // 批量删除
            dataMappingDao.deleteDataByPath(dict.getPath());
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
    public DataMappingDTO findOneById(Long id) {
        DataMapping data = dataMappingDao.findOneById(id);
        if (data == null) {
            return null;
        }
        return DataMappingFactory.newInstance(data);
    }


    /**
     * 通过条件查找记录
     *
     * @param dataMapping 对象数据
     * @return
     */
    @Override
    public DataMappingDTO findOneByCnd(DataMappingQueryRequest dataMapping) {
        DataMapping data = dataMappingDao.findOneByCnd(DataMappingFactory.newInstance(dataMapping));
        if (data == null) {
            return null;
        }
        return DataMappingFactory.newInstance(data);
    }


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    @PageQuery
    public Object findAll(DataMappingPageQueryRequest params) {
        return dataMappingDao.findAll(DataMappingFactory.newInstance(params));
    }


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    @Override
    public List<DataMappingDTO> list(DataMappingQueryRequest params) {
        List<DataMapping> list = dataMappingDao.list(DataMappingFactory.newInstance(params));
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return DataMappingFactory.newInstance(list);
    }


    /***
     *   启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int enable(DataMappingEnableRequest params) {
        return dataMappingDao.enable(Arrays.asList(params.getId()));
    }


    /***
     *   禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int disable(DataMappingDisableRequest params) {
        return dataMappingDao.disable(Arrays.asList(params.getId()));
    }

    /***
     *   批量启用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    @Override
    public int batchEnable(DataMappingBatchEnableAndDisableRequest params) {
        return dataMappingDao.enable(params.getId());
    }


    /***
     *   批量禁用
     * @author zxq(956607644 @ qq.com)
     * @date 2021/1/8 9:39
     * @param params

     * @return int
     */
    public int batchDisable(DataMappingBatchEnableAndDisableRequest params) {
        return dataMappingDao.disable(params.getId());
    }

}
