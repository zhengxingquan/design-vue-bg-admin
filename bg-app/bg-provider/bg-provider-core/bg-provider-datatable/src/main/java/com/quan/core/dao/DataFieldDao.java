package com.quan.core.dao;

import com.quan.core.common.dao.IBaseDao;
import com.quan.core.common.dao.IPathDao;
import com.quan.core.common.dao.ISortDao;
import com.quan.core.dto.DataFieldPageQueryDTO;
import com.quan.core.dto.DataFieldQueryDTO;
import com.quan.core.dto.create.DataFieldCreateDTO;
import com.quan.core.dto.update.DataFieldUpdateDTO;
import com.quan.core.model.DataField;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统字段表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:29:07
 */
@Mapper
public interface DataFieldDao extends IBaseDao, ISortDao, IPathDao {

    /**
     * 添加
     *
     * @param data
     */
    int save(DataFieldCreateDTO data);

    /**
     * 批量添加
     *
     * @param dataFields
     */
    int batchSave(List<DataFieldCreateDTO> dataFields);

    /**
     * 修改
     *
     * @param data
     */
    int update(DataFieldUpdateDTO data);

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
    DataField findOneById(Long id);

    /**
     * 通过ID查找所有的记录记录
     *
     * @param ids 用户记录ID
     * @return
     */
    List<DataField> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     *
     * @param params 对象数据
     * @return
     */
    DataField findOneByCnd(@Param("data") DataFieldQueryDTO params);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    List<DataField> findAll(@Param("data") DataFieldPageQueryDTO params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<DataField> list(@Param("data") DataFieldQueryDTO params);

}
