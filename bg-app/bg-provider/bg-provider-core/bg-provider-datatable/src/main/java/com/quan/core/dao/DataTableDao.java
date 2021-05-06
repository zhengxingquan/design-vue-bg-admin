package com.quan.core.dao;

import com.quan.core.constant.dao.IBaseDao;
import com.quan.core.constant.dao.IHasChildrenDao;
import com.quan.core.constant.dao.IPathDao;
import com.quan.core.constant.dao.ISortDao;
import com.quan.core.model.DataTable;
import com.quan.core.dto.DataTablePageQueryDTO;
import com.quan.core.dto.DataTableQueryDTO;
import com.quan.core.dto.create.DataTableCreateDTO;
import com.quan.core.dto.update.DataTableUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统数据表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:05:24
 */
@Mapper
public interface DataTableDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     * @param data
     */
    int save(DataTableCreateDTO data);

    /**
     * 批量添加
     * @param dataTables
     */
    int batchSave(List<DataTableCreateDTO> dataTables);

    /**
     * 修改
     * @param data
     */
    int update(DataTableUpdateDTO data);

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
    DataTable findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<DataTable> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
    DataTable findOneByCnd(@Param("data") DataTableQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<DataTable> findAll(@Param("data") DataTablePageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<DataTable> list(@Param("data") DataTableQueryDTO params);

}
