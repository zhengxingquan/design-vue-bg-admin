package com.quan.core.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.DataFieldPropertyDTO;
import com.quan.core.dto.DataFieldPropertyPageQueryDTO;
import com.quan.core.dto.DataFieldPropertyQueryDTO;
import com.quan.core.dto.create.DataFieldPropertyCreateDTO;
import com.quan.core.dto.update.DataFieldPropertyUpdateDTO;
import com.quan.core.model.DataFieldProperty;
import com.quan.core.request.DataFieldPropertyPageQueryRequest;
import com.quan.core.request.DataFieldPropertyQueryRequest;
import com.quan.core.request.create.DataFieldPropertyCreateRequest;
import com.quan.core.request.update.DataFieldPropertyUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统字段属性表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:19:31
 */
public final class DataFieldPropertyFactory {


    /***
     * 新建
     *
     * @return
     */
    public static DataFieldPropertyCreateDTO newInstance(IUidGenerator uidGenerator, DataFieldPropertyCreateRequest req) {
        DataFieldPropertyCreateDTO createData = new DataFieldPropertyCreateDTO();
        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setName(req.getName());
        createData.setCode(req.getCode());
        createData.setSysCode(req.getSysCode());
        createData.setDbFieldType(req.getDbFieldType());
        createData.setNote(req.getNote());
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
    public static DataFieldPropertyUpdateDTO newInstance(DataFieldPropertyUpdateRequest req) {
        DataFieldPropertyUpdateDTO updateData = new DataFieldPropertyUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setName(req.getName());
        updateData.setCode(req.getCode());
        updateData.setSysCode(req.getSysCode());
        updateData.setDbFieldType(req.getDbFieldType());
        updateData.setNote(req.getNote());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<DataFieldPropertyCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<DataFieldPropertyCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static DataFieldPropertyQueryDTO newInstance(DataFieldPropertyQueryRequest req) {
        DataFieldPropertyQueryDTO queryData = new DataFieldPropertyQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static DataFieldPropertyPageQueryDTO newInstance(DataFieldPropertyPageQueryRequest req) {
        DataFieldPropertyPageQueryDTO query = new DataFieldPropertyPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static DataFieldPropertyDTO newInstance(DataFieldProperty data) {
        DataFieldPropertyDTO dto = new DataFieldPropertyDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setName(data.getName());
        dto.setCode(data.getCode());
        dto.setSysCode(data.getSysCode());
        dto.setDbFieldType(data.getDbFieldType());
        dto.setNote(data.getNote());
        dto.setPath(data.getPath());
        dto.setSort(data.getSort());
        dto.setHasChildren(data.getHasChildren());

        return dto;
    }

    public static List<DataFieldPropertyDTO> newInstance(List<DataFieldProperty> data) {
        return data.stream().map(DataFieldPropertyFactory::newInstance).collect(Collectors.toList());
    }

}
