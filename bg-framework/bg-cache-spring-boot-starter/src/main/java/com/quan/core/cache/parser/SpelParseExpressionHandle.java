package com.quan.core.cache.parser;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/11
 * 描述：
 */
@Slf4j
public class SpelParseExpressionHandle implements ParseExpressionHandle {

    /***
     * 解析模板定义数据
     */
    private ParserContext parserContext;

    /****
     * SPEL上下文
     */
    private EvaluationContext context;
    /****
     * 使用SPEL进行key的解析
     */
    private ExpressionParser parser;
    /****
     * 表达式解析缓存对象
     */
    private final Map<String, CacheObject> expressionObject = new ConcurrentHashMap<>(50);


    public SpelParseExpressionHandle() {
        this.parserContext = new CacheTemplateParserContext();
        this.context = new StandardEvaluationContext();
        this.parser = new SpelExpressionParser();
    }


    @Override
    public Object renderExpression(String expression) {
        return renderExpression(expression, Object.class);
    }

    @Override
    public <T> T renderExpression(String expression, Class<T> resultType) {
        try {
            return parser.parseExpression(expression, parserContext).getValue(context, resultType);
        } catch (Exception e) {
            log.error("表达式 {} 解析失败 {} ", expression, e);
        }
        return null;
    }

    @Override
    public boolean hasExpression(String expression) {
        if(StringUtils.isBlank(expression)){
            return  false;
        }
        return expression.matches("\\$\\{.*\\#.*\\}");
    }

    /***
     * 设置表达式变量
     */
    @Override
    public void setVariable(String name, Object value) {
        context.setVariable(name, value);
    }

    static final class CacheObject implements Serializable {
        private final String expressionValue;
        private final String key;
        private final Class methodResult;

        public CacheObject(String expressionValue, String key, Class methodResult) {
            this.expressionValue = expressionValue;
            this.key = key;
            this.methodResult = methodResult;
        }
    }

}
