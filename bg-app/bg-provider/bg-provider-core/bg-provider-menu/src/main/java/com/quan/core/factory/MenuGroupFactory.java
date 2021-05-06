package com.quan.core.factory;

import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.dto.MenuGroupDTO;
import com.quan.core.dto.MenuGroupPageQueryDTO;
import com.quan.core.dto.MenuGroupQueryDTO;
import com.quan.core.dto.create.MenuGroupCreateDTO;
import com.quan.core.dto.update.MenuGroupUpdateDTO;
import com.quan.core.model.MenuGroup;
import com.quan.core.controller.request.MenuGroupPageQueryRequest;
import com.quan.core.controller.request.MenuGroupQueryRequest;
import com.quan.core.controller.request.create.MenuGroupCreateRequest;
import com.quan.core.controller.request.update.MenuGroupUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统菜单表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 18:42:13
 */
public final class MenuGroupFactory {


    /***
     * 新建
     *
     * @return
     */
    public static MenuGroupCreateDTO newInstance(IUidGenerator uidGenerator, MenuGroupCreateRequest req) {
        MenuGroupCreateDTO createData = new MenuGroupCreateDTO();

        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setGroupName(req.getGroupName());
        createData.setGroupAliasName(req.getGroupAliasName());
        createData.setGroupCode(req.getGroupCode());
        createData.setNote(req.getNote());
        createData.setCreateTime(new Date());
        createData.setCreateUserId(0L);
        createData.setHasChildren(0);
        return createData;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static MenuGroupUpdateDTO newInstance(MenuGroupUpdateRequest req) {
        MenuGroupUpdateDTO updateData = new MenuGroupUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setGroupName(req.getGroupName());
        updateData.setGroupAliasName(req.getGroupAliasName());
        updateData.setGroupCode(req.getGroupCode());
        updateData.setNote(req.getNote());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<MenuGroupCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<MenuGroupCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static MenuGroupQueryDTO newInstance(MenuGroupQueryRequest req) {
        MenuGroupQueryDTO queryData = new MenuGroupQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static MenuGroupPageQueryDTO newInstance(MenuGroupPageQueryRequest req) {
        MenuGroupPageQueryDTO query = new MenuGroupPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static MenuGroupDTO newInstance(MenuGroup data) {
        MenuGroupDTO dto = new MenuGroupDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setGroupName(data.getGroupName());
        dto.setGroupAliasName(data.getGroupAliasName());
        dto.setGroupCode(data.getGroupCode());
        dto.setPath(data.getPath());
        dto.setNote(data.getNote());
        dto.setHasChildren(data.getHasChildren());
        dto.setSort(data.getSort());

        return dto;
    }

    public static List<MenuGroupDTO> newInstance(List<MenuGroup> data) {
        return data.stream().map(MenuGroupFactory::newInstance).collect(Collectors.toList());
    }

}
