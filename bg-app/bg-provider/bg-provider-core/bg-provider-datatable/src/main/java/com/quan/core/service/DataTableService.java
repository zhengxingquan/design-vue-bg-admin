package com.quan.core.service;

import com.quan.core.dto.DataTableDTO;
import com.quan.core.controller.request.create.DataTableCreateRequest;
import com.quan.core.controller.request.update.DataTableUpdateRequest;
import com.quan.core.controller.request.DataTablePageQueryRequest;
import com.quan.core.controller.request.DataTableQueryRequest;

import java.util.List;

/**
 * 系统数据表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:05:24
 */
public interface DataTableService {
    /**
     * 添加
     * @param data
     */
    int save(DataTableCreateRequest data);

    /**
     * 批量添加
     * @param dataTables
     */
    int batchSave(List<DataTableCreateRequest> dataTables);

    /**
     * 修改
     * @param dataTable
     */
    int update(DataTableUpdateRequest dataTable);

    /**
     * 单条删除
     * @param id
     */
    int delete(Long id);

    /**
       * 批量删除
       *
       * @param id
       */
    int delete(List<Long> id);

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
        DataTableDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param dataTable 对象数据
     * @return
     */
        DataTableDTO findOneByCnd(DataTableQueryRequest dataTable);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(DataTablePageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<DataTableDTO> list(DataTableQueryRequest params);

}

