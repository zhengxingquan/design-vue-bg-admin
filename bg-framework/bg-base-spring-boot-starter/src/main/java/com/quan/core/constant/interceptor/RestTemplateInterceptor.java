package com.quan.core.constant.interceptor;

import cn.hutool.core.util.StrUtil;
import com.quan.core.constant.constant.OAuthConstant;
import com.quan.core.constant.constant.TraceConstant;
import com.quan.core.constant.util.StringUtil;
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


/****
 * RestTemplate 请求拦截器
 * @author zxq(956607644 @ qq.com)
 * @date 2021/5/6 19:51
 *
 * https://gitee.com/owenwangwen/open-capacity-platform
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
