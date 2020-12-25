package com.quan.core.rabbitmq.service;

import com.quan.core.rabbitmq.request.GeneratorQueryRequest;

import java.util.List;
import java.util.Map;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/16 10:01
 */
public interface SysGeneratorService {

    Object queryList(GeneratorQueryRequest req);

    int queryTotal(GeneratorQueryRequest req);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    byte[] generatorCode(String[] tableNames);
}
