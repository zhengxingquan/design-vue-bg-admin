package com.quan.core.unit.factory;


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
 * @date 2020-12-21 20:03:28
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
     * 新建
     * @author ${author}
     * @email 956607644@qq.com
     * @date 2020-12-21 20:03:28

     * @return
     */
    public static List<UnitCreateDTO> newInstance(List<UnitCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(UnitFactory::newInstance).collect(Collectors.toList());
    }


    public static UnitQueryDTO newInstance(UnitQueryRequest req) {
            UnitQueryDTO queryData = new UnitQueryDTO();

                                                        queryData.setParentId(req.getParentId());
                                                queryData.setName(req.getName());
                                                queryData.setAliasName(req.getAliasName());
                                                queryData.setUnitCode(req.getUnitCode());
                                                queryData.setNote(req.getNote());
                                                queryData.setField1(req.getField1());
                                                queryData.setField2(req.getField2());
                                                queryData.setField3(req.getField3());
                                                queryData.setSort(req.getSort());
                                                queryData.setDisabled(req.getDisabled());
                                                queryData.setHasChildren(req.getHasChildren());
                                                queryData.setLogo(req.getLogo());
                                                                    queryData.setCreateUserId(req.getCreateUserId());
                                                                                
        return queryData;
    }

    public static UnitPageQueryDTO newInstance(UnitPageQueryRequest req) {
            UnitPageQueryDTO query = new UnitPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());
                                                        query.setParentId(req.getParentId());
                                                query.setName(req.getName());
                                                query.setAliasName(req.getAliasName());
                                                query.setUnitCode(req.getUnitCode());
                                                query.setNote(req.getNote());
                                                query.setField1(req.getField1());
                                                query.setField2(req.getField2());
                                                query.setField3(req.getField3());
                                                query.setSort(req.getSort());
                                                query.setDisabled(req.getDisabled());
                                                query.setHasChildren(req.getHasChildren());
                                                query.setLogo(req.getLogo());
                                                                    query.setCreateUserId(req.getCreateUserId());
                                                                                
        return query;
    }


}
