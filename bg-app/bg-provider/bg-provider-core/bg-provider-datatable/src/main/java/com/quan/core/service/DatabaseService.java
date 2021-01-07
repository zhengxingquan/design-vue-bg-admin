package com.quan.core.service;

import com.quan.core.dto.DatabaseDTO;
import com.quan.core.request.create.DatabaseCreateRequest;
import com.quan.core.request.update.DatabaseUpdateRequest;
import com.quan.core.request.DatabasePageQueryRequest;
import com.quan.core.request.DatabaseQueryRequest;

import java.util.List;

/**
 * 系统数据仓库表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 22:12:27
 */
public interface DatabaseService {
    /**
     * 添加
     * @param data
     */
    int save(DatabaseCreateRequest data);

    /**
     * 批量添加
     * @param databases
     */
    int batchSave(List<DatabaseCreateRequest> databases);

    /**
     * 修改
     * @param database
     */
    int update(DatabaseUpdateRequest database);

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
        DatabaseDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param database 对象数据
     * @return
     */
        DatabaseDTO findOneByCnd(DatabaseQueryRequest database);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    Object findAll(DatabasePageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<DatabaseDTO> list(DatabaseQueryRequest params);

}

