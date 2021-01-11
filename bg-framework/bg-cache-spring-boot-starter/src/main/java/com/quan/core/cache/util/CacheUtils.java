package com.quan.core.cache.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/11
 * 描述：
 */
@Slf4j
public final class CacheUtils {


    public static boolean set(final RedisTemplate<String, Object> redisTemplate, final String key, final Object value, final long time) {
        try {
            return redisTemplate.execute((RedisCallback<Long>) connection -> {
                byte[] keys = key.getBytes(),
                        values = ByteUtils.toBytes(value);
                connection.set(keys, values);
                if (time > 0) {
                    // TODO 设置 缓存时间
                    connection.expire(keys, time);
                }
                connection.close();
                return 1L;
            }) >= 1L;
        } catch (Exception e) {
            log.error("设置 {} 缓存失败 {}", key, e);
        }
        return false;
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public static <T> T get(final RedisTemplate<String, Object> redisTemplate,String key, Class<T> returnType) {

        if (StringUtils.isBlank(key)) {
            return null;
        }

        return redisTemplate.execute(new RedisCallback<T>() {

            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] temp = connection.get(key.getBytes());
                connection.close();
                return ByteUtils.fromBytes(temp, returnType);
            }
        });
    }


}
