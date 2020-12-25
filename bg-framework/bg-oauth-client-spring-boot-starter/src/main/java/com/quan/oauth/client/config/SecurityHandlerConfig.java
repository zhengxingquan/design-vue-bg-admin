package com.quan.oauth.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quan.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/30 18:48
 */
@Component
@Configuration
@Slf4j
public class SecurityHandlerConfig {

    /***
     *  springmvc启动时自动装配json处理类
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/25 14:25
     * @param null

     * @return
     */
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * 登陆失败
     *
     * @return
     */
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {

        return new AuthenticationFailureHandler() {

            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException exception) throws IOException, ServletException {
                String msg = null;
                if (exception instanceof BadCredentialsException) {
                    msg = "密码错误";
                } else {
                    msg = exception.getMessage();
                }
                log.error("Unauthorized error: {} ", msg);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(
                        objectMapper.writeValueAsString(
                                Result.failed(HttpStatus.UNAUTHORIZED.value(), msg))
                );
                response.getWriter().flush();
                response.getWriter().close();

            }
        };

    }


    /**
     * 未登录，返回401
     *
     * @return
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {

            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) throws IOException, ServletException {

                log.error("Unauthorized error: {} ", authException);

                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(
                        objectMapper.writeValueAsString(
                                Result.failed(HttpStatus.UNAUTHORIZED.value(), authException.getMessage()))
                );
                response.getWriter().flush();
                response.getWriter().close();

            }
        };
    }

    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }

    /**
     * 处理spring security oauth 处理失败返回消息格式
     */
    @Bean
    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler() {

            @Override
            public void handle(HttpServletRequest request,
                               HttpServletResponse response,
                               AccessDeniedException authException) throws IOException, ServletException {

				log.error("Unauthorized error: {} ", authException);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(objectMapper.writeValueAsString(
                        Result.failed(HttpStatus.UNAUTHORIZED.value(), authException.getMessage())));
                response.getWriter().flush();
                response.getWriter().close();

            }
        };
    }


}
