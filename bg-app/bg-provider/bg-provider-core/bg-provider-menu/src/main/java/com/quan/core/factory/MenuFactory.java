package com.quan.core.factory;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.dto.MenuDTO;
import com.quan.core.dto.MenuPageQueryDTO;
import com.quan.core.dto.MenuQueryDTO;
import com.quan.core.dto.create.MenuCreateDTO;
import com.quan.core.dto.update.MenuUpdateDTO;
import com.quan.core.model.Menu;
import com.quan.core.controller.request.create.MenuCreateRequest;
import com.quan.core.controller.request.update.MenuUpdateRequest;
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
 * @date 2021-01-05 17:50:17
 */
public final class MenuFactory {


    /***
     * 新建
     *
     * @return
     */
    public static MenuCreateDTO newInstance(IUidGenerator uidGenerator, MenuCreateRequest req) {
        MenuCreateDTO createData = new MenuCreateDTO();

        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setName(req.getName());
        createData.setAliasName(req.getAliasName());
        createData.setCode(req.getCode());
        createData.setType(req.getType());
        createData.setHref(req.getHref());
        createData.setTarget(req.getTarget());
        createData.setMenuIcon(req.getMenuIcon());
        createData.setPermission(req.getPermission());
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
    public static MenuUpdateDTO newInstance(MenuUpdateRequest req) {
        MenuUpdateDTO updateData = new MenuUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setName(req.getName());
        updateData.setAliasName(req.getAliasName());
        updateData.setCode(req.getCode());
        updateData.setType(req.getType());
        updateData.setHref(req.getHref());
        updateData.setTarget(req.getTarget());
        updateData.setMenuIcon(req.getMenuIcon());
        updateData.setPermission(req.getPermission());
        updateData.setNote(req.getNote());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<MenuCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<MenuCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(req -> newInstance(uidGenerator, req)).collect(Collectors.toList());
    }

    /***
     * 转换分页 req 到 DTO
     */
//    public static MenuPageQueryDTO newInstance(MenuPageQueryRequest req) {
//        MenuPageQueryDTO query = new MenuPageQueryDTO();
//        query.setPageNumber(req.getPageNumber());
//        query.setPageSize(req.getPageSize());
//
//        return query;
//    }

    /***
     * 转换 PO 到 DTO
     */
    public static MenuDTO newInstance(Menu data) {
        MenuDTO dto = new MenuDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setName(data.getName());
        dto.setAliasName(data.getAliasName());
        dto.setCode(data.getCode());
        dto.setPath(data.getPath());
        dto.setType(data.getType());
        dto.setHref(data.getHref());
        dto.setTarget(data.getTarget());
        dto.setMenuIcon(data.getMenuIcon());
        dto.setPermission(data.getPermission());
        dto.setNote(data.getNote());
        dto.setHasChildren(data.getHasChildren());
        dto.setSort(data.getSort());

        return dto;
    }

    public static List<MenuDTO> newInstance(List<Menu> data) {
        return data.stream().map(MenuFactory::newInstance).collect(Collectors.toList());
    }

}
