package com.quan.core.unit.dao;

import com.quan.core.unit.model.SysUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统单位表
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-18 19:48:27
 */
@Mapper
public interface SysUnitDao {

    int save(SysUnit sysUnit);

    int update(SysUnit sysUnit);

    int delete(Long id);


    List<SysUnit> findAll(Map<String, Object> params);


}
