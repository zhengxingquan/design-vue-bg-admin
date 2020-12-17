package com.quan.plugins.cache.aop;

import com.quan.plugins.cache.annotation.CacheDefaults;
import com.quan.plugins.cache.annotation.CacheRemoveAll;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 *
 * 缓存注解
 */
@Slf4j
@Aspect
//@Order(-1) // 保证该AOP在@Transactional之前执行
public class CacheRemoveAllAop extends BaseCacheAop {

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(ds)")
    public void exec(ProceedingJoinPoint joinPoint, CacheRemoveAll ds) throws Throwable {

        log.info("CacheRemoveAll exec ....");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        CacheRemoveAll cacheRemoveAll = method.getAnnotation(CacheRemoveAll.class);
        // TODO 得到缓存名称
        String cacheName = cacheRemoveAll.cacheName();
        if (StringUtils.isBlank(cacheName)) {
            // TODO 查看类上有没有缓存名称
            CacheDefaults cacheDefaults = method.getDeclaringClass().getAnnotation(CacheDefaults.class);
            if (StringUtils.isBlank(cacheRemoveAll.cacheName())) {
                cacheName = "bg";
            } else {
                cacheName = cacheDefaults.cacheName();
            }
        }
        log.info("delete redis cache key {}", cacheName);
        // TODO redis 配置类
        BoundHashOperations hashOperations = redisTemplate.boundHashOps(getRedisKey(cacheName));
        hashOperations.delete(hashOperations.keys());
        // TODO 执行业务方法
        joinPoint.proceed();
    }

}
