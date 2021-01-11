package com.quan.core.cache.parser;

import org.springframework.expression.ParserContext;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/11
 * 描述：
 * <p>
 * Cache 缓存 表达式解析 模板 配置类
 * <p>
 * 可以 采用 配置的方式 来 写
 */
public class CacheTemplateParserContext implements ParserContext {

    private final String expressionPrefix;

    private final String expressionSuffix;

    public CacheTemplateParserContext(String expressionPrefix, String expressionSuffix) {
        this.expressionPrefix = expressionPrefix;
        this.expressionSuffix = expressionSuffix;
    }

    public CacheTemplateParserContext() {
        this("${", "}");
    }

    @Override
    public boolean isTemplate() {
        return true;
    }

    @Override
    public String getExpressionPrefix() {
        return this.expressionPrefix;
    }

    @Override
    public String getExpressionSuffix() {
        return this.expressionSuffix;
    }
}
