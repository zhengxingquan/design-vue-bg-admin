package com.quan.core.dao;

import com.quan.core.constant.dao.IBaseDao;
import com.quan.core.constant.dao.IHasChildrenDao;
import com.quan.core.constant.dao.IPathDao;
import com.quan.core.constant.dao.ISortDao;
import com.quan.core.model.DataFieldProperty;
import com.quan.core.dto.DataFieldPropertyPageQueryDTO;
import com.quan.core.dto.DataFieldPropertyQueryDTO;
import com.quan.core.dto.create.DataFieldPropertyCreateDTO;
import com.quan.core.dto.update.DataFieldPropertyUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统字段属性表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:19:31
 */
@Mapper
public interface DataFieldPropertyDao  extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     * @param data
     */
    int save(DataFieldPropertyCreateDTO data);

    /**
     * 批量添加
     * @param dataFieldPropertys
     */
    int batchSave(List<DataFieldPropertyCreateDTO> dataFieldPropertys);

    /**
     * 修改
     * @param data
     */
    int update(DataFieldPropertyUpdateDTO data);

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
    DataFieldProperty findOneById(Long id);

    /**
    * 通过ID查找所有的记录记录
    * @param ids 用户记录ID
    * @return
    */
    List<DataFieldProperty> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
    DataFieldProperty findOneByCnd(@Param("data") DataFieldPropertyQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<DataFieldProperty> findAll(@Param("data") DataFieldPropertyPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<DataFieldProperty> list(@Param("data") DataFieldPropertyQueryDTO params);

}
