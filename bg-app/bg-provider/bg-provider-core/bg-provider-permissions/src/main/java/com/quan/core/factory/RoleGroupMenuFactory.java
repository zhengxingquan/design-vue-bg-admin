package com.quan.core.factory;

import com.quan.core.dto.RoleGroupMenuDTO;
import com.quan.core.dto.RoleGroupMenuPageQueryDTO;
import com.quan.core.dto.RoleGroupMenuQueryDTO;
import com.quan.core.dto.create.RoleGroupMenuCreateDTO;
import com.quan.core.dto.update.RoleGroupMenuUpdateDTO;
import com.quan.core.model.RoleGroupMenu;
import com.quan.core.request.RoleGroupMenuPageQueryRequest;
import com.quan.core.request.RoleGroupMenuQueryRequest;
import com.quan.core.request.create.RoleGroupMenuCreateRequest;
import com.quan.core.request.update.RoleGroupMenuUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色组与菜单 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:43:42
 */
public final class RoleGroupMenuFactory {


    /***
     * 新建
     *
     * @return
     */
    public static RoleGroupMenuCreateDTO newInstance(RoleGroupMenuCreateRequest req) {
        RoleGroupMenuCreateDTO createData = new RoleGroupMenuCreateDTO();
        createData.setRoleGroupId(req.getRoleGroupId());
        createData.setMenuId(req.getMenuId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static RoleGroupMenuUpdateDTO newInstance(RoleGroupMenuUpdateRequest req) {
        RoleGroupMenuUpdateDTO updateData = new RoleGroupMenuUpdateDTO();
        updateData.setRoleGroupId(req.getRoleGroupId());
        updateData.setMenuId(req.getMenuId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<RoleGroupMenuCreateDTO> newBatchInstance(List<RoleGroupMenuCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(RoleGroupMenuFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static RoleGroupMenuQueryDTO newInstance(RoleGroupMenuQueryRequest req) {
        RoleGroupMenuQueryDTO queryData = new RoleGroupMenuQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static RoleGroupMenuPageQueryDTO newInstance(RoleGroupMenuPageQueryRequest req) {
        RoleGroupMenuPageQueryDTO query = new RoleGroupMenuPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static RoleGroupMenuDTO newInstance(RoleGroupMenu data) {
        RoleGroupMenuDTO dto = new RoleGroupMenuDTO();
        dto.setRoleGroupId(data.getRoleGroupId());
        dto.setMenuId(data.getMenuId());

        return dto;
    }

    public static List<RoleGroupMenuDTO> newInstance(List<RoleGroupMenu> data) {
        return data.stream().map(RoleGroupMenuFactory::newInstance).collect(Collectors.toList());
    }

}
