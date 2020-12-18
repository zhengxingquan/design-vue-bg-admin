package com.quan.log.dao;

import com.quan.common.model.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.sql.DataSource;

/***
 *   保存日志
 *   需要配置多数据源才可以支持
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 17:10
 */
@Mapper
@ConditionalOnBean(DataSource.class)
public interface LogDao {

    int save(SysLog log);

}
