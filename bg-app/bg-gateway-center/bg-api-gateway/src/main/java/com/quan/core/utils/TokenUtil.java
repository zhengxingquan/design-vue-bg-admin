package com.quan.core.utils;

import java.util.List;

import com.quan.core.constant.constant.OAuthConstant;
import com.quan.core.constant.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;


public class TokenUtil {

	public  static String extractToken(ServerHttpRequest request) {
		List<String> strings = request.getHeaders().get(OAuthConstant.AUTHORIZATION);
		String authToken = "";
		if(!StringUtil.isEmpty(strings) && strings.get(0).contains("Bearer")){
			authToken = strings.get(0).substring("Bearer".length()).trim();
		}
		if (StringUtils.isBlank(authToken)) {
			strings = request.getQueryParams().get(OAuthConstant.TOKEN_PARAM);
			if (!StringUtil.isEmpty(strings)) {
				authToken = strings.get(0);
			}
		}
		return authToken;
	}
}
