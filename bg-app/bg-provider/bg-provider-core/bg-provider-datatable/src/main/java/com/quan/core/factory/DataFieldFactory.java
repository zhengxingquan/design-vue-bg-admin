package com.quan.core.factory;

import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.dto.DataFieldDTO;
import com.quan.core.dto.DataFieldPageQueryDTO;
import com.quan.core.dto.DataFieldQueryDTO;
import com.quan.core.dto.create.DataFieldCreateDTO;
import com.quan.core.dto.update.DataFieldUpdateDTO;
import com.quan.core.model.DataField;
import com.quan.core.controller.request.DataFieldPageQueryRequest;
import com.quan.core.controller.request.DataFieldQueryRequest;
import com.quan.core.controller.request.create.DataFieldCreateRequest;
import com.quan.core.controller.request.update.DataFieldUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统字段表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:29:07
 */
public final class DataFieldFactory {


    /***
     * 新建
     *
     * @return
     */
    public static DataFieldCreateDTO newInstance(IUidGenerator uidGenerator, DataFieldCreateRequest req) {
        DataFieldCreateDTO createData = new DataFieldCreateDTO();
        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setName(req.getName());
        createData.setDataFieldCode(req.getDataFieldCode());
        createData.setEnumDataFieldId(req.getEnumDataFieldId());
        createData.setEnumDependFieldId(req.getEnumDependFieldId());
        createData.setAssociationId(req.getAssociationId());
        createData.setEnumId(req.getEnumId());
        createData.setDataFieldProperty(req.getDataFieldProperty());
        createData.setDataFieldLength(req.getDataFieldLength());
        createData.setRequiredDataField(req.getRequiredDataField());
        createData.setDataFieldTypeId(req.getDataFieldTypeId());
        createData.setDecimalLength(req.getDecimalLength());
        createData.setRegexExpression(req.getRegexExpression());
        createData.setExpressionId(req.getExpressionId());
        createData.setTooltip(req.getTooltip());
        createData.setNote(req.getNote());
        createData.setIndexAble(req.getIndexAble());
        createData.setDataFieldState(req.getDataFieldState());
        createData.setCreateTime(new Date());
        createData.setCreateUserId(0L);
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static DataFieldUpdateDTO newInstance(DataFieldUpdateRequest req) {
        DataFieldUpdateDTO updateData = new DataFieldUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setName(req.getName());
        updateData.setDataFieldCode(req.getDataFieldCode());
        updateData.setPhysicalName(req.getPhysicalName());
        updateData.setEnumDataFieldId(req.getEnumDataFieldId());
        updateData.setEnumDependFieldId(req.getEnumDependFieldId());
        updateData.setAssociationId(req.getAssociationId());
        updateData.setEnumId(req.getEnumId());
        updateData.setDataFieldProperty(req.getDataFieldProperty());
        updateData.setDataFieldLength(req.getDataFieldLength());
        updateData.setRequiredDataField(req.getRequiredDataField());
        updateData.setDataFieldTypeId(req.getDataFieldTypeId());
        updateData.setDecimalLength(req.getDecimalLength());
        updateData.setRegexExpression(req.getRegexExpression());
        updateData.setExpressionId(req.getExpressionId());
        updateData.setTooltip(req.getTooltip());
        updateData.setNote(req.getNote());
        updateData.setIndexAble(req.getIndexAble());
        updateData.setDataFieldState(req.getDataFieldState());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<DataFieldCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<DataFieldCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static DataFieldQueryDTO newInstance(DataFieldQueryRequest req) {
        DataFieldQueryDTO queryData = new DataFieldQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static DataFieldPageQueryDTO newInstance(DataFieldPageQueryRequest req) {
        DataFieldPageQueryDTO query = new DataFieldPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static DataFieldDTO newInstance(DataField data) {
        DataFieldDTO dto = new DataFieldDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setName(data.getName());
        dto.setDataFieldCode(data.getDataFieldCode());
        dto.setPhysicalName(data.getPhysicalName());
        dto.setEnumDataFieldId(data.getEnumDataFieldId());
        dto.setEnumDependFieldId(data.getEnumDependFieldId());
        dto.setAssociationId(data.getAssociationId());
        dto.setEnumId(data.getEnumId());
        dto.setDataFieldProperty(data.getDataFieldProperty());
        dto.setDataFieldLength(data.getDataFieldLength());
        dto.setRequiredDataField(data.getRequiredDataField());
        dto.setDataFieldTypeId(data.getDataFieldTypeId());
        dto.setDecimalLength(data.getDecimalLength());
        dto.setRegexExpression(data.getRegexExpression());
        dto.setExpressionId(data.getExpressionId());
        dto.setTooltip(data.getTooltip());
        dto.setNote(data.getNote());
        dto.setIndexAble(data.getIndexAble());
        dto.setDataFieldState(data.getDataFieldState());
        dto.setSort(data.getSort());
        dto.setPath(data.getPath());

        return dto;
    }

    public static List<DataFieldDTO> newInstance(List<DataField> data) {
        return data.stream().map(DataFieldFactory::newInstance).collect(Collectors.toList());
    }

}
