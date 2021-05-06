package com.quan.core.dao;

import com.quan.core.constant.dao.IDeleteWithIdDao;
import com.quan.core.constant.dao.IDisabledDao;
import com.quan.core.constant.dao.IEnableDao;
import com.quan.core.constant.dto.query.PageQueryDTO;
import com.quan.core.constant.model.SysClient;
import com.quan.core.dto.client.AuthClientCreateDTO;
import com.quan.core.dto.client.AuthClientUpdateDTO;
import com.quan.core.dto.client.QueryClientDTO;
import com.quan.core.dto.client.QueryClientPageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysClientDao extends IDeleteWithIdDao, IEnableDao, IDisabledDao {

    /****
     * 保存
     */
    int save(AuthClientCreateDTO client);

    /****
     * 修改
     */
    int updateByPrimaryKey(AuthClientUpdateDTO client);

    /****
     * 查找
     */
    SysClient getById(@Param("id") Long id);

    /****
     * 查找
     */
    SysClient getClient(@Param("clientId") String clientId);

    /****
     * 查找
     */
    List<SysClient> findAllByIds(@Param("ids") List<Long> ids);

    /***
     * 统计数据
     */
    int count(@Param("params") Map<String, Object> params);

    /***
     * 查询分页列表
     */
    List<SysClient> findList(@Param("params") QueryClientPageDTO client, @Param("page") PageQueryDTO page);

    /***
     * 查询列表
     */
    List<SysClient> data(@Param("params") QueryClientDTO client);

}
