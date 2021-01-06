package com.quan.core.common.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 *
 * 自动填充 修改人与 修改时间 插件
 *
 */

@Intercepts({@Signature(type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})

public class AutoFillUpdateTimeInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
