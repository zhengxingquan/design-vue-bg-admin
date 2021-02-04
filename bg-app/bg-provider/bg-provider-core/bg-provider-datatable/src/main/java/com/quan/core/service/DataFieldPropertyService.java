package com.quan.core.service;

import com.quan.core.dto.DataFieldPropertyDTO;
import com.quan.core.controller.request.DataFieldPropertyPageQueryRequest;
import com.quan.core.controller.request.DataFieldPropertyQueryRequest;
import com.quan.core.controller.request.create.DataFieldPropertyCreateRequest;
import com.quan.core.controller.request.update.DataFieldPropertyUpdateRequest;

import java.util.List;

/**
 * 系统字段属性表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:19:31
 */
public interface DataFieldPropertyService {
    /**
     * 添加
     *
     * @param data
     */
    int save(DataFieldPropertyCreateRequest data);

    /**
     * 批量添加
     *
     * @param dataFieldPropertys
     */
    int batchSave(List<DataFieldPropertyCreateRequest> dataFieldPropertys);

    /**
     * 修改
     *
     * @param dataFieldProperty
     */
    int update(DataFieldPropertyUpdateRequest dataFieldProperty);

    /**
     * 单条删除
     *
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
     *
     * @param id 用户记录ID
     * @return
     */
    DataFieldPropertyDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     *
     * @param dataFieldProperty 对象数据
     * @return
     */
    DataFieldPropertyDTO findOneByCnd(DataFieldPropertyQueryRequest dataFieldProperty);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    Object findAll(DataFieldPropertyPageQueryRequest params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<DataFieldPropertyDTO> list(DataFieldPropertyQueryRequest params);

}

