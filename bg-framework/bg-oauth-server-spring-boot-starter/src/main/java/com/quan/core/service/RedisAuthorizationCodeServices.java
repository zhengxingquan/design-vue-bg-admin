package com.quan.core.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;

import java.util.concurrent.TimeUnit;

/***
 * 替换JdbcAuthorizationCodeServices的存储策略
 * 将存储code到redis，
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/6 15:38
 */
public final class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    // 将存储code到redis，并设置过期时间，10分钟
    private static int REDIS_AUTHORIZATION_CODE_TIME = 10;

    private static String REDIS_AUTHORIZATION_CODE_PREV = "oauth:code:";

    private RedisTemplate<String, Object> redisTemplate;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 替换JdbcAuthorizationCodeServices的存储策略
     * 将存储code到redis，并设置过期时间，10分钟<br>
     */
    @Override
    protected void store(String code, OAuth2Authentication authentication) {

        this.redisTemplate.opsForValue().set(redisKey(code), authentication, REDIS_AUTHORIZATION_CODE_TIME, TimeUnit.MINUTES);
    }

    /***
     *  删除 code
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/6 15:40
     * @param code

     * @return org.springframework.security.oauth2.provider.OAuth2Authentication
     */
    @Override
    protected OAuth2Authentication remove(final String code) {

        String codeKey = redisKey(code);

        OAuth2Authentication token = (OAuth2Authentication) redisTemplate.opsForValue().get(codeKey);

        this.redisTemplate.delete(codeKey);

        return token;
    }

    /**
     * redis中 code key的前缀
     *
     * @param code
     * @return
     */
    private String redisKey(String code) {
        return REDIS_AUTHORIZATION_CODE_PREV + code;
    }
}
