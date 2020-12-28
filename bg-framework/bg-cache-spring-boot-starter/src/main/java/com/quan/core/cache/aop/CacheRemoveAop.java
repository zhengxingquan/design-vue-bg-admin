package com.quan.core.cache.aop;

import com.quan.core.cache.annotation.CacheRemove;
import com.quan.core.cache.util.Strings;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(ds)")
    public void exec(ProceedingJoinPoint joinPoint, CacheRemove ds) throws Throwable {
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
//            String key = new CharSegment(cacheKey);
//            if (key.hasKey()) {
//                Map<String, Object> ctx = new LinkedHashMap<>();
//                Object[] args = joinPoint.getArgs();
//                List<String> names = MethodParamNamesScaner.getParamNames(method);//不支持nutz低于1.60的版本
//                if (names != null) {
//                    for (int i = 0; i < names.size() && i < args.length; i++) {
//                        ctx.set(names.get(i), args[i]);
//                    }
//                }
//                ctx.set("args", args);
//                Context _ctx = Lang.context();
//                for (String key : key.keys()) {
//                    _ctx.set(key, new El(key).eval(ctx));
//                }
//                cacheKey = key.render(_ctx).toString();
//            } else {
//                cacheKey = key.getOrginalString();
//            }
        }
    }

}
