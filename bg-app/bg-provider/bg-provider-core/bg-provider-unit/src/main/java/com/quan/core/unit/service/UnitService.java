package com.quan.core.unit.service;

import com.quan.common.web.PageResult;
import com.quan.core.unit.dto.UnitDTO;
import com.quan.core.unit.request.create.UnitCreateRequest;
import com.quan.core.unit.request.update.UnitUpdateRequest;
import com.quan.core.unit.request.UnitPageQueryRequest;
import com.quan.core.unit.request.UnitQueryRequest;

import java.util.List;

/**
 * 系统单位表
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-21 19:28:04
 */
public interface UnitService {
    /**
     * 添加
     * @param data
     */
    int save(UnitCreateRequest data);

    /**
     * 批量添加
     * @param units
     */
    int save(List<UnitCreateRequest> units);

    /**
     * 修改
     * @param unit
     */
    int update(UnitUpdateRequest unit);

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
        UnitDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param unit 对象数据
     * @return
     */
        UnitDTO findOneByCnd(UnitQueryRequest unit);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    PageResult<UnitDTO> findAll(UnitPageQueryRequest params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<UnitDTO> list(UnitQueryRequest params);

}
