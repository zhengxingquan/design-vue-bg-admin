package com.quan.log.service.impl;

import com.quan.common.model.SysLog;
import com.quan.datasource.annotation.DataSource;
import com.quan.log.dao.LogDao;
import com.quan.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/***
 *   切换数据源，存储log-center
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 16:25
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Async
    @Override
    @DataSource(name = "log")
    public void save(SysLog log) {
        logDao.save(log);
    }
}
