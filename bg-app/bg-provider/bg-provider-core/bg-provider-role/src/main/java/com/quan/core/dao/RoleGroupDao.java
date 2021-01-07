package com.quan.core.dao;

import com.quan.core.common.dao.IBaseDao;
import com.quan.core.common.dao.IHasChildrenDao;
import com.quan.core.common.dao.IPathDao;
import com.quan.core.common.dao.ISortDao;
import com.quan.core.model.RoleGroup;
import com.quan.core.dto.RoleGroupPageQueryDTO;
import com.quan.core.dto.RoleGroupQueryDTO;
import com.quan.core.dto.create.RoleGroupCreateDTO;
import com.quan.core.dto.update.RoleGroupUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统角色分组表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:07:02
 */
@Mapper
public interface RoleGroupDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     * @param data
     */
    int save(RoleGroupCreateDTO data);

    /**
     * 批量添加
     * @param roleGroups
     */
    int batchSave(List<RoleGroupCreateDTO> roleGroups);

    /**
     * 修改
     * @param data
     */
    int update(RoleGroupUpdateDTO data);

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
    RoleGroup findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<RoleGroup> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
    RoleGroup findOneByCnd(@Param("data") RoleGroupQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroup> findAll(@Param("data") RoleGroupPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<RoleGroup> list(@Param("data") RoleGroupQueryDTO params);

}
