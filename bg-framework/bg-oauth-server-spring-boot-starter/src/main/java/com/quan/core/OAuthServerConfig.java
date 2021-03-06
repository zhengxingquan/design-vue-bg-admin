
package com.quan.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quan.core.constant.auth.props.PermitUrlProperties;
import com.quan.core.constant.constant.OAuthConstant;
import com.quan.core.constant.feign.FeignInterceptorConfig;
import com.quan.core.constant.rest.RestTemplateConfig;
import com.quan.core.constant.util.Strings;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.service.RedisAuthorizationCodeServices;
import com.quan.core.service.RedisClientDetailsService;
import com.quan.core.service.ValidateCodeService;
import com.quan.core.token.PasswordEnhanceTokenGranter;
import com.quan.core.token.SMSCodeTokenGranter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenGranter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.implicit.ImplicitTokenGranter;
import org.springframework.security.oauth2.provider.refresh.RefreshTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * spring security 配置类
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/29 22:11
 */

@Configuration
@Import({RestTemplateConfig.class, FeignInterceptorConfig.class})
public class OAuthServerConfig {


    /**
     * 声明 ClientDetails实现（用 redis 缓存 客户端的 信息 ）
     */
    @Bean
    public RedisClientDetailsService redisClientDetailsService(DataSource dataSource, RedisTemplate<String, Object> redisTemplate) {
        RedisClientDetailsService clientDetailsService = new RedisClientDetailsService(dataSource);
        clientDetailsService.setRedisTemplate(redisTemplate);
        return clientDetailsService;
    }


    /***
     *   认证 code
     *
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/6 15:42
     * @param redisTemplate

     * @return org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices
     */
    @Bean
    public RandomValueAuthorizationCodeServices authorizationCodeServices(RedisTemplate<String, Object> redisTemplate) {
        RedisAuthorizationCodeServices redisAuthorizationCodeServices = new RedisAuthorizationCodeServices();
        redisAuthorizationCodeServices.setRedisTemplate(redisTemplate);
        return redisAuthorizationCodeServices;
    }

    /***
     *  DefaultTokenServices默认处理
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/6 15:42
     */
    @Component
    @Configuration
    // 启动 认证服务
    @EnableAuthorizationServer
    @AutoConfigureAfter(AuthorizationServerEndpointsConfigurer.class)
    public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
        /**
         * 注入authenticationManager 来支持 password grant type
         */
        @Autowired
        private AuthenticationManager authenticationManager;

        /****
         * 用户具体的 查询 service
         */
        @Autowired
        private UserDetailsService userDetailsService;

        /****
         * 用户输入的验证码 service
         */
        @Autowired
        private ValidateCodeService validateCodeService;

        @Autowired(required = false)
        private TokenStore tokenStore;

        @Autowired(required = false)
        private JwtAccessTokenConverter jwtAccessTokenConverter;

        /***
         * 网络响应异常处理类
         */
        @Autowired
        private WebResponseExceptionTranslator webResponseExceptionTranslator;

        /***
         * 客户端server
         */
        @Autowired
        private RedisClientDetailsService redisClientDetailsService;

        @Autowired(required = false)
        private RandomValueAuthorizationCodeServices authorizationCodeServices;


        /**
         * 配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
         */
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

            //通用处理
            endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
                    // 支持
                    .userDetailsService(userDetailsService);

            if (tokenStore instanceof JwtTokenStore) {
                endpoints.accessTokenConverter(jwtAccessTokenConverter);
            }

            //处理授权码
            endpoints.authorizationCodeServices(authorizationCodeServices);
            // 处理 ExceptionTranslationFilter 抛出的异常
            endpoints.exceptionTranslator(webResponseExceptionTranslator);

            //处理oauth 模式
            ClientDetailsService clientDetails = endpoints.getClientDetailsService();
            AuthorizationServerTokenServices tokenServices = endpoints.getTokenServices();
            AuthorizationCodeServices authorizationCodeServices = endpoints.getAuthorizationCodeServices();
            OAuth2RequestFactory requestFactory = endpoints.getOAuth2RequestFactory();

            //tokenGranters添加oauth模式 ，可以让/oauth/token支持自定义模式，继承AbstractTokenGranter 扩展 
            List<TokenGranter> tokenGranters = new ArrayList<>();
            //客户端模式   GRANT_TYPE = "client_credentials"; 
            tokenGranters.add(new ClientCredentialsTokenGranter(tokenServices, clientDetails, requestFactory));
            //密码模式	  GRANT_TYPE = "password"; 	
            tokenGranters.add(new PasswordEnhanceTokenGranter(authenticationManager, tokenServices, clientDetails, requestFactory, validateCodeService));
            //授权码模式   GRANT_TYPE = "authorization_code";
            tokenGranters.add(new AuthorizationCodeTokenGranter(tokenServices, authorizationCodeServices, clientDetails, requestFactory));
            //刷新模式	  GRANT_TYPE = "refresh_token";
            tokenGranters.add(new RefreshTokenGranter(tokenServices, clientDetails, requestFactory));
            //简易模式	  GRANT_TYPE = "implicit";
            tokenGranters.add(new ImplicitTokenGranter(tokenServices, clientDetails, requestFactory));
            //短信模式	  GRANT_TYPE = "sms"; 参考ResourceOwnerPasswordTokenGranter重写
            tokenGranters.add(new SMSCodeTokenGranter(userDetailsService, validateCodeService, tokenServices, clientDetails, requestFactory));
            //组合模式
            endpoints.tokenGranter(new CompositeTokenGranter(tokenGranters));


        }

        /**
         * 配置应用名称 应用id
         * 配置OAuth2的客户端相关信息
         */
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            clients.withClientDetails(redisClientDetailsService);
            // 配置新缓存到 redis
            redisClientDetailsService.loadAllClientToCache();
        }

        /**
         * 对应于配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
         */
        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

            // url:/oauth/token_key,exposes
            security.tokenKeyAccess("permitAll()")
                    /// public key for token
                    /// verification if using
                    /// JWT tokens
                    // url:/oauth/check_token
                    .checkTokenAccess("isAuthenticated()")
                    // allow check token
                    .allowFormAuthenticationForClients();

        }

    }

    @Configuration
    @EnableResourceServer
    @EnableConfigurationProperties(PermitUrlProperties.class)
    public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

        @Autowired
        private PermitUrlProperties permitUrlProperties;
        @Autowired(required = false)
        private TokenStore tokenStore;
        @Autowired
        private ObjectMapper objectMapper; //springmvc启动时自动装配json处理类

        @Autowired
        private OAuth2WebSecurityExpressionHandler expressionHandler;

        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/health");
            web.ignoring().antMatchers("/oauth/user/token");
            web.ignoring().antMatchers("/oauth/client/token");
        }

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

            if (tokenStore != null) {
                resources.tokenStore(tokenStore);
            }
            resources.stateless(true);
            resources.expressionHandler(expressionHandler);

            // 自定义异常处理端口
            resources.authenticationEntryPoint(new AuthenticationEntryPoint() {
                @Override
                public void commence(HttpServletRequest request, HttpServletResponse response,
                                     AuthenticationException e) throws IOException, ServletException {

                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write(objectMapper.writeValueAsString(
                            JsonResult.failed(HttpStatus.UNAUTHORIZED.value(), e.getMessage())
                    ));
                    response.getWriter().flush();
                    response.getWriter().close();
                }
            });
            resources.accessDeniedHandler(new OAuth2AccessDeniedHandler() {

                @Override
                public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write(objectMapper.writeValueAsString(
                            JsonResult.failed(HttpStatus.UNAUTHORIZED.value(), e.getMessage())
                    ));
                    response.getWriter().flush();
                    response.getWriter().close();
                }
            });

        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.requestMatcher(
                    /**
                     * 判断来源请求是否包含oauth2授权信息
                     */
                    new RequestMatcher() {

                        private AntPathMatcher antPathMatcher = new AntPathMatcher();

                        @Override
                        public boolean matches(HttpServletRequest request) {

                            String accessToken = Strings.sNull(request.getParameter(OAuth2AccessToken.ACCESS_TOKEN));
                            // 请求参数中包含access_token参数
                            if (Strings.isNotBlank(accessToken)) {
                                return true;
                            }
                            // 头部的Authorization值以Bearer开头
                            String auth = request.getHeader(OAuthConstant.AUTHORIZATION);
                            if (auth != null) {
                                if (auth.startsWith(OAuth2AccessToken.BEARER_TYPE)) {
                                    return true;
                                }
                            }

                            // 认证中心url特殊处理，返回true的，不会跳转login.html页面
                            if (antPathMatcher.match(request.getRequestURI(), "/api-auth/oauth/userinfo")) {
                                return true;
                            }
                            if (antPathMatcher.match(request.getRequestURI(), "/api-auth/oauth/remove/token")) {
                                return true;
                            }
                            if (antPathMatcher.match(request.getRequestURI(), "/api-auth/oauth/get/token")) {
                                return true;
                            }
                            if (antPathMatcher.match(request.getRequestURI(), "/api-auth/oauth/refresh/token")) {
                                return true;
                            }
                            if (antPathMatcher.match(request.getRequestURI(), "/api-auth/oauth/token/list")) {
                                return true;
                            }
                            if (antPathMatcher.match("/**/clients/**", request.getRequestURI())) {
                                return true;
                            }
                            if (antPathMatcher.match("/**/services/**", request.getRequestURI())) {
                                return true;
                            }
                            if (antPathMatcher.match("/**/redis/**", request.getRequestURI())) {
                                return true;
                            }

                            return false;
                        }
                    }

            ).authorizeRequests().antMatchers(permitUrlProperties.getIgnored()).permitAll()
                    .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                    .anyRequest()
                    .authenticated();
        }

    }


}
