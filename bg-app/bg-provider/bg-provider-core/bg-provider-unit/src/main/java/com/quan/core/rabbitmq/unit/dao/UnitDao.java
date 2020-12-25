package com.quan.core.rabbitmq.unit.dao;

import com.quan.core.rabbitmq.unit.dto.UnitPageQueryDTO;
import com.quan.core.rabbitmq.unit.dto.UnitQueryDTO;
import com.quan.core.rabbitmq.unit.dto.create.UnitCreateDTO;
import com.quan.core.rabbitmq.unit.dto.update.UnitUpdateDTO;
import com.quan.core.rabbitmq.unit.model.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 系统单位表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-22 19:04:56
 */
@Mapper
public interface UnitDao {

    /**
     * 添加
     * @param data
     */
    int save(UnitCreateDTO data);

    /**
     * 批量添加
     * @param units
     */
    int save(List<UnitCreateDTO> units);

    /**
     * 修改
     * @param data
     */
    int update(UnitUpdateDTO data);

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
    Unit findOneById(Long id);


    /**
     * 通过条件查找记录
     * @param params 对象数据
     * @return
     */
     Unit findOneByCnd(@Param("data") UnitQueryDTO params);


    /**
     * 查询列表分页
     * @param params 对象查询
     * @return
     */
    List<Unit> findAll(@Param("data") UnitPageQueryDTO params);


    /**
     * 查询列表不分页
     * @param params 对象查询
     * @return
     */
    List<Unit> list(@Param("data") UnitQueryDTO params);

}
