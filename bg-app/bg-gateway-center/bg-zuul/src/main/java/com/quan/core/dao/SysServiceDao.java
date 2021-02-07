package com.quan.core.dao;

import com.quan.core.common.model.SysService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/***
 * 查询应用绑定的资源权限
 * @author zxq(956607644 @ qq.com)
 * @date 2021/2/5 10:41
 */
@Mapper
public interface SysServiceDao {

    List<SysService> findAllClientByClientId(@Param("clientId") Long clientId);
}
