package com.quan.core.factory;

import com.quan.core.dto.RoleGroupDetailsDTO;
import com.quan.core.dto.RoleGroupDetailsPageQueryDTO;
import com.quan.core.dto.RoleGroupDetailsQueryDTO;
import com.quan.core.dto.create.RoleGroupDetailsCreateDTO;
import com.quan.core.dto.update.RoleGroupDetailsUpdateDTO;
import com.quan.core.model.RoleGroupDetails;
import com.quan.core.request.RoleGroupDetailsPageQueryRequest;
import com.quan.core.request.RoleGroupDetailsQueryRequest;
import com.quan.core.request.create.RoleGroupDetailsCreateRequest;
import com.quan.core.request.update.RoleGroupDetailsUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统角色分组与角色对应表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:21:41
 */
public final class RoleGroupDetailsFactory {


    /***
     * 新建
     *
     * @return
     */
    public static RoleGroupDetailsCreateDTO newInstance(RoleGroupDetailsCreateRequest req) {
        RoleGroupDetailsCreateDTO createData = new RoleGroupDetailsCreateDTO();
        createData.setRoleId(req.getRoleId());
        createData.setRoleGroupId(req.getRoleGroupId());
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static RoleGroupDetailsUpdateDTO newInstance(RoleGroupDetailsUpdateRequest req) {
        RoleGroupDetailsUpdateDTO updateData = new RoleGroupDetailsUpdateDTO();
        updateData.setRoleGroupId(req.getRoleGroupId());
        updateData.setRoleId(req.getRoleId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<RoleGroupDetailsCreateDTO> newBatchInstance(List<RoleGroupDetailsCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(RoleGroupDetailsFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static RoleGroupDetailsQueryDTO newInstance(RoleGroupDetailsQueryRequest req) {
        RoleGroupDetailsQueryDTO queryData = new RoleGroupDetailsQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static RoleGroupDetailsPageQueryDTO newInstance(RoleGroupDetailsPageQueryRequest req) {
        RoleGroupDetailsPageQueryDTO query = new RoleGroupDetailsPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static RoleGroupDetailsDTO newInstance(RoleGroupDetails data) {
        RoleGroupDetailsDTO dto = new RoleGroupDetailsDTO();
        dto.setRoleGroupId(data.getRoleGroupId());
        dto.setRoleId(data.getRoleId());

        return dto;
    }

    public static List<RoleGroupDetailsDTO> newInstance(List<RoleGroupDetails> data) {
        return data.stream().map(RoleGroupDetailsFactory::newInstance).collect(Collectors.toList());
    }

}
