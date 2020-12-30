package com.quan.core.common.dao;

import com.quan.core.common.dto.model.HasChildrenDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/30
 * 描述：是否有 孩子节点的数据
 */
public interface IHasChildrenDao {
    /**
     * 是否有孩子节点
     *
     * @param data
     */
    Integer hasChildren(@Param("data") HasChildrenDTO data);

    /**
     * 更新数据孩子节点
     *
     * @param data
     */
    Integer updateParentNodeAttrChildren(@Param("data") HasChildrenDTO data);

    Integer existsChildrenNodeByParentId(@Param("data") HasChildrenDTO data);

    default Integer hasChildrenState(HasChildrenDTO data) {
        return hasChildren(data) > 1 ? 1 : 0;
    }

    default Integer hasChildrenState(Long parentId) {
        HasChildrenDTO data = new HasChildrenDTO();
        data.setValue(parentId);
        return hasChildren(data) >= 1 ? 1 : 0;
    }

    default void createNodeUpdateParentNodeAttrChildren(Long parentId) {
        // 判断节点是有有子节点
        if (parentId != null && parentId > 0) {
            HasChildrenDTO data = new HasChildrenDTO();
            data.setValue(parentId);
            data.setHasChildren(1);
            updateParentNodeAttrChildren(data);
        }
    }


    default void deleteNodeUpdateParentNodeAttrChildren(Long parentId) {
        if (parentId != null && parentId > 0) {
            // 判断节点是有有子节点
            HasChildrenDTO data = new HasChildrenDTO();
            data.setValue(parentId);
            // 判断父节点还有子节点没
            data.setHasChildren(existsChildrenNodeByParentId(data) > 0 ? 1 : 0);
            updateParentNodeAttrChildren(data);
        }
    }

}
