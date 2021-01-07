package com.quan.core.dao;

import com.quan.core.common.dao.IBaseDao;
import com.quan.core.common.dao.IHasChildrenDao;
import com.quan.core.common.dao.IPathDao;
import com.quan.core.common.dao.ISortDao;
import com.quan.core.dto.DatabasePageQueryDTO;
import com.quan.core.dto.DatabaseQueryDTO;
import com.quan.core.dto.create.DatabaseCreateDTO;
import com.quan.core.dto.update.DatabaseUpdateDTO;
import com.quan.core.model.Database;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统数据仓库表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 22:12:27
 */
@Mapper
public interface DatabaseDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     *
     * @param data
     */
    int save(DatabaseCreateDTO data);

    /**
     * 批量添加
     *
     * @param databases
     */
    int batchSave(List<DatabaseCreateDTO> databases);

    /**
     * 修改
     *
     * @param data
     */
    int update(DatabaseUpdateDTO data);

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
    int batchDelete(List<Long> id);

    /**
     * 通过ID查找记录
     *
     * @param id 用户记录ID
     * @return
     */
    Database findOneById(Long id);

    /**
     * 通过ID查找所有的记录记录
     *
     * @param ids 用户记录ID
     * @return
     */
    List<Database> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     *
     * @param params 对象数据
     * @return
     */
    Database findOneByCnd(@Param("data") DatabaseQueryDTO params);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    List<Database> findAll(@Param("data") DatabasePageQueryDTO params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<Database> list(@Param("data") DatabaseQueryDTO params);

}
