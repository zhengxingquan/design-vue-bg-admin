package com.quan.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.core.common.constant.OAuthConstant;
import com.quan.core.common.exception.service.ServiceException;
import com.quan.core.common.model.SysClient;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.Result;
import com.quan.core.constant.AuthErrorCode;
import com.quan.core.controller.request.client.QueryClientPageRequest;
import com.quan.core.controller.request.client.QueryClientRequest;
import com.quan.core.dao.SysClientDao;
import com.quan.core.dao.SysClientServiceDao;
import com.quan.core.factory.AuthClientFactory;
import com.quan.core.service.SysClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class SysClientServiceImpl implements SysClientService {

    @Autowired
    private SysClientDao sysClientDao;
    @Autowired
    private SysClientServiceDao sysClientServiceDao;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JdbcClientDetailsService jdbcClientDetailsService;
    @Autowired
    private TransactionTemplate template;


    @Override
    @Transactional
    public Result saveOrUpdate(SysClient sysClient) {
        sysClient.setClientSecret(passwordEncoder.encode(sysClient.getClientSecretStr()));
        if (Objects.isNull(sysClient.getId())) {
            SysClient client = sysClientDao.getClient(sysClient.getClientId());
            if (Objects.nonNull(client)) {
                return JsonResult.failed(AuthErrorCode.CLIENT_EXISTS_ERROR.getMsg());
            }
            sysClientDao.save(sysClient);
        } else {
            sysClientDao.updateByPrimaryKey(sysClient);
        }
        return JsonResult.succeed();
    }


    @Override
    public void delete(Long id) {
        template.execute(transactionStatus -> {
            SysClient client = sysClientDao.getById(id);
            if (Objects.isNull(client)) {
                throw new ServiceException(AuthErrorCode.CLIENT_NOT_EXISTS_ERROR.getMsg());
            }
            sysClientDao.delete(id);
            sysClientServiceDao.delete(id, null);
            redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).delete(client.map().getClientId());
            log.debug("删除应用id:{}", id);
            return true;
        });
    }

    @Override
    public PageResult<SysClient> list(QueryClientPageRequest client) {

        try {
            //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
            PageHelper.startPage(client.getPageNumber(), client.getPageSize(), true);
            List<SysClient> list = sysClientDao.findList(AuthClientFactory.newInstance(client));
            PageInfo<SysClient> pageInfo = new PageInfo<>(list);
            return PageResult.<SysClient>builder().data(pageInfo.getList()).code(0).count(pageInfo.getTotal()).build();
        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }

    public SysClient getById(Long id) {
        try {
            return sysClientDao.getById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<SysClient> data(QueryClientRequest client) {
        return sysClientDao.data(AuthClientFactory.newInstance(client));
    }


    @Override
    public Result updateEnabled(Map<String, Object> params) {
        try {
            Long id = MapUtils.getLong(params, "id");
            Boolean enabled = MapUtils.getBoolean(params, "status");
            SysClient client = sysClientDao.getById(id);
            if (client == null) {
                return JsonResult.failed("应用不存在");
                //throw new IllegalArgumentException("用户不存在");
            }
            client.setStatus(enabled);

            int i = sysClientDao.updateByPrimaryKey(client);

            ClientDetails clientDetails = client.map();

            if (enabled) {
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).put(client.getClientId(), JSONObject.toJSONString(clientDetails));
            } else {
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).delete(client.getClientId());
            }

            log.info("应用状态修改：{}", client);

            return i > 0 ? JsonResult.succeed(client, "更新成功") : JsonResult.failed("更新失败");
        } catch (InvalidClientException e) {
            throw new ServiceException(e);
        }
    }

}
