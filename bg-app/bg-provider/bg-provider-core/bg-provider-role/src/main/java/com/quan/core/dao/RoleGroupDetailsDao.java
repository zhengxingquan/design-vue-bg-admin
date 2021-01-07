package com.quan.core.dao;

import com.quan.core.dto.RoleGroupDetailsPageQueryDTO;
import com.quan.core.dto.RoleGroupDetailsQueryDTO;
import com.quan.core.dto.create.RoleGroupDetailsCreateDTO;
import com.quan.core.dto.update.RoleGroupDetailsUpdateDTO;
import com.quan.core.model.RoleGroupDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统角色分组与角色对应表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:21:41
 */
@Mapper
public interface RoleGroupDetailsDao {

    /**
     * 添加
     * @param data
     */
    int save(RoleGroupDetailsCreateDTO data);

    /**
     * 批量添加
     * @param roleGroupDetailss
     */
    int batchSave(List<RoleGroupDetailsCreateDTO> roleGroupDetailss);

    /**
     * 修改
     * @param data
     */
    int update(RoleGroupDetailsUpdateDTO data);

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
    int batchDelete(List<Long> id);

    /**
    * 通过ID查找记录
    * @param id 用户记录ID
    * @return
    */
    RoleGroupDetails findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<RoleGroupDetails> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
    RoleGroupDetails findOneByCnd(@Param("data") RoleGroupDetailsQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupDetails> findAll(@Param("data") RoleGroupDetailsPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroupDetails> list(@Param("data") RoleGroupDetailsQueryDTO params);

}
