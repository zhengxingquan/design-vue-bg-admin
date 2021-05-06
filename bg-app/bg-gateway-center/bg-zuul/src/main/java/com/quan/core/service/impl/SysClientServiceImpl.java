package com.quan.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.quan.core.constant.constant.OAuthConstant;
import com.quan.core.constant.exception.service.ServiceException;
import com.quan.core.constant.model.SysClient;
import com.quan.core.constant.model.SysService;
import com.quan.core.constant.AuthServerErrorCode;
import com.quan.core.dao.SysClientDao;
import com.quan.core.dao.SysServiceDao;
import com.quan.core.service.SysClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 作者 owen
 * @version 创建时间：2018年4月5日 下午19:52:21
 * 类说明 查询应用绑定的资源权限
 * blog:https://blog.51cto.com/13005375
 * code:https://gitee.com/owenwangwen/open-capacity-platform
 */
@Slf4j
@Service
public class SysClientServiceImpl implements SysClientService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private SysClientDao sysClientDao;
    @Autowired
    private SysServiceDao sysServiceDao;

    public SysClient findClientByClientId(String clientId) {
        // 先从redis获取
        SysClient client = null;
        String value = (String)
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).get(clientId);
        // 没有从数据库获取并缓存
        if (StringUtils.isBlank(value)) {
            client = cacheAndGetClient(clientId);
        } else {
            client = JSONObject.parseObject(value, SysClient.class);
        }
        return client;
    }

    private SysClient cacheAndGetClient(String clientId) {

        // 从数据库读取
        SysClient client = sysClientDao.findClientByClientId(clientId);
        if (Objects.isNull(client)) {
            throw new ServiceException(AuthServerErrorCode.AUTH_SERVER_CLIENT_DATA_STATE_ERROR.getMsg());
        }
        // 写入redis缓存
        redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY)
                .put(clientId, JSONObject.toJSONString(client.map()));
        log.info("缓存clientId:{},{}", clientId, client);

        return client;
    }

    @Cacheable(value = "sys:client:service", key = "#clientId")
    public List<SysService> findAllClientByClientId(Long clientId) {
        return sysServiceDao.findAllClientByClientId(clientId);
    }

}
