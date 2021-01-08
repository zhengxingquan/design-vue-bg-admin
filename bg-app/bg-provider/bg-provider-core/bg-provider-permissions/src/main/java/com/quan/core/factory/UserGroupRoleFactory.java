package com.quan.core.factory;

import com.quan.core.dto.UserGroupRoleDTO;
import com.quan.core.dto.UserGroupRolePageQueryDTO;
import com.quan.core.dto.UserGroupRoleQueryDTO;
import com.quan.core.dto.create.UserGroupRoleCreateDTO;
import com.quan.core.dto.update.UserGroupRoleUpdateDTO;
import com.quan.core.model.UserGroupRole;
import com.quan.core.request.UserGroupRolePageQueryRequest;
import com.quan.core.request.UserGroupRoleQueryRequest;
import com.quan.core.request.create.UserGroupRoleCreateRequest;
import com.quan.core.request.update.UserGroupRoleUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户组与角色 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */
public final class UserGroupRoleFactory {


    /***
     * 新建
     *
     * @return
     */
    public static UserGroupRoleCreateDTO newInstance(UserGroupRoleCreateRequest req) {
        UserGroupRoleCreateDTO createData = new UserGroupRoleCreateDTO();
        createData.setUserGroupId(req.getUserGroupId());
        createData.setRoleId(req.getRoleId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static UserGroupRoleUpdateDTO newInstance(UserGroupRoleUpdateRequest req) {
        UserGroupRoleUpdateDTO updateData = new UserGroupRoleUpdateDTO();
        updateData.setUserGroupId(req.getUserGroupId());
        updateData.setRoleId(req.getRoleId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<UserGroupRoleCreateDTO> newBatchInstance(List<UserGroupRoleCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(UserGroupRoleFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static UserGroupRoleQueryDTO newInstance(UserGroupRoleQueryRequest req) {
        UserGroupRoleQueryDTO queryData = new UserGroupRoleQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static UserGroupRolePageQueryDTO newInstance(UserGroupRolePageQueryRequest req) {
        UserGroupRolePageQueryDTO query = new UserGroupRolePageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static UserGroupRoleDTO newInstance(UserGroupRole data) {
        UserGroupRoleDTO dto = new UserGroupRoleDTO();
        dto.setUserGroupId(data.getUserGroupId());
        dto.setRoleId(data.getRoleId());

        return dto;
    }

    public static List<UserGroupRoleDTO> newInstance(List<UserGroupRole> data) {
        return data.stream().map(UserGroupRoleFactory::newInstance).collect(Collectors.toList());
    }

}
