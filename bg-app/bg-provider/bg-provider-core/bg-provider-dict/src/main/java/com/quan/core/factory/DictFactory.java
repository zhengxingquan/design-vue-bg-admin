package com.quan.core.factory;

import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.controller.request.create.DictCreateRequest;
import com.quan.core.controller.request.update.DictUpdateRequest;
import com.quan.core.dto.DictDTO;
import com.quan.core.dto.DictPageQueryDTO;
import com.quan.core.dto.DictQueryDTO;
import com.quan.core.dto.create.DictCreateDTO;
import com.quan.core.dto.update.DictUpdateDTO;
import com.quan.core.model.Dict;
import com.quan.core.controller.request.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统字典表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */
public final class DictFactory {


    /***
     * 新建
     *
     * @return
     */
    public static DictCreateDTO newInstance(IUidGenerator uidGenerator, DictCreateRequest req) {
        DictCreateDTO createData = new DictCreateDTO();

        createData.setParentId(req.getParentId());
        createData.setId(uidGenerator.uid());
        createData.setName(req.getName());
        createData.setCode(req.getCode());
        createData.setSysCode(req.getSysCode());
        createData.setField1(req.getField1());
        createData.setField2(req.getField2());
        createData.setField3(req.getField3());
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
    public static DictUpdateDTO newInstance(DictUpdateRequest req) {
        DictUpdateDTO updateData = new DictUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setName(req.getName());
        updateData.setCode(req.getCode());
        updateData.setSysCode(req.getSysCode());
        updateData.setField1(req.getField1());
        updateData.setField2(req.getField2());
        updateData.setField3(req.getField3());
        updateData.setNote(req.getNote());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<DictCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<DictCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }


        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static DictQueryDTO newInstance(DictQueryRequest req) {
        DictQueryDTO queryData = new DictQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static DictPageQueryDTO newInstance(DictPageQueryRequest req) {
        DictPageQueryDTO query = new DictPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static DictDTO newInstance(Dict data) {
        DictDTO dto = new DictDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setPath(data.getPath());
        dto.setName(data.getName());
        dto.setCode(data.getCode());
        dto.setSysCode(data.getSysCode());
        dto.setHasChildren(data.getHasChildren());
        dto.setField1(data.getField1());
        dto.setField2(data.getField2());
        dto.setField3(data.getField3());
        dto.setNote(data.getNote());
        dto.setSort(data.getSort());

        return dto;
    }

    public static List<DictDTO> newInstance(List<Dict> data) {
        return data.stream().map(DictFactory::newInstance).collect(Collectors.toList());
    }

}
