package com.quan.core.constant.dao;

import com.quan.core.constant.dto.model.PathDTO;
import com.quan.core.constant.util.Strings;
import org.apache.ibatis.annotations.Param;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/30
 * 描述： 得到 路径的 公用接口
 */
public interface IPathDao {

    /**
     * 得到路径
     *
     * @param data
     */
    String getParentPath(@Param("data") PathDTO data);

    /**
     * 得到路径
     *
     * @param data
     */
    String getPath(@Param("data") PathDTO data);


    Integer deleteDataByPath(@Param("data") PathDTO data);

    default Integer deleteDataByPath(String path) {
        PathDTO dto = new PathDTO();
        dto.setPath(path);
        return deleteDataByPath(dto);
    }


    default String getSubPath(PathDTO data) {
        String path = "";
        // 父节点不为空
        if (data.getPatentId() != null) {
            // 得到父亲的 path 路径
            path = Strings.sNull(getParentPath(data));
        }
        // 设置父亲的 path 路径
        data.setValue(path);
        // 查询当前的 节点的 path
        String rs = getPath(data);
        String rsValue = path + "0001";
        if (Strings.isNotBlank(rs)) {
            rsValue = rs;
            int newValue = Integer.valueOf(rsValue.substring(rsValue.length() - 4)) + 1;
            rsValue = rsValue.substring(0, rsValue.length() - 4) + new java.text.DecimalFormat("0000").format(newValue);
        }
        return rsValue;
    }

    default String getSubPath(Long parentId) {
        PathDTO dto = new PathDTO();
        dto.setPatentId(parentId);
        return getSubPath(dto);
    }
}
