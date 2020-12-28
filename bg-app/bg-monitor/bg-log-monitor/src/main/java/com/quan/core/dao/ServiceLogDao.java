package com.quan.core.dao;

import com.quan.core.entity.ServiceLogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * ELK收集ocp中info.info日志查询接口
 */
@Component
public interface ServiceLogDao extends ElasticsearchRepository<ServiceLogDocument, String> {

}