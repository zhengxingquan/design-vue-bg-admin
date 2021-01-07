package com.quan.core.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.DataTableDTO;
import com.quan.core.dto.DataTablePageQueryDTO;
import com.quan.core.dto.DataTableQueryDTO;
import com.quan.core.dto.create.DataTableCreateDTO;
import com.quan.core.dto.update.DataTableUpdateDTO;
import com.quan.core.model.DataTable;
import com.quan.core.request.DataTablePageQueryRequest;
import com.quan.core.request.DataTableQueryRequest;
import com.quan.core.request.create.DataTableCreateRequest;
import com.quan.core.request.update.DataTableUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统数据表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:05:24
 */
public final class DataTableFactory {


    /***
     * 新建
     *
     * @return
     */
    public static DataTableCreateDTO newInstance(IUidGenerator uidGenerator, DataTableCreateRequest req) {
        DataTableCreateDTO createData = new DataTableCreateDTO();
        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setName(req.getName());
        createData.setTableType(req.getTableType());
        createData.setTableCode(req.getTableCode());
        createData.setNote(req.getNote());
        createData.setTooltip(req.getTooltip());
        createData.setCopyTableId(req.getCopyTableId());
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
    public static DataTableUpdateDTO newInstance(DataTableUpdateRequest req) {
        DataTableUpdateDTO updateData = new DataTableUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setName(req.getName());
        updateData.setPhysicalName(req.getPhysicalName());
        updateData.setTableType(req.getTableType());
        updateData.setTableCode(req.getTableCode());
        updateData.setNote(req.getNote());
        updateData.setTooltip(req.getTooltip());
        updateData.setCopyTableId(req.getCopyTableId());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<DataTableCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<DataTableCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static DataTableQueryDTO newInstance(DataTableQueryRequest req) {
        DataTableQueryDTO queryData = new DataTableQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static DataTablePageQueryDTO newInstance(DataTablePageQueryRequest req) {
        DataTablePageQueryDTO query = new DataTablePageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static DataTableDTO newInstance(DataTable data) {
        DataTableDTO dto = new DataTableDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setName(data.getName());
        dto.setPhysicalName(data.getPhysicalName());
        dto.setTableType(data.getTableType());
        dto.setTableCode(data.getTableCode());
        dto.setNote(data.getNote());
        dto.setTooltip(data.getTooltip());
        dto.setCopyTableId(data.getCopyTableId());
        dto.setPath(data.getPath());
        dto.setHasChildren(data.getHasChildren());
        dto.setSort(data.getSort());

        return dto;
    }

    public static List<DataTableDTO> newInstance(List<DataTable> data) {
        return data.stream().map(DataTableFactory::newInstance).collect(Collectors.toList());
    }

}
