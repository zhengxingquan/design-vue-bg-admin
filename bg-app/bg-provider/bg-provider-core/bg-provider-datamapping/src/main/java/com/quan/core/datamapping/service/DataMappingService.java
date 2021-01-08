package com.quan.core.datamapping.service;

import com.quan.core.datamapping.dto.DataMappingDTO;
import com.quan.core.datamapping.request.create.DataMappingCreateRequest;
import com.quan.core.datamapping.request.update.DataMappingUpdateRequest;
import com.quan.core.datamapping.request.DataMappingPageQueryRequest;
import com.quan.core.datamapping.request.DataMappingQueryRequest;
import com.quan.core.datamapping.request.DataMappingEnableRequest;
import com.quan.core.datamapping.request.DataMappingDisableRequest;
import com.quan.core.datamapping.request.DataMappingBatchEnableAndDisableRequest;

import java.util.List;

/**
 * 系统映射配置表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */
public interface DataMappingService {
    /**
     * 添加
     * @param data
     */
    int save(DataMappingCreateRequest data);

    /**
     * 批量添加
     * @param dataMappings
     */
    int batchSave(List<DataMappingCreateRequest> dataMappings);

    /**
     * 修改
     * @param dataMapping
     */
    int update(DataMappingUpdateRequest dataMapping);

    /**
     * 单条删除
     * @param id
     */
    int delete(Long id);

    /**
    * 批量删除
    *
    * @param id
    */
    int delete(List<Long> id);

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
    DataMappingDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param dataMapping 对象数据
     * @return
     */
    DataMappingDTO findOneByCnd(DataMappingQueryRequest dataMapping);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(DataMappingPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<DataMappingDTO> list(DataMappingQueryRequest params);


    /**
    * 启用
    */
    int enable(DataMappingEnableRequest req);


    /**
    * 禁用
    */
    int disable(DataMappingDisableRequest req);


    /***
    *   批量启用
    */
    int batchEnable(DataMappingBatchEnableAndDisableRequest params);


    /***
    *   批量禁用
    */
    int batchDisable(DataMappingBatchEnableAndDisableRequest params);


}

