package com.quan.core.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.quan.core.common.constant.OAuthConstant;
import com.quan.core.common.constant.TraceConstant;
import com.quan.core.common.util.StringUtil;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * blog: https://blog.51cto.com/13005375
 * code: https://gitee.com/owenwangwen/open-capacity-platform
 */
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;

        HttpServletRequest httpRequest = attributes.getRequest();
        String header = httpRequest.getHeader(OAuthConstant.AUTHORIZATION);


        String token = StringUtil.isBlank(StringUtil.substringAfter(header, OAuth2AccessToken.BEARER_TYPE + " ")) ? httpRequest.getParameter(OAuth2AccessToken.ACCESS_TOKEN) : StringUtil.substringAfter(header, OAuth2AccessToken.BEARER_TYPE + " ");

        token = StringUtil.isBlank(httpRequest.getHeader(OAuthConstant.TOKEN_HEADER)) ? token : httpRequest.getHeader(OAuthConstant.TOKEN_HEADER);


        //传递token
        HttpHeaders headers = request.getHeaders();
        headers.add(OAuthConstant.TOKEN_HEADER, token);

        //传递traceId
        String traceId = StrUtil.isNotEmpty(MDC.get(TraceConstant.LOG_TRACE_ID)) ? MDC.get(TraceConstant.LOG_TRACE_ID) : MDC.get(TraceConstant.LOG_B3_TRACEID);
        if (StrUtil.isNotEmpty(traceId)) {
            headers.add(TraceConstant.HTTP_HEADER_TRACE_ID, traceId);
        }

        // 保证请求继续执行
        return execution.execute(request, body);
    }
}