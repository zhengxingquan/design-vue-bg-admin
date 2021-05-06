package com.quan.core.constant.interceptor;

import com.alibaba.fastjson.JSON;
import com.quan.core.constant.annotation.AccessLimit;
import com.quan.core.constant.auth.details.LoginAppUser;
import com.quan.core.constant.util.SysUserUtil;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.util.RedisUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/***
 * 非网关部分应用次数限制
 * @author zxq(956607644@qq.com)
 * @date 2021/5/6 18:50
 */

@AllArgsConstructor
@SuppressWarnings("all")
public class AccessLimitInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {

            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean needLogin = accessLimit.needLogin();
            String key = request.getRequestURI();
            if (needLogin) {
                LoginAppUser user = SysUserUtil.getLoginAppUser();
                if (user == null) {
                    render(response, JsonResult.failed("用户鉴权异常！"));
                    return false;
                }
                key += ":" + user.getId();
            } else {
                // do nothing
            }

            if (!redisUtil.hasKey(key) || redisUtil.getExpire(key) <= 0) {
                redisUtil.set(key, 0, seconds);
            }
            if (redisUtil.incr(key, 1) > maxCount) {
                render(response, JsonResult.failed("访问太频繁！"));
                return false;
            }

        }
        return true;
    }

    private void render(HttpServletResponse response, Result result) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str = JSON.toJSONString(result);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

}
