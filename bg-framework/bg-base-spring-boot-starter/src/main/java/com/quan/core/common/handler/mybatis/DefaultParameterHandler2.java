package com.quan.core.common.handler.mybatis;

import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 */
public class DefaultParameterHandler2 implements ParameterHandler {

    private final TypeHandlerRegistry typeHandlerRegistry;
    private final MappedStatement mappedStatement;
    private final Object parameterObject;
    private final BoundSql boundSql;
    private final Configuration configuration;

    public DefaultParameterHandler2(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        super(mappedStatement, processParameter(mappedStatement, parameterObject), boundSql);
        this.mappedStatement = mappedStatement;
        this.configuration = mappedStatement.getConfiguration();
        this.typeHandlerRegistry = mappedStatement.getConfiguration().getTypeHandlerRegistry();
        this.parameterObject = parameterObject;
        this.boundSql = boundSql;
    }

    private static Object processParameter(MappedStatement ms, Object parameterObject) {
        /* 只处理插入或更新操作 */
        if (parameterObject != null
                && (SqlCommandType.INSERT == ms.getSqlCommandType() || SqlCommandType.UPDATE == ms.getSqlCommandType())) {
            //检查 parameterObject
            if (ReflectionKit.isPrimitiveOrWrapper(parameterObject.getClass())
                    || parameterObject.getClass() == String.class) {
                return parameterObject;
            }
            Collection<Object> parameters = getParameters(parameterObject);
            if (null != parameters) {
                // 感觉这里可以稍微优化一下，理论上都是同一个.
                parameters.forEach(obj -> process(ms, obj));
            } else {
                process(ms, parameterObject);
            }
        }
        return parameterObject;
    }

    private static Collection<Object> getParameters(Object parameterObject) {
        return null;
    }

    private static void process(MappedStatement ms, Object parameterObject) {

    }

    @Override
    public Object getParameterObject() {
        return null;
    }

    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {

    }
}
