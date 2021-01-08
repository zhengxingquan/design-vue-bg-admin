package com.quan.core.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.UserGroupRoleGroupDTO;
import com.quan.core.dto.UserGroupRoleGroupPageQueryDTO;
import com.quan.core.dto.UserGroupRoleGroupQueryDTO;
import com.quan.core.dto.create.UserGroupRoleGroupCreateDTO;
import com.quan.core.dto.update.UserGroupRoleGroupUpdateDTO;
import com.quan.core.model.UserGroupRoleGroup;
import com.quan.core.request.UserGroupRoleGroupPageQueryRequest;
import com.quan.core.request.UserGroupRoleGroupQueryRequest;
import com.quan.core.request.create.UserGroupRoleGroupCreateRequest;
import com.quan.core.request.update.UserGroupRoleGroupUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户组与角色组 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */
public final class UserGroupRoleGroupFactory {


    /***
     * 新建
     *
     * @return
     */
    public static UserGroupRoleGroupCreateDTO newInstance(UserGroupRoleGroupCreateRequest req) {
        UserGroupRoleGroupCreateDTO createData = new UserGroupRoleGroupCreateDTO();
        createData.setUserGroupId(req.getUserGroupId());
        createData.setRoleGroupId(req.getRoleGroupId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static UserGroupRoleGroupUpdateDTO newInstance(UserGroupRoleGroupUpdateRequest req) {
        UserGroupRoleGroupUpdateDTO updateData = new UserGroupRoleGroupUpdateDTO();
        updateData.setUserGroupId(req.getUserGroupId());
        updateData.setRoleGroupId(req.getRoleGroupId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<UserGroupRoleGroupCreateDTO> newBatchInstance(List<UserGroupRoleGroupCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(UserGroupRoleGroupFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static UserGroupRoleGroupQueryDTO newInstance(UserGroupRoleGroupQueryRequest req) {
        UserGroupRoleGroupQueryDTO queryData = new UserGroupRoleGroupQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static UserGroupRoleGroupPageQueryDTO newInstance(UserGroupRoleGroupPageQueryRequest req) {
        UserGroupRoleGroupPageQueryDTO query = new UserGroupRoleGroupPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static UserGroupRoleGroupDTO newInstance(UserGroupRoleGroup data) {
        UserGroupRoleGroupDTO dto = new UserGroupRoleGroupDTO();
        dto.setUserGroupId(data.getUserGroupId());
        dto.setRoleGroupId(data.getRoleGroupId());

        return dto;
    }

    public static List<UserGroupRoleGroupDTO> newInstance(List<UserGroupRoleGroup> data) {
        return data.stream().map(UserGroupRoleGroupFactory::newInstance).collect(Collectors.toList());
    }

}
