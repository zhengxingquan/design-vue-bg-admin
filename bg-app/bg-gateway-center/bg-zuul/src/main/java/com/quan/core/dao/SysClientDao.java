package com.quan.core.dao;

import com.quan.core.constant.model.SysClient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 *   类说明 查询应用
 * @author zxq(956607644 @ qq.com)
 * @date 2021/2/5 9:55
 */
@Mapper
public interface SysClientDao {

    /***
     *   通过 clientId 查找 应用
     */
    SysClient findClientByClientId(@Param("clientId") String clientId);

}
