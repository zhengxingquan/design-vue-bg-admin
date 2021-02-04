package com.quan.core.service;

import com.quan.core.dto.DictDTO;
import com.quan.core.controller.request.DictPageQueryRequest;
import com.quan.core.controller.request.DictQueryRequest;
import com.quan.core.controller.request.create.DictCreateRequest;
import com.quan.core.controller.request.update.DictUpdateRequest;

import java.util.List;

/**
 * 系统字典表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */
public interface DictService {
    /**
     * 添加
     *
     * @param data
     */
    int save(DictCreateRequest data);

    /**
     * 批量添加
     *
     * @param dicts
     */
    int batchSave(List<DictCreateRequest> dicts);

    /**
     * 修改
     *
     * @param dict
     */
    int update(DictUpdateRequest dict);

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
    DictDTO findOneById(Long id);


    /**
     * 通过条件查找记录
     *
     * @param dict 对象数据
     * @return
     */
    DictDTO findOneByCnd(DictQueryRequest dict);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    Object findAll(DictPageQueryRequest params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<DictDTO> list(DictQueryRequest params);


    /***
     *  启用
     * @param ids 主键id集合

     * @return int
     */
    int enable(List<Long> ids);


    /**
     * 禁用
     * @param ids 主键id集合
     *
     * @return int
     */
    int disable(List<Long> ids);

}

