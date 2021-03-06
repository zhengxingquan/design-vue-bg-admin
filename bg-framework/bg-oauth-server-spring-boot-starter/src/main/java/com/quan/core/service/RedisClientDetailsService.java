package com.quan.core.service;

import com.alibaba.fastjson.JSONObject;
import com.quan.core.constant.auth.details.DefaultClientDetails;
import com.quan.core.constant.constant.OAuthConstant;
import com.quan.core.constant.AuthServerErrorCode;
import com.quan.core.exception.AuthClientAuthenticationException;
import com.quan.core.exception.InvalidAuthClientException;
import com.quan.core.json.Jackson2Mapper;
import com.quan.core.json.JacksonMapper;
import com.quan.core.json.JsonMapper;
import com.quan.core.json.NotSupportedJsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/6 15:34
 * 将oauth_client_details表数据缓存到redis，这里做个缓存优化
 * layui模块中有对oauth_client_details的crud， 注意同步redis的数据
 * 注意对oauth_client_details清楚redis db部分数据的清空
 */
@Slf4j
@SuppressWarnings("all")
public final class RedisClientDetailsService extends JdbcClientDetailsService {


    private static final String SELECT_CLIENT_DETAILS_SQL =
            "SELECT id,client_id, client_secret, resource_ids, scope, authorized_grant_types, " +
                    "web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove ,if_limit, limit_count " +
                    "FROM oauth_client_details WHERE client_id = ? AND data_state = 0  ";

    // 扩展 默认的 ClientDetailsService, 增加逻辑删除判断( status = 1)
    private static final String SELECT_FIND_STATEMENT =
            "SELECT id,client_id, client_secret,resource_ids, scope, "
                    + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
                    + "refresh_token_validity, additional_information, autoapprove ,if_limit, limit_count  FROM oauth_client_details WHERE data_state = 0 order by client_id ";


    private RedisTemplate<String, Object> redisTemplate;

    private final JdbcTemplate jdbcTemplate;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisClientDetailsService(DataSource dataSource) {
        super(dataSource);
        // 查询数据库
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        setSelectClientDetailsSql(SELECT_CLIENT_DETAILS_SQL);
        setFindClientDetailsSql(SELECT_FIND_STATEMENT);
    }


    /****
     * 通过 clientId 查找 client
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/6 15:20
     * @param clientId

     * @return org.springframework.security.oauth2.provider.ClientDetails
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        ClientDetails clientDetails = null;

        try {
            // 先从redis获取
            String value = (String) redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).get(clientId);
            if (StringUtils.isBlank(value)) {
                clientDetails = cacheAndGetClient(clientId);
            } else {
                clientDetails = JSONObject.parseObject(value, BaseClientDetails.class);
            }
        } catch (Exception e) {
            log.error("clientId:{},{}", clientId, clientId);
            throw new InvalidAuthClientException(AuthServerErrorCode.AUTH_SERVER_CLIENT_NOT_EXISTS.getMsg());
        }

        return clientDetails;
    }

    /**
     * 缓存client并返回client
     *
     * @param clientId
     * @return
     */
    private ClientDetails cacheAndGetClient(String clientId) {
        // 从数据库读取
        ClientDetails clientDetails = null;

        try {
            clientDetails = jdbcTemplate.queryForObject(SELECT_CLIENT_DETAILS_SQL, new ClientDetailsRowMapper(), clientId);

            if (clientDetails != null) {
                // 写入redis缓存
                redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).put(clientId, JSONObject.toJSONString(clientDetails));
                log.info("缓存clientId:{},{}", clientId, clientDetails);
            }


        } catch (EmptyResultDataAccessException e) {
            log.error("clientId:{},{}", clientId, clientId);
            throw new AuthClientAuthenticationException(AuthServerErrorCode.AUTH_SERVER_CLIENT_IS_DISABLED.getMsg()) ;
        } catch (NoSuchClientException e) {
            log.error("clientId:{},{}", clientId, clientId);
            throw new AuthClientAuthenticationException(AuthServerErrorCode.AUTH_SERVER_CLIENT_IS_DISABLED.getMsg()) ;
        } catch (InvalidClientException e) {
            throw new InvalidAuthClientException(AuthServerErrorCode.AUTH_SERVER_CLIENT_DATA_STATE_ERROR.getMsg());
        }

        return clientDetails;
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
        super.updateClientDetails(clientDetails);
        cacheAndGetClient(clientDetails.getClientId());
    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        super.updateClientSecret(clientId, secret);
        cacheAndGetClient(clientId);
    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {
        super.removeClientDetails(clientId);
        removeRedisCache(clientId);
    }

    /**
     * 删除redis缓存
     *
     * @param clientId
     */
    private void removeRedisCache(String clientId) {
        redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).delete(clientId);
    }

    /**
     * 将oauth_client_details全表刷入redis
     */
    public void loadAllClientToCache() {
        if (redisTemplate.hasKey(OAuthConstant.CACHE_CLIENT_KEY)) {
            return;
        }
        log.info("将oauth_client_details全表刷入redis");

        List<ClientDetails> list = this.listClientDetails();
        if (CollectionUtils.isEmpty(list)) {
            log.error("oauth_client_details表数据为空，请检查");
            return;
        }

        list.parallelStream().forEach(client -> {
            redisTemplate.boundHashOps(OAuthConstant.CACHE_CLIENT_KEY).put(client.getClientId(), JSONObject.toJSONString(client));
        });
    }


    /**
     * 追加if_limit  limit_count
     * DefaultClientDetails
     */
    public List<ClientDetails> listClientDetails() {

        return jdbcTemplate.query(SELECT_FIND_STATEMENT, new ClientDetailsRowMapper());
    }


    /***
     * 结果集处理类
     */
    private static class ClientDetailsRowMapper implements RowMapper<ClientDetails> {

        /**
         * json process
         *
         * @return
         */
        private static JsonMapper createJsonMapper() {
            if (ClassUtils.isPresent("org.codehaus.jackson.map.ObjectMapper", null)) {
                return new JacksonMapper();
            } else if (ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper", null)) {
                return new Jackson2Mapper();
            }
            return new NotSupportedJsonMapper();
        }


        public ClientDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

            // 组装 ClientDetails 对象
            DefaultClientDetails details = new DefaultClientDetails(
                    rs.getString(1),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(7),
                    rs.getString(6));

            // 密码
            details.setClientSecret(rs.getString(2));
            //访问令牌有效性/秒
            if (rs.getObject(8) != null) {
                details.setAccessTokenValiditySeconds(rs.getInt(8));
            }
            //刷新令牌有效性/秒
            if (rs.getObject(9) != null) {
                details.setRefreshTokenValiditySeconds(rs.getInt(9));
            }
            // 其他的信息（默认为 JSON 的字符串）
            String json = rs.getString(10);
            if (json != null) {
                try {
                    // 创建 json 解析器
                    Map<String, Object> additionalInformation = createJsonMapper().read(json, Map.class);
                    details.setAdditionalInformation(additionalInformation);
                } catch (Exception e) {
                    log.warn("Could not decode JSON for additional information: " + details, e);
                }
            }
            // 作用域
            String scopes = rs.getString(11);
            if (scopes != null) {
                details.setAutoApproveScopes(org.springframework.util.StringUtils.commaDelimitedListToSet(scopes));
            }
            // 限流标识
            long ifLimit = rs.getLong(12);
            details.setIfLimit(ifLimit);
            // 限流次数
            long limitCount = rs.getLong(13);
            details.setLimitCount(limitCount);
            // 客户端ID
            details.setId(rs.getLong(14));

            return details;
        }
    }
}
