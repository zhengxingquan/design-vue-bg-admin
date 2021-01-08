package com.quan.core.datamapping.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.datamapping.dto.DataMappingDTO;
import com.quan.core.datamapping.dto.DataMappingPageQueryDTO;
import com.quan.core.datamapping.dto.DataMappingQueryDTO;
import com.quan.core.datamapping.dto.create.DataMappingCreateDTO;
import com.quan.core.datamapping.dto.update.DataMappingUpdateDTO;
import com.quan.core.datamapping.model.DataMapping;
import com.quan.core.datamapping.request.DataMappingPageQueryRequest;
import com.quan.core.datamapping.request.DataMappingQueryRequest;
import com.quan.core.datamapping.request.create.DataMappingCreateRequest;
import com.quan.core.datamapping.request.update.DataMappingUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统映射配置表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */
public final class DataMappingFactory {


    /***
     * 新建
     *
     * @return
     */
    public static DataMappingCreateDTO newInstance(IUidGenerator uidGenerator, DataMappingCreateRequest req) {
        DataMappingCreateDTO createData = new DataMappingCreateDTO();
        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setModelName(req.getModelName());
        createData.setName(req.getName());
        createData.setDatabaseId(req.getDatabaseId());
        createData.setTableId(req.getTableId());
        createData.setFiledId(req.getFiledId());
        createData.setCondition(req.getCondition());
        createData.setSysCode(req.getSysCode());
        createData.setFields(req.getFields());
        createData.setType(req.getType());
        createData.setNote(req.getNote());
        createData.setSql(req.getSql());
        createData.setCreateTime(new Date());
        createData.setCreateUserId(0L);
        createData.setHasChildren(0);
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static DataMappingUpdateDTO newInstance(DataMappingUpdateRequest req) {
        DataMappingUpdateDTO updateData = new DataMappingUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setModelName(req.getModelName());
        updateData.setName(req.getName());
        updateData.setDatabaseId(req.getDatabaseId());
        updateData.setTableId(req.getTableId());
        updateData.setFiledId(req.getFiledId());
        updateData.setCondition(req.getCondition());
        updateData.setSysCode(req.getSysCode());
        updateData.setFields(req.getFields());
        updateData.setType(req.getType());
        updateData.setNote(req.getNote());
        updateData.setSql(req.getSql());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<DataMappingCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<DataMappingCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static DataMappingQueryDTO newInstance(DataMappingQueryRequest req) {
        DataMappingQueryDTO queryData = new DataMappingQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static DataMappingPageQueryDTO newInstance(DataMappingPageQueryRequest req) {
        DataMappingPageQueryDTO query = new DataMappingPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static DataMappingDTO newInstance(DataMapping data) {
        DataMappingDTO dto = new DataMappingDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setModelName(data.getModelName());
        dto.setName(data.getName());
        dto.setDatabaseId(data.getDatabaseId());
        dto.setTableId(data.getTableId());
        dto.setFiledId(data.getFiledId());
        dto.setCondition(data.getCondition());
        dto.setSysCode(data.getSysCode());
        dto.setFields(data.getFields());
        dto.setType(data.getType());
        dto.setNote(data.getNote());
        dto.setSql(data.getSql());
        dto.setHasChildren(data.getHasChildren());
        dto.setSort(data.getSort());
        dto.setPath(data.getPath());

        return dto;
    }

    public static List<DataMappingDTO> newInstance(List<DataMapping> data) {
        return data.stream().map(DataMappingFactory::newInstance).collect(Collectors.toList());
    }

}
