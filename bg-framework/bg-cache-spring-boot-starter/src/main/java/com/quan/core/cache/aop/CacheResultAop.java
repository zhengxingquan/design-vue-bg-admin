package com.quan.core.cache.aop;

import com.quan.core.cache.annotation.CacheRemove;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Slf4j
@Aspect
//@Order(-1) // 保证该AOP在@Transactional之前执行
public class CacheResultAop {

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(ds)")
    public void exec(ProceedingJoinPoint joinPoint, CacheRemove ds) throws Throwable {
        log.info("CacheRemove exec ....");

    }
    
}
