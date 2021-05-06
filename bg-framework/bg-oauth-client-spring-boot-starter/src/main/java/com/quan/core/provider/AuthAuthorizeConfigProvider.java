package com.quan.core.provider;

import com.quan.core.constant.auth.props.PermitUrlProperties;
import com.quan.core.authorize.AuthorizeConfigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/***
 *  白名单
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/30 18:57
 */
@Component
@Order(Integer.MAX_VALUE - 1)
@EnableConfigurationProperties(PermitUrlProperties.class)
public class AuthAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired(required = false)
    private PermitUrlProperties permitUrlProperties;

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        // 免token登录设置
        config.antMatchers(permitUrlProperties.getIgnored()).permitAll();
        config.requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll();//监控断点放权
        //前后分离时需要带上
        config.antMatchers(HttpMethod.OPTIONS).permitAll();

        return true;
    }

}
