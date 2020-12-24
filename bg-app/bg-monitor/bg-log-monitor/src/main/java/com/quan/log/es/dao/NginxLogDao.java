package com.quan.log.es.dao;

import com.quan.log.es.entity.NinxLogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * ELK收集nginx中的日志查询接口
 */
@Component
public interface NginxLogDao extends ElasticsearchRepository<NinxLogDocument, String> {

}