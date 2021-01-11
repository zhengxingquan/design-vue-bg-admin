package com.quan.core.cache.aop;

import com.quan.core.cache.annotation.CacheDefaults;
import com.quan.core.cache.annotation.CacheRemove;
import com.quan.core.cache.constant.CacheCons;
import com.quan.core.cache.parser.SpelParseExpressionHandle;
import com.quan.core.cache.util.Strings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Slf4j
@Aspect
//@Order(-1) // 保证该AOP在@Transactional之前执行
public class CacheRemoveAop {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /***
     * 表达式委托
     */
    private final LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();


    @Around("@annotation(ds)")
    public Object exec(ProceedingJoinPoint joinPoint, CacheRemove ds) throws Throwable {
        log.info("CacheRemoveAll exec ....");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        CacheRemove cacheRemove = method.getAnnotation(CacheRemove.class);
        String cacheKey = Strings.sNull(cacheRemove.cacheKey());
        String cacheName = Strings.sNull(cacheRemove.cacheName());

        // TODO 如果 cacheKey 为空，就默认采用 【类名.方法名.参数字符串】 作为 缓存KEY
        if (Strings.isBlank(cacheKey)) {
            cacheKey = method.getDeclaringClass().getName()
                    + "."
                    + method.getName()
                    + "#"
                    + Arrays.toString(joinPoint.getArgs());
        } else {
            // TODO 解析参数是否表达式
            String key = cacheKey;
            SpelParseExpressionHandle parseExpressionDelegation = new SpelParseExpressionHandle();
            if (parseExpressionDelegation.hasExpression(cacheKey)) {
                Object[] args = joinPoint.getArgs();
                //获取被拦截方法参数名列表(使用Spring支持类库)
                String[] names = u.getParameterNames(method);
                if (names != null) {
                    // 设置变量
                    for (int i = 0; i < names.length && i < args.length; i++) {
                        parseExpressionDelegation.setVariable(names[i], args[i]);
                    }
                }
                parseExpressionDelegation.setVariable("args", args);
                // 解析表达式
                cacheKey = parseExpressionDelegation.renderExpression(key, String.class);
            }
        }

        if (Strings.isBlank(cacheName)) {
            CacheDefaults cacheDefaults = method.getDeclaringClass()
                    .getAnnotation(CacheDefaults.class);
            cacheName = cacheDefaults != null ? cacheDefaults.cacheName() : "bg";
        }

        String key = CacheCons.REDIS_PREFIX + cacheName + ":" + cacheKey;
        if (cacheKey.endsWith("*")) {
            redisTemplate.delete(redisTemplate.keys(key));
        } else {
            redisTemplate.delete(key);
        }
        // TODO 继续执行下面的方法
        return joinPoint.proceed();
    }
}
