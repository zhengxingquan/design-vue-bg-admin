package com.quan.common.util;

import com.quan.common.constant.OAuthConstant;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/***
 *   Token 工具类
 *   从 请求头中 获取 Token 参数
 * @author zxq(956607644@qq.com)
 * @date 2020/12/6 15:16
 */
public class TokenUtil {

    public static String getToken() {
        String token = "";
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

			String header = request.getHeader(OAuthConstant.AUTHORIZATION);

			token = StringUtil.isBlank(StringUtil.substringAfter(header, OAuth2AccessToken.BEARER_TYPE + " ")) ? request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) : StringUtil.substringAfter(header, OAuth2AccessToken.BEARER_TYPE + " ");

			token = StringUtil.isBlank(request.getHeader(OAuthConstant.TOKEN_HEADER)) ? token : request.getHeader(OAuthConstant.TOKEN_HEADER);
		} catch (IllegalStateException e) {
		}
        return token;

    }

}
