package com.quan.core.datamapping.dao;

import com.quan.core.common.dao.IBaseDao;
import com.quan.core.common.dao.IHasChildrenDao;
import com.quan.core.common.dao.IPathDao;
import com.quan.core.common.dao.ISortDao;
import com.quan.core.datamapping.dto.DataMappingPageQueryDTO;
import com.quan.core.datamapping.dto.DataMappingQueryDTO;
import com.quan.core.datamapping.dto.create.DataMappingCreateDTO;
import com.quan.core.datamapping.dto.update.DataMappingUpdateDTO;
import com.quan.core.datamapping.model.DataMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统映射配置表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */
@Mapper
public interface DataMappingDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     * @param data
     */
    int save(DataMappingCreateDTO data);

    /**
     * 批量添加
     * @param dataMappings
     */
    int batchSave(List<DataMappingCreateDTO> dataMappings);

    /**
     * 修改
     * @param data
     */
    int update(DataMappingUpdateDTO data);

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
    DataMapping findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<DataMapping> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
     DataMapping findOneByCnd(@Param("data") DataMappingQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<DataMapping> findAll(@Param("data") DataMappingPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<DataMapping> list(@Param("data") DataMappingQueryDTO params);


    /***
     *  启用
     * @param ids 主键id集合
    
     * @return int  
     */
    int enable(List<Long> ids);


    /**
    * 禁用
    * @param ids 主键id集合
    *
    * @return int
    */
    int disable(List<Long> ids);

    /**
     * sysCode 是否已经存在了
     * @param sysCode 主键id集合
     *
     * @return int
     */
    int sysCodeIsExists(String sysCode);

}
