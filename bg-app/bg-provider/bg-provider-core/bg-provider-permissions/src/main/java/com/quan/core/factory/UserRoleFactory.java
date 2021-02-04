package com.quan.core.factory;

import com.quan.core.dto.UserRoleDTO;
import com.quan.core.dto.UserRolePageQueryDTO;
import com.quan.core.dto.UserRoleQueryDTO;
import com.quan.core.dto.create.UserRoleCreateDTO;
import com.quan.core.dto.update.UserRoleUpdateDTO;
import com.quan.core.model.UserRole;
import com.quan.core.controller.request.UserRolePageQueryRequest;
import com.quan.core.controller.request.UserRoleQueryRequest;
import com.quan.core.controller.request.create.UserRoleCreateRequest;
import com.quan.core.controller.request.update.UserRoleUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户与角色 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */
public final class UserRoleFactory {


    /***
     * 新建
     *
     * @return
     */
    public static UserRoleCreateDTO newInstance(UserRoleCreateRequest req) {
        UserRoleCreateDTO createData = new UserRoleCreateDTO();
        createData.setUserId(req.getUserId());
        createData.setRoleId(req.getRoleId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static UserRoleUpdateDTO newInstance(UserRoleUpdateRequest req) {
        UserRoleUpdateDTO updateData = new UserRoleUpdateDTO();
        updateData.setUserId(req.getUserId());
        updateData.setRoleId(req.getRoleId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<UserRoleCreateDTO> newBatchInstance(List<UserRoleCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(UserRoleFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static UserRoleQueryDTO newInstance(UserRoleQueryRequest req) {
        UserRoleQueryDTO queryData = new UserRoleQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static UserRolePageQueryDTO newInstance(UserRolePageQueryRequest req) {
        UserRolePageQueryDTO query = new UserRolePageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static UserRoleDTO newInstance(UserRole data) {
        UserRoleDTO dto = new UserRoleDTO();
        dto.setUserId(data.getUserId());
        dto.setRoleId(data.getRoleId());

        return dto;
    }

    public static List<UserRoleDTO> newInstance(List<UserRole> data) {
        return data.stream().map(UserRoleFactory::newInstance).collect(Collectors.toList());
    }

}
