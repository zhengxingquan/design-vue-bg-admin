package com.quan.core.factory;

import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.dto.DatabaseDTO;
import com.quan.core.dto.DatabasePageQueryDTO;
import com.quan.core.dto.DatabaseQueryDTO;
import com.quan.core.dto.create.DatabaseCreateDTO;
import com.quan.core.dto.update.DatabaseUpdateDTO;
import com.quan.core.model.Database;
import com.quan.core.controller.request.DatabasePageQueryRequest;
import com.quan.core.controller.request.DatabaseQueryRequest;
import com.quan.core.controller.request.create.DatabaseCreateRequest;
import com.quan.core.controller.request.update.DatabaseUpdateRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统数据仓库表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 22:12:27
 */
public final class DatabaseFactory {


    /***
     * 新建
     *
     * @return
     */
    public static DatabaseCreateDTO newInstance(IUidGenerator uidGenerator, DatabaseCreateRequest req) {
        DatabaseCreateDTO createData = new DatabaseCreateDTO();
        createData.setId(uidGenerator.uid());
        createData.setParentId(req.getParentId());
        createData.setName(req.getName());
        createData.setDatabaseCode(req.getDatabaseCode());
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
    public static DatabaseUpdateDTO newInstance(DatabaseUpdateRequest req) {
        DatabaseUpdateDTO updateData = new DatabaseUpdateDTO();
        updateData.setId(req.getId());
        updateData.setParentId(req.getParentId());
        updateData.setName(req.getName());
        updateData.setPhysicalName(req.getPhysicalName());
        updateData.setDatabaseCode(req.getDatabaseCode());
        updateData.setNote(req.getNote());
        updateData.setUpdateTime(new Date());
        updateData.setUpdateUserId(0L);
        return updateData;
    }

    /***
     * 批量 新建
     */
    public static List<DatabaseCreateDTO> newBatchInstance(IUidGenerator uidGenerator, List<DatabaseCreateRequest> datas) {

        if (CollectionUtils.isEmpty(datas)) {
            return Collections.emptyList();
        }
        return datas.stream().map(d -> newInstance(uidGenerator, d)).collect(Collectors.toList());
    }

    /***
     * 转换查询列表 req 到 DTO
     */
    public static DatabaseQueryDTO newInstance(DatabaseQueryRequest req) {
        DatabaseQueryDTO queryData = new DatabaseQueryDTO();

        return queryData;
    }

    /***
     * 转换分页 req 到 DTO
     */
    public static DatabasePageQueryDTO newInstance(DatabasePageQueryRequest req) {
        DatabasePageQueryDTO query = new DatabasePageQueryDTO();
        query.setPageNumber(req.getPageNumber());
        query.setPageSize(req.getPageSize());

        return query;
    }

    /***
     * 转换 PO 到 DTO
     */
    public static DatabaseDTO newInstance(Database data) {
        DatabaseDTO dto = new DatabaseDTO();
        dto.setId(data.getId());
        dto.setParentId(data.getParentId());
        dto.setName(data.getName());
        dto.setPhysicalName(data.getPhysicalName());
        dto.setDatabaseCode(data.getDatabaseCode());
        dto.setPath(data.getPath());
        dto.setHasChildren(data.getHasChildren());
        dto.setSort(data.getSort());
        dto.setNote(data.getNote());

        return dto;
    }

    public static List<DatabaseDTO> newInstance(List<Database> data) {
        return data.stream().map(DatabaseFactory::newInstance).collect(Collectors.toList());
    }

}
