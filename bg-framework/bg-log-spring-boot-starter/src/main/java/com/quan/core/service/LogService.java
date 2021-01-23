package com.quan.core.service;


import com.quan.core.common.model.SysLog;

/***
 * 日志service
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 16:24
 *
 */
public interface LogService {

    /***
     * 保存日志信息
     */
    void save(SysLog log);
}
