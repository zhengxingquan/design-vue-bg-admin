package com.quan.core.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.RoleGroupMenuGroupDTO;
import com.quan.core.dto.RoleGroupMenuGroupPageQueryDTO;
import com.quan.core.dto.RoleGroupMenuGroupQueryDTO;
import com.quan.core.dto.create.RoleGroupMenuGroupCreateDTO;
import com.quan.core.dto.update.RoleGroupMenuGroupUpdateDTO;
import com.quan.core.model.RoleGroupMenuGroup;
import com.quan.core.request.RoleGroupMenuGroupPageQueryRequest;
import com.quan.core.request.RoleGroupMenuGroupQueryRequest;
import com.quan.core.request.create.RoleGroupMenuGroupCreateRequest;
import com.quan.core.request.update.RoleGroupMenuGroupUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色组与菜单组 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:58:57
 */
public final class RoleGroupMenuGroupFactory {


    /***
     * 新建
     *
     * @return
     */
    public static RoleGroupMenuGroupCreateDTO newInstance(RoleGroupMenuGroupCreateRequest req) {
        RoleGroupMenuGroupCreateDTO createData = new RoleGroupMenuGroupCreateDTO();
        createData.setRoleGroupId(req.getRoleGroupId());
        createData.setMenuGroupId(req.getMenuGroupId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static RoleGroupMenuGroupUpdateDTO newInstance(RoleGroupMenuGroupUpdateRequest req) {
        RoleGroupMenuGroupUpdateDTO updateData = new RoleGroupMenuGroupUpdateDTO();
        updateData.setRoleGroupId(req.getRoleGroupId());
        updateData.setMenuGroupId(req.getMenuGroupId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<RoleGroupMenuGroupCreateDTO> newBatchInstance(List<RoleGroupMenuGroupCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(RoleGroupMenuGroupFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static RoleGroupMenuGroupQueryDTO newInstance(RoleGroupMenuGroupQueryRequest req) {
        RoleGroupMenuGroupQueryDTO queryData = new RoleGroupMenuGroupQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static RoleGroupMenuGroupPageQueryDTO newInstance(RoleGroupMenuGroupPageQueryRequest req) {
        RoleGroupMenuGroupPageQueryDTO query = new RoleGroupMenuGroupPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static RoleGroupMenuGroupDTO newInstance(RoleGroupMenuGroup data) {
        RoleGroupMenuGroupDTO dto = new RoleGroupMenuGroupDTO();
        dto.setRoleGroupId(data.getRoleGroupId());
        dto.setMenuGroupId(data.getMenuGroupId());

        return dto;
    }

    public static List<RoleGroupMenuGroupDTO> newInstance(List<RoleGroupMenuGroup> data) {
        return data.stream().map(RoleGroupMenuGroupFactory::newInstance).collect(Collectors.toList());
    }

}
