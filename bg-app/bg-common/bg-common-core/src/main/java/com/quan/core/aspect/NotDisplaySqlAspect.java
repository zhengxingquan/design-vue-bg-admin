package com.quan.core.aspect;

import com.quan.ThreadLocalMap;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：
 *
 * The class Not display sql aspect.
 */
@Aspect
@Component
public class NotDisplaySqlAspect {

    /**
     * The constant DISPLAY_SQL.
     */
    public static final String DISPLAY_SQL = "DISPLAY_SQL";

    @Pointcut("@annotation(com.quan.core.annotations.NotDisplaySql)")
    private void myPointCut() {
    }

    /**
     * Before.
     */
    @Before(value = "myPointCut()")
    public void before() {
        ThreadLocalMap.put(DISPLAY_SQL, Boolean.FALSE);
    }

    /**
     * After.
     */
    @After(value = "myPointCut()")
    public void after() {
        ThreadLocalMap.remove(DISPLAY_SQL);
    }
}
