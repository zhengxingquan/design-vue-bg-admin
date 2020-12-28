package com.quan.core.common.feign;

import com.quan.core.common.constant.OAuthConstant;
import com.quan.core.common.constant.TraceConstant;
import com.quan.core.common.util.StringUtil;
import com.quan.core.common.util.Strings;
import com.quan.core.common.util.TokenUtil;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * feign拦截器
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/30 19:00
 */
@Configuration
@Slf4j
public class FeignInterceptorConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {

        RequestInterceptor requestInterceptor = template -> {
            String accessToken = TokenUtil.getToken();
            log.info("feign client request accessToken header : {}", accessToken);
            //传递token 使用feign client访问别的微服务时，将accessToken header
            //config.anyRequest().permitAll() 非强制校验token
            if (StringUtil.isNotBlank(accessToken)) {
                template.header(OAuthConstant.TOKEN_HEADER, TokenUtil.getToken());
//            	template.header(UaaConstant.AUTHORIZATION,  OAuth2AccessToken.BEARER_TYPE  +  " "  +  TokenUtil.getToken() );
            }
            //传递traceId
            String traceId = MDC.get(TraceConstant.LOG_TRACE_ID);
            if (Strings.isBlank(traceId)) {
                traceId = MDC.get(TraceConstant.LOG_B3_TRACEID);
            }
            if (StringUtil.isNotBlank(traceId)) {
                template.header(TraceConstant.HTTP_HEADER_TRACE_ID, traceId);
            }
        };
        return requestInterceptor;
    }
}
