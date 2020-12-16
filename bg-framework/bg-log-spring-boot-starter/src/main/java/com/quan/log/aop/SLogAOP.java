package com.quan.log.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.quan.common.auth.details.LoginAppUser;
import com.quan.common.constant.TraceConstant;
import com.quan.common.model.SysLog;
import com.quan.common.util.SysUserUtil;
import com.quan.log.annotation.SLog;
import com.quan.log.service.LogService;
import com.quan.log.util.RequestUtil;
import com.quan.log.util.TraceUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.task.TaskExecutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/***
 *  日志AOP,标准日志格式logback-spring.xml
 *  如果开启日志记录，需要多数据配置
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 17:17
 */
@Slf4j
@Aspect
@Order(-1) // 保证该AOP在@Transactional之前执行
public class SLogAOP {


    @Autowired(required = false)
    private LogService logService;

    @Autowired
    private TaskExecutor taskExecutor;

    private static final int MAX_SIZE = 2000;


    @Around("@annotation(ds)")
    public Object logSave(ProceedingJoinPoint joinPoint, SLog ds) throws Throwable {

        // 请求流水号
        String traceId = StringUtils.defaultString(TraceUtil.getTrace(), MDC.get(TraceConstant.LOG_TRACE_ID));
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 获取方法参数
        String url = null;
        String httpMethod = null;
        List<Object> httpReqArgs = new ArrayList<Object>();
        SysLog sysLog = new SysLog();
        createLog(sysLog);
        LoginAppUser loginAppUser = SysUserUtil.getLoginAppUser();
        if (loginAppUser != null) {
            sysLog.setUsername(loginAppUser.getUsername());
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SLog slog = methodSignature.getMethod().getDeclaredAnnotation(SLog.class);
        sysLog.setModule(slog.module() + ":" + methodSignature.getDeclaringTypeName() + "/" + methodSignature.getName());
        sysLog.setStartTime(new Date());
        Object[] args = joinPoint.getArgs();// 参数值
        url = methodSignature.getDeclaringTypeName() + "/" + methodSignature.getName();
        String params = null;
        for (Object object : args) {
            if (object instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) object;
                url = request.getRequestURI();
                httpMethod = request.getMethod();
            } else if (object instanceof HttpServletResponse) {
            } else {
                httpReqArgs.add(object);
            }
        }

        try {
            params = JSONObject.toJSONString(httpReqArgs);
            if (params.length() > MAX_SIZE) {
                params = params.substring(MAX_SIZE);
            }
            sysLog.setParams(params);
            sysLog.setModule(slog.module());
            // 打印请求参数参数
            log.info("开始请求，traceId={},  url={} , httpMethod={}, reqData={} ", traceId, url, httpMethod, params);
        } catch (Exception e) {
            log.error("记录参数失败：{}", e.getMessage());
        }
        Object result = null;
        try {
            // 调用原来的方法
            result = joinPoint.proceed();
            sysLog.setFlag(Boolean.TRUE);
        } catch (Exception e) {
            sysLog.setFlag(Boolean.FALSE);
            sysLog.setError(e.getMessage());
            log.error("请求报错，traceId={},  url={} , httpMethod={}, reqData={} ,error ={} ", traceId, url, httpMethod, params, e.getMessage());
            throw e;
        } finally {
            sysLog.setEndTime(new Date());
            sysLog.setExcuteTime((System.currentTimeMillis() - start));
            sysLog.setTraceId(traceId);
            //如果需要记录数据库开启异步操作
            CompletableFuture.runAsync(() -> {
                try {
                    log.trace("日志落库开始：{}", sysLog);
                    if (logService != null) {
                        logService.save(sysLog);
                    }
                    log.trace("开始落库结束：{}", sysLog);
                } catch (Exception e) {
                    log.error("落库失败：{}", e.getMessage());
                }
            }, taskExecutor);
            // 获取回执报文及耗时
            log.info("请求完成, traceId={}, 耗时={}, resp={}:", traceId, (System.currentTimeMillis() - start), result == null ? null : JSON.toJSONString(result));
        }
        return result;
    }

    private void createLog(SysLog sysLog) {
        HttpServletRequest request = RequestUtil.getRequest();
        String requestURI = request.getRequestURI();
        final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取客户端操作系统
        final String os = userAgent.getOperatingSystem().getName();
        //获取客户端浏览器
        final String browser = userAgent.getBrowser().getName();
        final String ipAddress = RequestUtil.getRemoteAddr(request);

        sysLog.setIp(ipAddress);
        sysLog.setOs(os);
        sysLog.setBrowser(browser);
        sysLog.setRequestUrl(requestURI);
    }
}