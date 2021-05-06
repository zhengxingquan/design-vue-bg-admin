package com.quan.core.constant.interceptor;

import com.quan.core.constant.annotation.ApiIdempotent;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/***
 * 方法幂登限制
 * @author zxq(956607644@qq.com)
 * @date 2021/5/6 18:51
 */
@AllArgsConstructor
public class ApiIdempotentInterceptor implements HandlerInterceptor {

    private static final String VERSION_NAME = "version";

    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // TODO: 2019-08-27 获取目标方法上的幂等注解
        ApiIdempotent methodAnnotation = method.getAnnotation(ApiIdempotent.class);
        if (methodAnnotation != null) {
            // 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
            checkApiIdempotent(request);
        }
        return true;
    }


    private void checkApiIdempotent(HttpServletRequest request) {
        String version = request.getHeader(VERSION_NAME);
        // header中不存在token
        if (StringUtils.isBlank(version)) {
            version = request.getParameter(VERSION_NAME);
            // parameter中也不存在token
            if (StringUtils.isBlank(version)) {
                throw new IllegalArgumentException("无效的参数");
            }
        }
        if (!redisTemplate.hasKey(version)) {
            throw new IllegalArgumentException("不存在对应的参数");
        }
        Boolean bool = redisTemplate.delete(version);
        if (!bool) {
            throw new IllegalArgumentException("没有删除对应的version");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}