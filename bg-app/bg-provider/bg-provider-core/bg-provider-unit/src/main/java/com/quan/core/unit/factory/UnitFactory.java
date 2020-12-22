package com.quan.core.unit.factory;

import com.quan.core.unit.dto.UnitDTO;
import com.quan.core.unit.model.Unit;
import com.quan.core.unit.dto.UnitPageQueryDTO;
import com.quan.core.unit.dto.UnitQueryDTO;
import com.quan.core.unit.dto.create.UnitCreateDTO;
import com.quan.core.unit.dto.update.UnitUpdateDTO;
import com.quan.core.unit.request.UnitQueryRequest;
import com.quan.core.unit.request.create.UnitCreateRequest;
import com.quan.core.unit.request.update.UnitUpdateRequest;
import com.quan.core.unit.request.UnitPageQueryRequest;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统单位表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-22 19:04:56
 */
public final class UnitFactory {


    /***
     * 新建
     *
     * @return
     */
    public static UnitCreateDTO newInstance(UnitCreateRequest req) {
            UnitCreateDTO createData = new UnitCreateDTO();

                                                        createData.setParentId(req.getParentId());
                                                createData.setName(req.getName());
                                                createData.setAliasName(req.getAliasName());
                                                createData.setUnitCode(req.getUnitCode());
                                                createData.setNote(req.getNote());
                                                createData.setField1(req.getField1());
                                                createData.setField2(req.getField2());
                                                createData.setField3(req.getField3());
                                                createData.setSort(req.getSort());
                                                createData.setDisabled(req.getDisabled());
                                                createData.setHasChildren(req.getHasChildren());
                                                createData.setLogo(req.getLogo());
                                                                    createData.setCreateUserId(req.getCreateUserId());
                                                                                        createData.setCreateTime(new Date());
        createData.setCreateUserId(0L);
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static UnitUpdateDTO newInstance(UnitUpdateRequest req) {
            UnitUpdateDTO updateData = new UnitUpdateDTO();
                                    updateData.setId(req.getId());
                                                updateData.setParentId(req.getParentId());
                                                updateData.setName(req.getName());
                                                updateData.setAliasName(req.getAliasName());
                                                updateData.setUnitCode(req.getUnitCode());
                                                updateData.setNote(req.getNote());
                                                updateData.setField1(req.getField1());
                                                updateData.setField2(req.getField2());
                                                updateData.setField3(req.getField3());
                                                updateData.setSort(req.getSort());
                                                updateData.setDisabled(req.getDisabled());
                                                updateData.setHasChildren(req.getHasChildren());
                                                updateData.setLogo(req.getLogo());
                                                                    updateData.setCreateUserId(req.getCreateUserId());
                                                                                        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<UnitCreateDTO> newBatchInstance(List<UnitCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(UnitFactory::newInstance).collect(Collectors.toList());
    }

    /***
    * 转换查询列表 req 到 DTO
    */
    public static UnitQueryDTO newInstance(UnitQueryRequest req) {
            UnitQueryDTO queryData = new UnitQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static UnitPageQueryDTO newInstance(UnitPageQueryRequest req) {
            UnitPageQueryDTO query = new UnitPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static UnitDTO newInstance(Unit data) {
            UnitDTO dto = new UnitDTO();
                                    dto.setId(data.getId());
                                                dto.setParentId(data.getParentId());
                                                dto.setName(data.getName());
                                                dto.setAliasName(data.getAliasName());
                                                dto.setUnitCode(data.getUnitCode());
                                                dto.setNote(data.getNote());
                                                dto.setField1(data.getField1());
                                                dto.setField2(data.getField2());
                                                dto.setField3(data.getField3());
                                                dto.setSort(data.getSort());
                                                dto.setDisabled(data.getDisabled());
                                                dto.setHasChildren(data.getHasChildren());
                                                dto.setLogo(data.getLogo());
                                                                    dto.setCreateUserId(data.getCreateUserId());
                                                                                
        return dto;
    }

    public static List<UnitDTO> newInstance(List<Unit> data) {
        return data.stream().map(UnitFactory::newInstance).collect(Collectors.toList());
    }

}
