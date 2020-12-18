package com.quan.core.service;

import com.quan.common.web.PageResult;
import com.quan.core.request.GeneratorQueryRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/16 10:01
 */
public interface SysGeneratorService {

    PageResult queryList(GeneratorQueryRequest req);

    int queryTotal(GeneratorQueryRequest req);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    byte[] generatorCode(String[] tableNames);
}
