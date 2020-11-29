package com.quan.log.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.sql.DataSource;

/**
 * @author owen
 * @create 2017年7月2日
 * 保存日志
 * eureka-server配置不需要datasource,不会装配bean
 * blog: https://blog.51cto.com/13005375 
 * code: https://gitee.com/owenwangwen/open-capacity-platform
 * 需要配置多数据源才可以支持
 */
//@Mapper
//@ConditionalOnBean(DataSource.class)
public interface LogDao {

//	@Insert("insert into sys_log(username, module, params, remark, flag, create_time) values(#{username}, #{module}, #{params}, #{remark}, #{flag}, #{createTime})")
//	int save(SysLog log);

}
