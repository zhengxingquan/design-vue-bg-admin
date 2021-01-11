package com.quan.core.cache.aop;

import com.quan.core.cache.annotation.CacheDefaults;
import com.quan.core.cache.annotation.CacheRemoveAll;
import com.quan.core.cache.constant.CacheCons;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 * <p>
 * 缓存删除注解
 */
@Slf4j
@Aspect
//@Order(-1) // 保证该AOP在@Transactional之前执行
public class CacheRemoveAllAop extends BaseCacheAop {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(ds)")
    public Object exec(ProceedingJoinPoint joinPoint, CacheRemoveAll ds) throws Throwable {

        log.info("CacheRemoveAll exec ....");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        CacheRemoveAll cacheRemoveAll = method.getAnnotation(CacheRemoveAll.class);
        // TODO 得到缓存名称
        String cacheName = cacheRemoveAll.cacheName();
        if (StringUtils.isBlank(cacheName)) {
            // TODO 查看类上有没有缓存名称
            CacheDefaults cacheDefaults = method.getDeclaringClass().getAnnotation(CacheDefaults.class);
            if (cacheDefaults == null || StringUtils.isBlank(cacheRemoveAll.cacheName())) {
                cacheName = "bg";
            } else {
                cacheName = cacheDefaults.cacheName();
            }
        }
        log.info("delete redis cache key {}", cacheName);

        String key = CacheCons.REDIS_PREFIX + cacheName + ":*";
        // TODO 是否存在 KEY 的数据
        Set<String> hasKeys = redisTemplate.keys(key);
        if (CollectionUtils.isNotEmpty(hasKeys)) {
            this.redisTemplate.delete(hasKeys);
        }
        // TODO 继续执行下面的方法
        return joinPoint.proceed();
    }

}
