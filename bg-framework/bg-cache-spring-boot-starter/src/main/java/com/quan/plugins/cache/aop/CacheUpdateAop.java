package com.quan.plugins.cache.aop;

import com.quan.plugins.cache.annotation.CacheUpdate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Slf4j
@Aspect
//@Order(-1) // 保证该AOP在@Transactional之前执行
public class CacheUpdateAop {


    @Around("@annotation(ds)")
    public void exec(ProceedingJoinPoint joinPoint, CacheUpdate ds) throws Throwable {
        log.info("CacheUpdate exec ....");

    }

}
