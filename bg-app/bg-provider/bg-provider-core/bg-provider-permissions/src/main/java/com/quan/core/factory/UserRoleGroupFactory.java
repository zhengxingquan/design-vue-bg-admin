package com.quan.core.factory;

import com.quan.core.dto.UserRoleGroupDTO;
import com.quan.core.dto.UserRoleGroupPageQueryDTO;
import com.quan.core.dto.UserRoleGroupQueryDTO;
import com.quan.core.dto.create.UserRoleGroupCreateDTO;
import com.quan.core.dto.update.UserRoleGroupUpdateDTO;
import com.quan.core.model.UserRoleGroup;
import com.quan.core.controller.request.UserRoleGroupPageQueryRequest;
import com.quan.core.controller.request.UserRoleGroupQueryRequest;
import com.quan.core.controller.request.create.UserRoleGroupCreateRequest;
import com.quan.core.controller.request.update.UserRoleGroupUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户与角色组 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */
public final class UserRoleGroupFactory {


    /***
     * 新建
     *
     * @return
     */
    public static UserRoleGroupCreateDTO newInstance(UserRoleGroupCreateRequest req) {
        UserRoleGroupCreateDTO createData = new UserRoleGroupCreateDTO();
        createData.setUserId(req.getUserId());
        createData.setRoleGroupId(req.getRoleGroupId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static UserRoleGroupUpdateDTO newInstance(UserRoleGroupUpdateRequest req) {
        UserRoleGroupUpdateDTO updateData = new UserRoleGroupUpdateDTO();
        updateData.setUserId(req.getUserId());
        updateData.setRoleGroupId(req.getRoleGroupId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<UserRoleGroupCreateDTO> newBatchInstance(List<UserRoleGroupCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(UserRoleGroupFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static UserRoleGroupQueryDTO newInstance(UserRoleGroupQueryRequest req) {
        UserRoleGroupQueryDTO queryData = new UserRoleGroupQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static UserRoleGroupPageQueryDTO newInstance(UserRoleGroupPageQueryRequest req) {
        UserRoleGroupPageQueryDTO query = new UserRoleGroupPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static UserRoleGroupDTO newInstance(UserRoleGroup data) {
        UserRoleGroupDTO dto = new UserRoleGroupDTO();
        dto.setUserId(data.getUserId());
        dto.setRoleGroupId(data.getRoleGroupId());

        return dto;
    }

    public static List<UserRoleGroupDTO> newInstance(List<UserRoleGroup> data) {
        return data.stream().map(UserRoleGroupFactory::newInstance).collect(Collectors.toList());
    }

}
