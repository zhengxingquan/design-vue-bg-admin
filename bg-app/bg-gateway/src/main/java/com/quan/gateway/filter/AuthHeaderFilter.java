
package com.quan.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.quan.PublicUtil;
import com.quan.base.enums.ErrorCodeEnum;
import com.quan.base.exception.BusinessException;
import com.quan.core.interceptor.CoreHeaderInterceptor;
import com.quan.core.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * The class Auth header filter.
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@Component
public class AuthHeaderFilter extends ZuulFilter {

	private static final String BEARER_TOKEN_TYPE = "bearer ";
	private static final String OPTIONS = "OPTIONS";
	private static final String AUTH_PATH = "/auth";
	private static final String LOGOUT_URI = "/oauth/token";
	private static final String ALIPAY_CALL_URI = "/pay/alipayCallback";


	/**
	 * Filter type string.
	 *
	 * @return the string
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * Filter order int.
	 *
	 * @return the int
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * Should filter boolean.
	 *
	 * @return the boolean
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * Run object.
	 *
	 * @return the object
	 */
	@Override
	public Object run() {
		log.info("AuthHeaderFilter - 开始鉴权...");
		RequestContext requestContext = RequestContext.getCurrentContext();
		try {
			doSomething(requestContext);
		} catch (Exception e) {
			log.error("AuthHeaderFilter - [FAIL] EXCEPTION={}", e.getMessage(), e);
			throw new BusinessException(ErrorCodeEnum.UAC10011041);
		}
		return null;
	}

	private void doSomething(RequestContext requestContext) throws ZuulException {
		HttpServletRequest request = requestContext.getRequest();
		String requestURI = request.getRequestURI();

		if (OPTIONS.equalsIgnoreCase(request.getMethod()) || !requestURI.contains(AUTH_PATH) || !requestURI.contains(LOGOUT_URI) || !requestURI.contains(ALIPAY_CALL_URI)) {
			return;
		}
		String authHeader = RequestUtil.getAuthHeader(request);

		if (PublicUtil.isEmpty(authHeader)) {
			throw new ZuulException("刷新页面重试", 403, "check token fail");
		}

		if (authHeader.startsWith(BEARER_TOKEN_TYPE)) {
			requestContext.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);

			log.info("authHeader={} ", authHeader);
			// 传递给后续微服务
			requestContext.addZuulRequestHeader(CoreHeaderInterceptor.HEADER_LABEL, authHeader);
		}
	}

}
