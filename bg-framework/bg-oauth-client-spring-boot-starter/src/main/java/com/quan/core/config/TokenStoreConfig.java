package com.quan.core.config;

import com.quan.core.token.RedisTemplateTokenStore;
import com.quan.core.token.ResJwtAccessTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.sql.DataSource;

/***
 * redis存储token
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/30 18:46

 * @return
 */
@Configuration
public class TokenStoreConfig {

    @Resource
    private DataSource dataSource;

    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;


    @Bean
    @ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "jdbc", matchIfMissing = false)
    public JdbcTokenStore jdbcTokenStore() {

//		oauth_access_token oauth_refresh_token 创建两张表
//		return new JdbcTokenStore( dataSource ) ;
        return new JdbcTokenStore(dataSource);

    }

    
    /***
     * 默认采用 redis 来存储
     */
    @Bean
    @ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "redis", matchIfMissing = true)
    public RedisTemplateTokenStore redisTokenStore(RedisConnectionFactory connectionFactory) {
        Assert.state(connectionFactory != null, "connectionFactory must be provided");
        RedisTemplateTokenStore redisTemplateStore = new RedisTemplateTokenStore(connectionFactory);
        return redisTemplateStore;


    }

    /***
     *   使用jwt替换原有的uuid生成token方式
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/25 14:41  
     */
    @Configuration
    @ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "jwt", matchIfMissing = false)
    public static class JWTTokenConfig {
        @Bean
        public JwtTokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter accessTokenConverter = new ResJwtAccessTokenConverter();
            accessTokenConverter.setSigningKey("ocp");
            return accessTokenConverter;
        }
    }

}
