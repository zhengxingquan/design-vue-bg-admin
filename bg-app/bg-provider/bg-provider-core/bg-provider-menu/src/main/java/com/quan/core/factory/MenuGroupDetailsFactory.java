package com.quan.core.factory;

import com.quan.core.dto.MenuGroupDetailsDTO;
import com.quan.core.dto.MenuGroupDetailsPageQueryDTO;
import com.quan.core.dto.MenuGroupDetailsQueryDTO;
import com.quan.core.dto.create.MenuGroupDetailsCreateDTO;
import com.quan.core.dto.update.MenuGroupDetailsUpdateDTO;
import com.quan.core.model.MenuGroupDetails;
import com.quan.core.controller.request.MenuGroupDetailsPageQueryRequest;
import com.quan.core.controller.request.MenuGroupDetailsQueryRequest;
import com.quan.core.controller.request.create.MenuGroupDetailsCreateRequest;
import com.quan.core.controller.request.update.MenuGroupDetailsUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统菜单分组与菜单对应表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 18:49:57
 */
public final class MenuGroupDetailsFactory {


    /***
     * 新建
     *
     * @return
     */
    public static MenuGroupDetailsCreateDTO newInstance(MenuGroupDetailsCreateRequest req) {
        MenuGroupDetailsCreateDTO createData = new MenuGroupDetailsCreateDTO();
        createData.setMenuGroupId(req.getMenuGroupId());
        createData.setMenuId(req.getMenuId());
        return createData;
    }

    /***
     * 新建
     *
     * @return
     */
    public static List<MenuGroupDetailsCreateDTO> newInstance(List<Long> menuIds, Long groupId) {
        if (CollectionUtils.isEmpty(menuIds)) {
            return Collections.emptyList();
        }
        List<MenuGroupDetailsCreateDTO> groupDetailsCreateDTOS = new ArrayList<>(menuIds.size());
        menuIds.forEach(menuId -> {
            groupDetailsCreateDTOS.add(MenuGroupDetailsCreateDTO.builder()
                    .menuGroupId(groupId).menuId(menuId).build());
        });
        return groupDetailsCreateDTOS;
    }

    /***
     * 编辑
     *
     * @return
     */
    public static MenuGroupDetailsUpdateDTO newInstance(MenuGroupDetailsUpdateRequest req) {
        MenuGroupDetailsUpdateDTO updateData = new MenuGroupDetailsUpdateDTO();
        updateData.setMenuGroupId(req.getMenuGroupId());
        updateData.setMenuId(req.getMenuId());
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<MenuGroupDetailsCreateDTO> newBatchInstance(List<MenuGroupDetailsCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(MenuGroupDetailsFactory::newInstance).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static MenuGroupDetailsQueryDTO newInstance(MenuGroupDetailsQueryRequest req) {
        MenuGroupDetailsQueryDTO queryData = new MenuGroupDetailsQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static MenuGroupDetailsPageQueryDTO newInstance(MenuGroupDetailsPageQueryRequest req) {
        MenuGroupDetailsPageQueryDTO query = new MenuGroupDetailsPageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static MenuGroupDetailsDTO newInstance(MenuGroupDetails data) {
        MenuGroupDetailsDTO dto = new MenuGroupDetailsDTO();
        dto.setMenuGroupId(data.getMenuGroupId());
        dto.setMenuId(data.getMenuId());

        return dto;
    }

    public static List<MenuGroupDetailsDTO> newInstance(List<MenuGroupDetails> data) {
        return data.stream().map(MenuGroupDetailsFactory::newInstance).collect(Collectors.toList());
    }

}
