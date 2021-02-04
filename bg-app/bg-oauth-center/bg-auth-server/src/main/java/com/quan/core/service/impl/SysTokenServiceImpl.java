package com.quan.core.service.impl;

import com.google.common.collect.Lists;
import com.quan.core.common.auth.details.LoginAppUser;
import com.quan.core.common.exception.service.ServiceException;
import com.quan.core.common.token.SmsCodeAuthenticationToken;
import com.quan.core.common.web.PageResult;
import com.quan.core.constant.AuthConstant;
import com.quan.core.constant.AuthErrorCode;
import com.quan.core.dto.token.*;
import com.quan.core.eexception.AuthClientAuthenticationException;
import com.quan.core.service.RedisClientDetailsService;
import com.quan.core.service.SysTokenService;
import com.quan.core.utils.SpringUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenGranter;
import org.springframework.security.oauth2.provider.refresh.RefreshTokenGranter;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysTokenServiceImpl implements SysTokenService {

    @Autowired
    private RedisClientDetailsService redisClientDetailsService;
    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private TokenStore tokenStore;

    public void preCheckClient(ClientTokenDTO token) {
        if (StringUtils.isBlank(token.getClientId())) {
            throw new AuthClientAuthenticationException(AuthErrorCode.CLIENT_ID_EMPTY.getMsg());
        }

        if (StringUtils.isBlank(token.getClientSecret())) {
            throw new AuthClientAuthenticationException(AuthErrorCode.CLIENT_SECRET_EMPTY.getMsg());
        }
    }

    private ClientDetails getClientDetails(ClientTokenDTO token) {
        ClientDetails clientDetails = redisClientDetailsService.loadClientByClientId(token.getClientId());
        if (Objects.isNull(clientDetails)) {
            throw new AuthClientAuthenticationException(AuthErrorCode.CLIENT_ID_NOT_EXISTS.getMsg());
        } else if (!passwordEncoder.matches(token.getClientSecret(), clientDetails.getClientSecret())) {
            throw new UnapprovedClientAuthenticationException(AuthErrorCode.CLIENT_SECRET_ERROR.getMsg());
        }
        return clientDetails;
    }

    public OAuth2AccessToken getClientTokenInfo(ClientTokenDTO token) {

        try {
            OAuth2AccessToken oauth2AccessToken = null;
            this.preCheckClient(token);
            ClientDetails clientDetails = getClientDetails(token);

            Map<String, String> map = new HashMap<>();
            map.put(AuthConstant.CLIENT_SECRET, token.getClientSecret());
            map.put(AuthConstant.CLIENT_ID, token.getClientId());
            map.put(AuthConstant.GRANT_TYPE, AuthConstant.CLIENT_CREDENTIALS);

            TokenRequest tokenRequest = new TokenRequest(map, token.getClientId(), clientDetails.getScope(),
                    AuthConstant.CLIENT_CREDENTIALS);

            OAuth2RequestFactory requestFactory = new DefaultOAuth2RequestFactory(redisClientDetailsService);
            ClientCredentialsTokenGranter clientCredentialsTokenGranter = new ClientCredentialsTokenGranter(
                    authorizationServerTokenServices, redisClientDetailsService, requestFactory);

            clientCredentialsTokenGranter.setAllowRefresh(true);
            oauth2AccessToken = clientCredentialsTokenGranter.grant(AuthConstant.CLIENT_CREDENTIALS, tokenRequest);

            return oauth2AccessToken;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public OAuth2AccessToken getUserTokenInfo(UserPasswordTokenDTO ten) {

        try {
            OAuth2AccessToken oauth2AccessToken = null;
            this.preCheckClient(ten);
            ClientDetails clientDetails = getClientDetails(ten);

            TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, ten.getClientId(), clientDetails.getScope(),
                    AuthConstant.CUSTOMER);

            OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(ten.getUserName(), ten.getPassword());

            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            OAuth2Authentication oauth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

            oauth2AccessToken = authorizationServerTokenServices.createAccessToken(oauth2Authentication);

            oauth2Authentication.setAuthenticated(true);

            return oauth2AccessToken;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public OAuth2AccessToken getMobileTokenInfo(ValidCodeTokenDTO ten) {

        try {
            OAuth2AccessToken oauth2AccessToken = null;

            this.preCheckClient(ten);

            ClientDetails clientDetails = getClientDetails(ten);

            TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, ten.getClientId(), clientDetails.getScope(),
                    AuthConstant.CUSTOMER);

            OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

            SmsCodeAuthenticationToken token = new SmsCodeAuthenticationToken(ten.getDeviceId());

            AuthenticationManager authenticationManager = SpringUtil.getBean(AuthenticationManager.class);

            Authentication authentication = authenticationManager.authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            OAuth2Authentication oauth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);

            AuthorizationServerTokenServices authorizationServerTokenServices = SpringUtil
                    .getBean("defaultAuthorizationServerTokenServices", AuthorizationServerTokenServices.class);

            oauth2AccessToken = authorizationServerTokenServices.createAccessToken(oauth2Authentication);

            oauth2Authentication.setAuthenticated(true);
            return oauth2AccessToken;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public PageResult<Map<String, String>> getTokenList(QueryUserTokenPageDTO params) {
        try {
            List<Map<String, String>> list = new ArrayList<>();
            // 根据分页参数获取对应数据
            List<String> keys = findKeysForPage("access:" + "*", params.getPageNumber(), params.getPageSize());

            for (Object key : keys.toArray()) {
                // String key = page;
                // String accessToken = StringUtils.substringAfter(key, "access:");
                // OAuth2AccessToken token =
                // tokenStore.readAccessToken(accessToken);
                OAuth2AccessToken token = (OAuth2AccessToken) redisTemplate.opsForValue().get(key);
                HashMap<String, String> map = new HashMap<String, String>();


                if (token != null) {
                    map.put("token_type", token.getTokenType());
                    map.put("token_value", token.getValue());
                    map.put("expires_in", token.getExpiresIn() + "");
                }
                OAuth2Authentication oAuth2Auth = tokenStore.readAuthentication(token);
                Authentication authentication = oAuth2Auth.getUserAuthentication();

                map.put("client_id", oAuth2Auth.getOAuth2Request().getClientId());
                map.put("grant_type", oAuth2Auth.getOAuth2Request().getGrantType());

                if (authentication instanceof UsernamePasswordAuthenticationToken) {
                    UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;

                    if (authenticationToken.getPrincipal() instanceof LoginAppUser) {
                        LoginAppUser user = (LoginAppUser) authenticationToken.getPrincipal();
                        map.put("user_id", user.getId() + "");
                        map.put("user_name", user.getUsername() + "");
                        map.put("user_head_imgurl", user.getHeadImgUrl() + "");
                    }

                } else if (authentication instanceof PreAuthenticatedAuthenticationToken) {
                    // 刷新token方式
                    PreAuthenticatedAuthenticationToken authenticationToken = (PreAuthenticatedAuthenticationToken) authentication;
                    if (authenticationToken.getPrincipal() instanceof LoginAppUser) {
                        LoginAppUser user = (LoginAppUser) authenticationToken.getPrincipal();
                        map.put("user_id", user.getId() + "");
                        map.put("user_name", user.getUsername() + "");
                        map.put("user_head_imgurl", user.getHeadImgUrl() + "");
                    }

                }
                list.add(map);

            }

            return PageResult.<Map<String, String>>builder().data(list).code(0).count((long) keys.size()).build();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    // 支持单机 集群模式替换keys *的危险操作
    public List<String> findKeysForPage(String patternKey, int pageNum, int pageSize) {

        try {
            Set<String> execute = redisTemplate.execute(new RedisCallback<Set<String>>() {

                @Override
                public Set<String> doInRedis(RedisConnection connection) throws DataAccessException {

                    Set<String> binaryKeys = new HashSet<>();

                    Cursor<byte[]> cursor = connection
                            .scan(new ScanOptions.ScanOptionsBuilder().match(patternKey).count(1000).build());
                    int tmpIndex = 0;
                    int startIndex = (pageNum - 1) * pageSize;
                    int end = pageNum * pageSize;
                    while (cursor.hasNext()) {
                        if (tmpIndex >= startIndex && tmpIndex < end) {
                            binaryKeys.add(new String(cursor.next()));
                            tmpIndex++;
                            continue;
                        }

                        // 获取到满足条件的数据后,就可以退出了
                        if (tmpIndex >= end) {
                            break;
                        }

                        tmpIndex++;
                        cursor.next();
                    }
                    connection.close();
                    return binaryKeys;
                }
            });

            List<String> result = new ArrayList<String>(pageSize);

            Optional.ofNullable(result).orElse(Lists.newArrayList("")).addAll(execute);
            return result;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public OAuth2AccessToken getRefreshTokenInfo(RefreshUserTokenDTO token) {
        try {
            // 拿到当前用户信息
            OAuth2AccessToken oAuth2AccessToken = null;
            Authentication user = SecurityContextHolder.getContext().getAuthentication();

            if (Objects.nonNull(user)) {
                if (user instanceof OAuth2Authentication) {
                    Authentication authentication = (Authentication) user;
                    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
                }
            }
            OAuth2Authentication auth = (OAuth2Authentication) user;
            if (Objects.isNull(auth)) {
                return oAuth2AccessToken;
            }

            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token.getAccessToken());

            RedisClientDetailsService clientDetailsService = SpringUtil.getBean(RedisClientDetailsService.class);

            ClientDetails clientDetails = clientDetailsService
                    .loadClientByClientId(auth.getOAuth2Request().getClientId());

            AuthorizationServerTokenServices authorizationServerTokenServices = SpringUtil
                    .getBean("defaultAuthorizationServerTokenServices", AuthorizationServerTokenServices.class);
            OAuth2RequestFactory requestFactory = new DefaultOAuth2RequestFactory(clientDetailsService);

            RefreshTokenGranter refreshTokenGranter = new RefreshTokenGranter(authorizationServerTokenServices,
                    clientDetailsService, requestFactory);

            Map<String, String> map = new HashMap<>();
            map.put(AuthConstant.GRANT_TYPE, AuthConstant.REFRESH_TOKEN);
            map.put(AuthConstant.REFRESH_TOKEN, accessToken.getRefreshToken().getValue());
            TokenRequest tokenRequest = new TokenRequest(map, auth.getOAuth2Request().getClientId(),
                    auth.getOAuth2Request().getScope(), AuthConstant.REFRESH_TOKEN);

            oAuth2AccessToken = refreshTokenGranter.grant(AuthConstant.REFRESH_TOKEN, tokenRequest);

            tokenStore.removeAccessToken(accessToken);


            return oAuth2AccessToken;
        } catch (InvalidClientException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void removeToken(RemoveUserTokenDTO token) {
        try {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token.getAccessToken());
            if (Objects.isNull(accessToken)) {
                return;
            }
            // 移除access_token
            tokenStore.removeAccessToken(accessToken);
            // 移除refresh_token
            if (Objects.nonNull(accessToken.getRefreshToken())) {
                tokenStore.removeRefreshToken(accessToken.getRefreshToken());
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public OAuth2AccessToken getTokenInfo(QueryUserTokenDTO token) {
        try {
            return tokenStore.readAccessToken(token.getAccessToken());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
