package com.quan.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.quan.core.constant.constant.OAuthConstant;
import com.quan.core.constant.exception.service.ServiceException;
import com.quan.core.constant.model.SysClient;
import com.quan.core.dao.SysClientDao;
import com.quan.core.dao.SysServiceDao;
import com.quan.core.service.ISysClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/4/30
 * 描述：
 */
@Service
@Slf4j
public class SysClientServiceImpl implements ISysClientService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private SysClientDao sysClientDao;
    @Autowired
    private SysServiceDao sysServiceDao ;

    @Override
    public Map getClient(String clientId) {
        // 先从redis获取
        Map client = null;
        String value = (String) redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).get(clientId);
        // 没有从数据库获取
        if (StringUtils.isBlank(value)) {
            client = cacheAndGetClient(clientId);
        } else {
            client = JSONObject.parseObject(value, Map.class);
        }
        return client;
    }

    private Map cacheAndGetClient(String clientId) {
        // 从数据库读取
        Map client = null;
        try {
            client = sysClientDao.getClient(clientId);
            if (client != null) {
                SysClient sysClient = BeanUtil.toBean(client, SysClient.class);
                // 写入redis缓存
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).put(clientId,
                        JSONObject.toJSONString(sysClient.map()));
                log.info("缓存clientId:{},{}", clientId, sysClient);
            }

        } catch (Exception e) {
            throw new ServiceException("应用状态不合法")  ;
        }

        return client;
    }

    @Cacheable(value = "service", key ="#clientId")
    @Override
    public List<Map> listByClientId(Long clientId) {

        return sysServiceDao.listByClientId(clientId);
    }


}
