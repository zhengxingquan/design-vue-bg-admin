package com.quan.core.constant.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
public interface IEnableDao {

    /***
     * 启用
     */
    int enable(@Param("ids") List<Long> ids);
}
