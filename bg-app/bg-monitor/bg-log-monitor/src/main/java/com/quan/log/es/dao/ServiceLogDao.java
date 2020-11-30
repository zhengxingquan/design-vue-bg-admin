package com.quan.log.es.dao;

import com.quan.log.es.entity.ServiceLogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * ELK收集ocp中info.info日志查询接口
 */
@Repository
public interface ServiceLogDao extends ElasticsearchRepository<ServiceLogDocument, String> {

}