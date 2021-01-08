package com.quan.core.dao;

import com.quan.core.common.dao.IBaseDao;
import com.quan.core.common.dao.IHasChildrenDao;
import com.quan.core.common.dao.IPathDao;
import com.quan.core.common.dao.ISortDao;
import com.quan.core.dto.DictPageQueryDTO;
import com.quan.core.dto.DictQueryDTO;
import com.quan.core.dto.create.DictCreateDTO;
import com.quan.core.dto.update.DictUpdateDTO;
import com.quan.core.model.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统字典表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */
@Mapper
public interface DictDao extends IBaseDao, ISortDao, IPathDao, IHasChildrenDao {

    /**
     * 添加
     *
     * @param data
     */
    int save(DictCreateDTO data);

    /**
     * 批量添加
     *
     * @param dicts
     */
    int batchSave(List<DictCreateDTO> dicts);

    /**
     * 修改
     *
     * @param data
     */
    int update(DictUpdateDTO data);

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
    Dict findOneById(Long id);


    /**
     * 通过ID查找所有的记录记录
     *
     * @param ids 用户记录ID
     * @return
     */
    List<Dict> findAllById(List<Long> ids);


    /**
     * 通过条件查找记录
     *
     * @param params 对象数据
     * @return
     */
    Dict findOneByCnd(@Param("data") DictQueryDTO params);


    /**
     * 查询列表分页
     *
     * @param params 对象查询
     * @return
     */
    List<Dict> findAll(@Param("data") DictPageQueryDTO params);


    /**
     * 查询列表不分页
     *
     * @param params 对象查询
     * @return
     */
    List<Dict> list(@Param("data") DictQueryDTO params);


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
     * 查询 sysCode 是否有相同的数据
     * @param sysCode 系统编码
     *
     * @return int
     */
    int sysCodeIsExists(String sysCode);

}
