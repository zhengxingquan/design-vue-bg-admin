package com.quan.core.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.RoleMenuGroupDTO;
import com.quan.core.dto.RoleMenuGroupPageQueryDTO;
import com.quan.core.dto.RoleMenuGroupQueryDTO;
import com.quan.core.dto.create.RoleMenuGroupCreateDTO;
import com.quan.core.dto.update.RoleMenuGroupUpdateDTO;
import com.quan.core.model.RoleMenuGroup;
import com.quan.core.request.RoleMenuGroupPageQueryRequest;
import com.quan.core.request.RoleMenuGroupQueryRequest;
import com.quan.core.request.create.RoleMenuGroupCreateRequest;
import com.quan.core.request.update.RoleMenuGroupUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色与菜单组 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */
public final class RoleMenuGroupFactory {


    /***
     * 新建
     *
     * @return
     */
    public static RoleMenuGroupCreateDTO newInstance(RoleMenuGroupCreateRequest req) {
        RoleMenuGroupCreateDTO createData = new RoleMenuGroupCreateDTO();
        createData.setRoleId(req.getRoleId());
        createData.setMenuGroupId(req.getMenuGroupId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static RoleMenuGroupUpdateDTO newInstance(RoleMenuGroupUpdateRequest req) {
        RoleMenuGroupUpdateDTO updateData = new RoleMenuGroupUpdateDTO();
        updateData.setRoleId(req.getRoleId());
        updateData.setMenuGroupId(req.getMenuGroupId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<RoleMenuGroupCreateDTO> newBatchInstance(List<RoleMenuGroupCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(RoleMenuGroupFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static RoleMenuGroupQueryDTO newInstance(RoleMenuGroupQueryRequest req) {
        RoleMenuGroupQueryDTO queryData = new RoleMenuGroupQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static RoleMenuGroupPageQueryDTO newInstance(RoleMenuGroupPageQueryRequest req) {
        RoleMenuGroupPageQueryDTO query = new RoleMenuGroupPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static RoleMenuGroupDTO newInstance(RoleMenuGroup data) {
        RoleMenuGroupDTO dto = new RoleMenuGroupDTO();
        dto.setRoleId(data.getRoleId());
        dto.setMenuGroupId(data.getMenuGroupId());

        return dto;
    }

    public static List<RoleMenuGroupDTO> newInstance(List<RoleMenuGroup> data) {
        return data.stream().map(RoleMenuGroupFactory::newInstance).collect(Collectors.toList());
    }

}
