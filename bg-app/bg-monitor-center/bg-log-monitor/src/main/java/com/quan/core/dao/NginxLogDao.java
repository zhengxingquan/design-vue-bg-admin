package com.quan.core.dao;

import com.quan.core.entity.NinxLogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * ELK收集nginx中的日志查询接口
 */
@Component
public interface NginxLogDao extends ElasticsearchRepository<NinxLogDocument, String> {

}