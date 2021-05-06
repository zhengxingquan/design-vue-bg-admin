package com.quan.core.constant.dao;

import com.quan.core.constant.dto.model.SortDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/30
 * 描述：
 */
public interface ISortDao {

    /**
     * 得到排序号
     *
     * @param data
     */
    int getSort(@Param("data") SortDTO data);

    default Integer sortState(SortDTO data) {
        return getSort(data);
    }

    default Integer sortState(Long parentId){
        SortDTO data = new SortDTO();
        data.setValue(parentId);
        return getSort(data);
    }
}
