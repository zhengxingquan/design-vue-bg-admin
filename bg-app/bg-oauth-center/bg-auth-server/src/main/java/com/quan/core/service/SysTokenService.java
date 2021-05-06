package com.quan.core.service;

import com.quan.core.constant.web.PageResult;
import com.quan.core.dto.token.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.Map;

public interface SysTokenService {

    /***
     *   通用校验
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:54  
     * @param token
     * @return void
     */
    void preCheckClient(ClientTokenDTO token);

    /***
     *   模拟客户端模式
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:54
     * @param token
     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     */
    OAuth2AccessToken getClientTokenInfo(ClientTokenDTO token);

    /***
     *   模拟密码模式
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:53
     * @param token
     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     */
    OAuth2AccessToken getUserTokenInfo(UserPasswordTokenDTO token);

    /***
     *   模拟手机验证码模式
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:54
     * @param token
     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     */
    OAuth2AccessToken getMobileTokenInfo(ValidCodeTokenDTO token);

    /***
     * 刷新  
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:55  
     * @param token

     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     */
    OAuth2AccessToken getRefreshTokenInfo(RefreshUserTokenDTO token);

    /***
     *  查询 token 列表
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:55
     * @param token

     * @return com.quan.core.common.web.PageResult<java.util.Map < java.lang.String, java.lang.String>>  
     */
    PageResult<Map<String, String>> getTokenList(QueryUserTokenPageDTO token);


    /***
     *  删除 token
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:55
     * @param token

     * @return void
     */
    void removeToken(RemoveUserTokenDTO token);

    /***
     * 通过   access_token 得到人员信息
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/4 14:55
     * @param token

     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     */
    OAuth2AccessToken getTokenInfo(QueryUserTokenDTO token);
}
