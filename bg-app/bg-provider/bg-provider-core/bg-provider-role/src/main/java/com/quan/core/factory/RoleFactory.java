package com.quan.core.factory;

import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.dto.RoleDTO;
import com.quan.core.dto.RolePageQueryDTO;
import com.quan.core.dto.RoleQueryDTO;
import com.quan.core.dto.create.RoleCreateDTO;
import com.quan.core.dto.update.RoleUpdateDTO;
import com.quan.core.model.Role;
import com.quan.core.controller.request.RolePageQueryRequest;
import com.quan.core.controller.request.RoleQueryRequest;
import com.quan.core.controller.request.create.RoleCreateRequest;
import com.quan.core.controller.request.update.RoleUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统角色表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */
public final class RoleFactory {

    /***
     * 新建
     *
     * @return
     */
    public static RoleCreateDTO newInstance(IUidGenerator uidGenerator, RoleCreateRequest req) {
        RoleCreateDTO createData = new RoleCreateDTO();

        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setName(req.getName());
        createData.setCode(req.getCode());
        createData.setAliasName(req.getAliasName());
        createData.setNote(req.getNote());
        createData.setCreateTime(new Date());
        createData.setCreateUserId(0L);
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static RoleUpdateDTO newInstance(RoleUpdateRequest req) {
        RoleUpdateDTO updateData = new RoleUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setName(req.getName());
        updateData.setCode(req.getCode());
        updateData.setAliasName(req.getAliasName());
        updateData.setNote(req.getNote());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<RoleCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<RoleCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static RoleQueryDTO newInstance(RoleQueryRequest req) {
        RoleQueryDTO queryData = new RoleQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static RolePageQueryDTO newInstance(RolePageQueryRequest req) {
        RolePageQueryDTO query = new RolePageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static RoleDTO newInstance(Role data) {
        RoleDTO dto = new RoleDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setName(data.getName());
        dto.setCode(data.getCode());
        dto.setAliasName(data.getAliasName());
        dto.setHasChildren(data.getHasChildren());
        dto.setPath(data.getPath());
        dto.setNote(data.getNote());
        dto.setSort(data.getSort());

        return dto;
    }

    public static List<RoleDTO> newInstance(List<Role> data) {
        return data.stream().map(RoleFactory::newInstance).collect(Collectors.toList());
    }

}
