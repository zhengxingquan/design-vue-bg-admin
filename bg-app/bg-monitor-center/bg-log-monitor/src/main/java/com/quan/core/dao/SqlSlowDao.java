package com.quan.core.dao;

import com.quan.core.entity.SqlSlowDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * ELK收集mysql慢查询日志查询接口
 */
@Component
public interface SqlSlowDao extends ElasticsearchRepository<SqlSlowDocument, String> {

}