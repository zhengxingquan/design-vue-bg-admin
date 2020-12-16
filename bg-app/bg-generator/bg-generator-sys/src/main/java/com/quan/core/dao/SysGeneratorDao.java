package com.quan.core.dao;

import com.quan.core.dto.GeneratorQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/***
 *  服务类
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/16 10:54
 */
public interface SysGeneratorDao {

    List<Map<String, Object>> queryList(@Param("data") GeneratorQueryDTO data);

    int queryTotal(@Param("data") GeneratorQueryDTO data);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

}
