package com.quan.core.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.quan.core.annotation.SLog;
import com.quan.core.constant.auth.details.LoginAppUser;
import com.quan.core.constant.constant.TraceConstant;
import com.quan.core.constant.model.SysLog;
import com.quan.core.constant.util.Strings;
import com.quan.core.constant.util.SysUserUtil;
import com.quan.core.service.LogService;
import com.quan.core.util.RequestUtil;
import com.quan.core.util.TraceUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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


    @Around("@annotation(_slog)")
    public Object logSave(ProceedingJoinPoint joinPoint, SLog _slog) throws Throwable {

        // 请求流水号
        final String traceId = StringUtils.defaultString(TraceUtil.getTrace(), MDC.get(TraceConstant.LOG_TRACE_ID));
        // 记录开始时间
        final long start = System.currentTimeMillis();
        final HttpServletRequest request = RequestUtil.getRequest();
        final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取客户端操作系统
        final String os = userAgent.getOperatingSystem().getName();
        //获取客户端浏览器
        final String browser = userAgent.getBrowser().getName();
        final String ipAddress = RequestUtil.getRemoteAddr(request);

        SysLog sysLog = new SysLog();

        sysLog.setTraceId(traceId);
        sysLog.setStartTime(start);
        sysLog.setIp(ipAddress);
        sysLog.setOs(os);
        sysLog.setBrowser(browser);
        sysLog.setCreateTime(new Date());
        // 设置登录人的信息
        LoginAppUser loginAppUser = SysUserUtil.getLoginAppUser();
        log.info("user info {}", loginAppUser);
        if (loginAppUser != null) {
            log.info("user info {}", loginAppUser);
            sysLog.setUsername(loginAppUser.getUsername());
            sysLog.setCreateUserId(loginAppUser.getId());
        }

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String url = methodSignature.getDeclaringTypeName() + "/" + methodSignature.getName();
        SLog slog = methodSignature.getMethod().getDeclaredAnnotation(SLog.class);
        sysLog.setModule(slog.module());
        sysLog.setRequestUrl(url);

        String httpMethod = request.getMethod();

        // 记录 参数值
        String params = null;
        if (slog.saveRequestData()) {
            Object[] args = joinPoint.getArgs();
            List<Object> httpReqArgs = new ArrayList<Object>(args.length);
            for (Object object : args) {
                if (!(object instanceof HttpServletRequest) && !(object instanceof HttpServletResponse)) {
                    httpReqArgs.add(object);
                }
            }
            if (!httpReqArgs.isEmpty()) {
                params = JSONObject.toJSONString(httpReqArgs);
                sysLog.setParams(splitMessage(params));
            }
        }
        // 打印请求参数参数
        log.info("开始请求，traceId={},  url={} , httpMethod={}, reqData={} ", traceId, url, httpMethod, params);

        Object result = null;
        String responseResultStr = "";
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
            responseResultStr = JSON.toJSONString(result);
            if (slog.saveResponseData()) {
                sysLog.setResponseResult(splitMessage(responseResultStr));
            }
            long end = System.currentTimeMillis();
            sysLog.setEndTime(end);
            //如果需要记录数据库开启异步操作
            if (slog.async()) {
                CompletableFuture.runAsync(() -> {
                    insertLog(sysLog);
                }, taskExecutor);
            } else {
                insertLog(sysLog);
            }
            // 获取回执报文及耗时
            log.info("请求完成, traceId={}, 耗时={}, resp={}:", traceId, (end - start), result == null ? null : responseResultStr);
        }
        return result;
    }

    private String splitMessage(String message) {
        if (Strings.isNotBlank(message)) {
            if (message.length() > MAX_SIZE) {
                message = message.substring(MAX_SIZE);
            }
        }
        return message;

    }

    private void insertLog(SysLog sysLog) {
        try {
            log.trace("日志落库开始：{}", sysLog);
            if (logService != null) {
                logService.save(sysLog);
            }
            log.trace("开始落库结束：{}", sysLog);
        } catch (Exception e) {
            log.error("落库失败：{}", e.getMessage());
        }
    }
}