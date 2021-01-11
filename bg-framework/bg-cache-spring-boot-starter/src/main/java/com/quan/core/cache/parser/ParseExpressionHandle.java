package com.quan.core.cache.parser;

import org.springframework.lang.Nullable;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/11
 * 描述：
 */
public interface ParseExpressionHandle {

    Object renderExpression(String expression);

    <T> T renderExpression(String expression, Class<T> resultType);

    void setVariable(@Nullable String name, @Nullable Object value);

    boolean hasExpression(String expression);
}
