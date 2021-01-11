package com.quan.core;

import com.quan.core.cache.parser.CacheTemplateParserContext;
import org.junit.Test;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/11
 * 描述：
 */
public class SpelTest {

    @Test
    public void test1() {
        String el = "${ ( #args[0] + #args[1] ) / 2 }";
        // 表达式
        String el2 = "${ (  #arg_0 + #arg_1  ) / 2 }";
        // 去掉空格
        String el3 = "${#user.name + #arg_1}";
        String el4 = "${ (#user.age + #arg_1 )/2}";

        System.out.println(spelTest1(el, Integer.class, new Object[]{1, 3}));
        System.out.println(spelTest1(el2, Integer.class, new Object[]{1, 3}));
        System.out.println(spelTest1(el3, String.class, new Object[]{1, 3}));
        System.out.println(spelTest1(el4, Integer.class, new Object[]{1, 3}));

    }

    private <T> T spelTest1(String key, Class<T> result, Object... args) {

        //获取被拦截方法参数名列表(使用Spring支持类库)
//        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
//
//        String[] paraNameArr = u.getParameterNames(method);

        //使用SPEL进行key的解析
        ExpressionParser parser = new SpelExpressionParser();
        // 模板定义
        ParserContext parserContext = new CacheTemplateParserContext();
        //SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        //把方法参数放入SPEL上下文中
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            context.setVariable("arg_" + i, args[i]);
            objects.add(args[i]);
        }
        context.setVariable("args", objects);
        context.setVariable("user", new User("jack", 34));


        return parser.parseExpression(key, parserContext).getValue(context, result);

    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
