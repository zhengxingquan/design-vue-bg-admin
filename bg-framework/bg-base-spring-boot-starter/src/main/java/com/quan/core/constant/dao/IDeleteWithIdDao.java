package com.quan.core.constant.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
public interface IDeleteWithIdDao {

    /****
     * 删除
     */
    int delete(@Param("id") Long id);

    /****
     * 批量删除
     */
    int batchDelete(@Param("ids") List<Long> ids);
    
}
