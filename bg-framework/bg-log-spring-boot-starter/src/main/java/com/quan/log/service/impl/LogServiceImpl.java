package com.quan.log.service.impl;

import com.quan.log.dao.LogDao;
import com.quan.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.Date;

/**
 * @author owen
 * 切换数据源，存储log-center
 * blog: https://blog.51cto.com/13005375 
 * code: https://gitee.com/owenwangwen/open-capacity-platform
 */
public class LogServiceImpl implements LogService {

//	@Autowired
//	private LogDao logDao;
//
//	@Async
//	@Override
//	@DataSource(name="log")
//	public void save(SysLog log) {
//		if (log.getCreateTime() == null) {
//			log.setCreateTime(new Date());
//		}
//		if (log.getFlag() == null) {
//			log.setFlag(Boolean.TRUE);
//		}
//
//		logDao.save(log);
//	}

	 
}
