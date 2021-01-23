package com.quan.core.service.impl;

import com.quan.core.common.model.SysLog;
import com.quan.core.dao.LogDao;
import com.quan.core.datasource.annotation.DataSource;
import com.quan.core.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

/***
 *   切换数据源，存储log-center
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 16:25
 */
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
