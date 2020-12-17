package com.quan.common;

import org.junit.Test;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public class test {

    @Test
    public void t1() throws Exception{
        String targetName = "";
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        Object[] arguments = new String[]{};
        String key = "";
        String[] paramNames = new String[]{};
//        getParamterNames(method);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(key);
        EvaluationContext context = new StandardEvaluationContext();
        for(int i = 0; i<arguments.length; i++){
            context.setVariable(paramNames[i],arguments[i]);
        }
        System.out.println(expression.getValue(context,String.class));
    }

    public String[] getParamterNames(Method method){
        LocalVariableTableParameterNameDiscoverer u =
                new LocalVariableTableParameterNameDiscoverer();
        return  u.getParameterNames(method);
    }
}
