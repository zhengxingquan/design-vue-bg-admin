package com.quan.core.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.create.RoleGroupCreateDTO;
import com.quan.core.dto.update.RoleGroupUpdateDTO;
import com.quan.core.controller.request.RoleGroupPageQueryRequest;
import com.quan.core.controller.request.RoleGroupQueryRequest;
import com.quan.core.controller.request.create.RoleGroupCreateRequest;
import com.quan.core.controller.request.update.RoleGroupUpdateRequest;
import com.quan.core.dto.RoleGroupDTO;
import com.quan.core.dto.RoleGroupPageQueryDTO;
import com.quan.core.dto.RoleGroupQueryDTO;
import com.quan.core.model.RoleGroup;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统角色分组表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:07:02
 */
public final class RoleGroupFactory {


    /***
     * 新建
     *
     * @return
     */
    public static RoleGroupCreateDTO newInstance(IUidGenerator uidGenerator, RoleGroupCreateRequest req) {
        RoleGroupCreateDTO createData = new RoleGroupCreateDTO();
        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setGroupName(req.getGroupName());
        createData.setGroupCode(req.getGroupCode());
        createData.setGroupAliasName(req.getGroupAliasName());
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
    public static RoleGroupUpdateDTO newInstance(RoleGroupUpdateRequest req) {
        RoleGroupUpdateDTO updateData = new RoleGroupUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setGroupName(req.getGroupName());
        updateData.setGroupCode(req.getGroupCode());
        updateData.setGroupAliasName(req.getGroupAliasName());
        updateData.setNote(req.getNote());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<RoleGroupCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<RoleGroupCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static RoleGroupQueryDTO newInstance(RoleGroupQueryRequest req) {
        RoleGroupQueryDTO queryData = new RoleGroupQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static RoleGroupPageQueryDTO newInstance(RoleGroupPageQueryRequest req) {
        RoleGroupPageQueryDTO query = new RoleGroupPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static RoleGroupDTO newInstance(RoleGroup data) {
        RoleGroupDTO dto = new RoleGroupDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setGroupName(data.getGroupName());
        dto.setGroupCode(data.getGroupCode());
        dto.setGroupAliasName(data.getGroupAliasName());
        dto.setHasChildren(data.getHasChildren());
        dto.setPath(data.getPath());
        dto.setNote(data.getNote());
        dto.setSort(data.getSort());

        return dto;
    }

    public static List<RoleGroupDTO> newInstance(List<RoleGroup> data) {
        return data.stream().map(RoleGroupFactory::newInstance).collect(Collectors.toList());
    }

}
