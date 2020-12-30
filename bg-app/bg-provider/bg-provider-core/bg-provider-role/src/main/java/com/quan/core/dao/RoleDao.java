package com.quan.core.dao;

import com.quan.core.common.dao.IBaseDao;
import com.quan.core.common.dao.IHasChildrenDao;
import com.quan.core.common.dao.IPathDao;
import com.quan.core.common.dao.ISortDao;
import com.quan.core.dto.RolePageQueryDTO;
import com.quan.core.dto.RoleQueryDTO;
import com.quan.core.dto.create.RoleCreateDTO;
import com.quan.core.dto.update.RoleUpdateDTO;
import com.quan.core.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统角色表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */
@Mapper
public interface RoleDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     *
     * @param data
     */
    int save(RoleCreateDTO data);

    /**
     * 批量添加
     *
     * @param roles
     */
    int batchSave(List<RoleCreateDTO> roles);

    /**
     * 修改
     *
     * @param data
     */
    int update(RoleUpdateDTO data);

    /**
     * 单条删除
     *
     * @param id
     */
    int delete(Long id);

    /**
     * 批量删除
     *
     * @param ids
     */
    int batchDelete(List<Long> ids);

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    Role findOneById(Long id);


    /**
     * 通过条件查找记录
     *
     * @param params 对象数据
     * @return
     */
    Role findOneByCnd(@Param("data") RoleQueryDTO params);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    List<Role> findAll(@Param("data") RolePageQueryDTO params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<Role> list(@Param("data") RoleQueryDTO params);

}
