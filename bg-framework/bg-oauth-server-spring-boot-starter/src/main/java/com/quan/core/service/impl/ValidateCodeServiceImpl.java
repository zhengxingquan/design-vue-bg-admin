package com.quan.core.service.impl;

import com.quan.core.constant.util.Strings;
import com.quan.core.constant.ValidateParamConstant;
import com.quan.core.service.ValidateCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zlt
 * @date 2018/12/10
 */
@Service
@SuppressWarnings("all")
public class ValidateCodeServiceImpl implements ValidateCodeService {


    private final static String REDIS_DEFAULT_CODE_KEY_PREV = "DEFAULT_CODE_KEY:";
    private final static long REDIS_DEFAULT_CODE_KEY_TIME = 60L * 5L;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 保存用户验证码，和randomStr绑定
     *
     * @param deviceId  客户端生成
     * @param imageCode 验证码信息
     */
    @Override
    public void saveImageCode(String deviceId, String imageCode) {

        String text = imageCode.toLowerCase().toString();

        /***
         * 存入 redis 中
         */
        redisTemplate.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {

                byte[] keys = buildKey(deviceId).getBytes();
                // redis info
                connection.set(keys, imageCode.getBytes());
                // 设置过期时间
                connection.expire(keys, REDIS_DEFAULT_CODE_KEY_TIME);
                connection.close();

                return "";
            }
        });

    }

    /**
     * 获取验证码
     *
     * @param deviceId 前端唯一标识/手机号
     */

    @Override
    public String getCode(String deviceId) {

        String code = "";
        try {
            code = redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {

                    // redis info
                    byte[] temp = connection.get(buildKey(deviceId).getBytes());
                    connection.close();
                    return new String(temp);
                }
            });
        } catch (Exception e) {
            throw new AuthenticationException("验证码不存在") {
            };
        }

        return code;

    }

    /**
     * 删除验证码
     *
     * @param deviceId 前端唯一标识/手机号
     */
    @Override
    public void remove(String deviceId) {
        redisTemplate.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {

                // redis info
                connection.del(buildKey(deviceId).getBytes());
                connection.close();

                return "";
            }
        });
    }

    /**
     * 验证验证码
     */
    @Override
    public void validate(HttpServletRequest request) {

        String deviceId = Strings.sNull(request.getParameter(ValidateParamConstant.DEVICE_ID));
        if (Strings.isBlank(deviceId)) {
            throw new AuthenticationException("请在请求参数中携带deviceId参数") {
            };
        }
        String codeInRequest = "", code = Strings.sNull(this.getCode(deviceId));
        if (Strings.isBlank(code)) {
            throw new AuthenticationException("验证码不存在或已过期") {
            };
        }
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request, ValidateParamConstant.VALID_CODE);
        } catch (ServletRequestBindingException e) {
            throw new AuthenticationException("获取验证码的值失败") {
            };
        }
        if (Strings.isBlank(codeInRequest)) {
            throw new AuthenticationException("请填写验证码") {
            };
        }

        if (!StringUtils.equalsIgnoreCase(code, codeInRequest)) {
            throw new AuthenticationException("验证码不正确") {
            };
        }
        this.remove(deviceId);
    }

    private String buildKey(String deviceId) {
        return REDIS_DEFAULT_CODE_KEY_PREV + deviceId;
    }

    @Override
    public void validate(String deviceId, String validCode) {

        if (StringUtils.isBlank(deviceId)) {
            throw new AuthenticationException("请在请求参数中携带deviceId参数") {
            };
        }
        String code = this.getCode(deviceId);

        if (StringUtils.isBlank(validCode)) {
            throw new AuthenticationException("请填写验证码") {
            };
        }

        if (code == null) {
            throw new AuthenticationException("验证码不存在或已过期") {
            };
        }

        if (!StringUtils.equalsIgnoreCase(code, validCode)) {
            throw new AuthenticationException("验证码不正确") {
            };
        }

        this.remove(deviceId);
    }
}
