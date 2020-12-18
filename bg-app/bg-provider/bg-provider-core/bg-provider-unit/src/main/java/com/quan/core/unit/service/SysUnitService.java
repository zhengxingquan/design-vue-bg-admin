package com.quan.core.unit.service;


import com.quan.core.unit.model.SysUnit;

import java.util.Map;

/**
 * 系统单位表
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-18 19:48:27
 */
public interface SysUnitService {
    /**
     * 添加
     *
     * @param sysUnit
     */
    int save(SysUnit sysUnit);

    /**
     * 修改
     *
     * @param sysUnit
     */
    int update(SysUnit sysUnit);

    /**
     * 删除
     *
     * @param id
     */
    int delete(Long id);


    /**
     * 列表
     *
     * @param params
     * @return
     */
    Object findAll(Map<String, Object> params);

}

