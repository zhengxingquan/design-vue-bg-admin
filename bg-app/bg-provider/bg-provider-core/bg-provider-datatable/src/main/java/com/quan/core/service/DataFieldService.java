package com.quan.core.service;

import com.quan.core.dto.DataFieldDTO;
import com.quan.core.request.create.DataFieldCreateRequest;
import com.quan.core.request.update.DataFieldUpdateRequest;
import com.quan.core.request.DataFieldPageQueryRequest;
import com.quan.core.request.DataFieldQueryRequest;

import java.util.List;

/**
 * 系统字段表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:29:07
 */
public interface DataFieldService {
    /**
     * 添加
     * @param data
     */
    int save(DataFieldCreateRequest data);

    /**
     * 批量添加
     * @param dataFields
     */
    int batchSave(List<DataFieldCreateRequest> dataFields);

    /**
     * 修改
     * @param dataField
     */
    int update(DataFieldUpdateRequest dataField);

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
        DataFieldDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param dataField 对象数据
     * @return
     */
        DataFieldDTO findOneByCnd(DataFieldQueryRequest dataField);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(DataFieldPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<DataFieldDTO> list(DataFieldQueryRequest params);

}

