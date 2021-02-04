package com.quan.core.factory;

import com.quan.core.dto.RoleMenuDTO;
import com.quan.core.dto.RoleMenuPageQueryDTO;
import com.quan.core.dto.RoleMenuQueryDTO;
import com.quan.core.dto.create.RoleMenuCreateDTO;
import com.quan.core.dto.update.RoleMenuUpdateDTO;
import com.quan.core.model.RoleMenu;
import com.quan.core.controller.request.RoleMenuPageQueryRequest;
import com.quan.core.controller.request.RoleMenuQueryRequest;
import com.quan.core.controller.request.create.RoleMenuCreateRequest;
import com.quan.core.controller.request.update.RoleMenuUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */
public final class RoleMenuFactory {


    /***
     * 新建
     *
     * @return
     */
    public static RoleMenuCreateDTO newInstance(RoleMenuCreateRequest req) {
        RoleMenuCreateDTO createData = new RoleMenuCreateDTO();
        createData.setRoleId(req.getRoleId());
        createData.setMenuId(req.getMenuId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static RoleMenuUpdateDTO newInstance(RoleMenuUpdateRequest req) {
        RoleMenuUpdateDTO updateData = new RoleMenuUpdateDTO();
        updateData.setRoleId(req.getRoleId());
        updateData.setMenuId(req.getMenuId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<RoleMenuCreateDTO> newBatchInstance(List<RoleMenuCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(RoleMenuFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static RoleMenuQueryDTO newInstance(RoleMenuQueryRequest req) {
        RoleMenuQueryDTO queryData = new RoleMenuQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static RoleMenuPageQueryDTO newInstance(RoleMenuPageQueryRequest req) {
        RoleMenuPageQueryDTO query = new RoleMenuPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static RoleMenuDTO newInstance(RoleMenu data) {
        RoleMenuDTO dto = new RoleMenuDTO();
        dto.setRoleId(data.getRoleId());
        dto.setMenuId(data.getMenuId());

        return dto;
    }

    public static List<RoleMenuDTO> newInstance(List<RoleMenu> data) {
        return data.stream().map(RoleMenuFactory::newInstance).collect(Collectors.toList());
    }

}
