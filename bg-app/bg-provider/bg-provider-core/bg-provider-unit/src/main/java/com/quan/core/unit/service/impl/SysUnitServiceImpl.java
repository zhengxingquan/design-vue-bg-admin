package com.quan.core.unit.service.impl;

import com.quan.common.annotation.PageQuery;
import com.quan.common.web.PageResult;
import com.quan.core.unit.dao.SysUnitDao;
import com.quan.core.unit.model.SysUnit;
import com.quan.core.unit.service.SysUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SysUnitServiceImpl implements SysUnitService {

    @Autowired
    private SysUnitDao sysUnitDao;

    /**
     * 添加
     *
     * @param sysUnit
     */
    @Override
    public int save(SysUnit sysUnit) {
        return sysUnitDao.save(sysUnit);
    }

    /**
     * 修改
     *
     * @param sysUnit
     */
    public int update(SysUnit sysUnit) {
        return sysUnitDao.update(sysUnit);
    }


    /**
     * 删除
     *
     * @param id
     */
    public int delete(Long id) {
        return sysUnitDao.delete(id);
    }


    /**
     * 列表
     *
     * @param params
     * @return
     */
    @PageQuery
    public Object findAll(Map<String, Object> params) {
        return sysUnitDao.findAll(params);
    }

}
