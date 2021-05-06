package com.quan.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.quan.core.constant.constant.OAuthConstant;
import com.quan.core.constant.exception.service.ServiceException;
import com.quan.core.constant.model.SysClient;
import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.Result;
import com.quan.core.constant.AuthErrorCode;
import com.quan.core.controller.request.client.QueryClientPageRequest;
import com.quan.core.controller.request.client.QueryClientRequest;
import com.quan.core.controller.request.token.create.ClientCreateRequest;
import com.quan.core.controller.request.token.update.ClientUpdateRequest;
import com.quan.core.dao.SysClientDao;
import com.quan.core.dao.SysClientServiceDao;
import com.quan.core.dto.client.AuthClientCreateDTO;
import com.quan.core.dto.client.AuthClientUpdateDTO;
import com.quan.core.dto.client.QueryClientDTO;
import com.quan.core.dto.client.QueryPageDTO;
import com.quan.core.factory.AuthClientFactory;
import com.quan.core.service.SysClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Collections;
import java.util.List;
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
    @Autowired
    private IUidGenerator uidGenerator;

    @Override
    @Transactional
    public Result save(ClientCreateRequest request) {
        AuthClientCreateDTO create = AuthClientFactory.newInstance(uidGenerator, request);
        create.setClientSecret(passwordEncoder.encode(create.getClientSecretStr()));
        SysClient client = sysClientDao.getClient(create.getClientId());
        if (Objects.nonNull(client)) {
            return JsonResult.failed(AuthErrorCode.CLIENT_EXISTS_ERROR.getMsg());
        }
        sysClientDao.save(create);
        return JsonResult.succeed();
    }

    @Override
    @Transactional
    public Result update(ClientUpdateRequest request) {
        AuthClientUpdateDTO update = AuthClientFactory.newInstance(uidGenerator, request);
        update.setClientSecret(passwordEncoder.encode(update.getClientSecretStr()));
        sysClientDao.updateByPrimaryKey(update);
        return JsonResult.succeed();
    }

    @Override
    public void delete(Long id) {
        deletes(Lists.newArrayList(id));
    }

    @Override
    public void deletes(List<Long> ids) {
        template.execute(transactionStatus -> {
            for (Long id : ids) {
                SysClient client = sysClientDao.getById(id);
                if (Objects.isNull(client)) {
                    throw new ServiceException(AuthErrorCode.CLIENT_NOT_EXISTS_ERROR.getMsg());
                }
                sysClientDao.delete(id);
                sysClientServiceDao.delete(id, null);
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).delete(client.map().getClientId());
                log.debug("删除应用id:{}", id);
            }
            return true;
        });

    }

    @Override
    public PageResult<QueryPageDTO> list(QueryClientPageRequest client) {


        try {
            //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
//            PageHelper.startPage(client.getPageNumber(), client.getPageSize(), true);
//            List<SysClient> list = sysClientDao.findList(AuthClientFactory.newInstance(client));
//            PageInfo<SysClient> pageInfo = new PageInfo<>(list);
//            return PageResult.<SysClient>builder().data(pageInfo.getList()).code(0).count(pageInfo.getTotal()).build();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return null;

    }

    public QueryClientDTO getById(Long id) {
        SysClient client = sysClientDao.getById(id);
        if (Objects.isNull(client)) {
            return QueryClientDTO.builder().build();
        }
        return AuthClientFactory.newInstance(client);
    }

    @Override
    public List<QueryClientDTO> data(QueryClientRequest client) {
        List<SysClient> data = sysClientDao.data(AuthClientFactory.newInstance(client));
        if (CollectionUtils.isEmpty(data)) {
            return Collections.EMPTY_LIST;
        }
        return AuthClientFactory.newInstance(data);
    }

    @Override
    public Result enable(Long id) {
        batchEnable(Lists.newArrayList(id));
        return JsonResult.succeed();
    }

    @Override
    public Result disable(Long id) {
        batchDisable(Lists.newArrayList(id));
        return JsonResult.succeed();
    }

    @Override
    public Result batchEnable(final List<Long> ids) {
        template.execute(transactionStatus -> {
            sysClientDao.enable(ids);
            List<SysClient> clients = sysClientDao.findAllByIds(ids);
            for (SysClient client : clients) {
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).put(client.getClientId(),
                        JSONObject.toJSONString(client.map()));
            }
            return true;
        });
        return Result.succeed();
    }

    @Override
    public Result batchDisable(List<Long> ids) {
        template.execute(transactionStatus -> {
            sysClientDao.disable(ids);
            List<SysClient> clients = sysClientDao.findAllByIds(ids);
            for (SysClient client : clients) {
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).delete(client.getClientId());
            }
            return true;
        });
        return Result.succeed();
    }
}
