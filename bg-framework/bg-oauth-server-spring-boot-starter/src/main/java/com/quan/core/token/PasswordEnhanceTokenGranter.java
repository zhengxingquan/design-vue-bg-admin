package com.quan.core.token;

import com.quan.core.common.enume.auth.AuthGrantType;
import com.quan.core.common.util.Strings;
import com.quan.core.constant.ValidateParamConstant;
import com.quan.core.service.ValidateCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.LinkedHashMap;
import java.util.Map;

/***
 *   验证密码 是否正确  密码增强模式
 * @author zxq(956607644@qq.com)
 * @date 2020/12/28 14:54
 */
@Slf4j
public class PasswordEnhanceTokenGranter extends AbstractTokenGranter {

    private static final String GRANT_TYPE = AuthGrantType.PASSWORD.getValue();

    private final AuthenticationManager authenticationManager;

    private final ValidateCodeService validateCodeService;

    public PasswordEnhanceTokenGranter(AuthenticationManager authenticationManager,
                                       AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory, ValidateCodeService validateCodeService) {
        this(authenticationManager, tokenServices, clientDetailsService, requestFactory, GRANT_TYPE, validateCodeService);
    }

    protected PasswordEnhanceTokenGranter(AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices,
                                          ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory, String grantType, ValidateCodeService validateCodeService) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
        this.authenticationManager = authenticationManager;
        this.validateCodeService = validateCodeService;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {

        Map<String, String> parameters = new LinkedHashMap<String, String>(tokenRequest.getRequestParameters());
        String username = Strings.sNull(parameters.get(ValidateParamConstant.USERNAME));
        String password = Strings.sNull(parameters.get(ValidateParamConstant.PASSWORD));

        //终端
        String deviceId = Strings.sNull(parameters.get(ValidateParamConstant.DEVICE_ID));
        //验证码
        String validCode = Strings.sNull(parameters.get(ValidateParamConstant.VALID_CODE));

        //校验图形验证码
        if (Strings.isNotBlank(deviceId) && Strings.isNotBlank(validCode)) {
            try {
                validateCodeService.validate(deviceId, validCode);
            } catch (Exception e) {
                throw new InvalidGrantException(e.getMessage());
            }
        }

        // Protect from downstream leaks of password
        parameters.remove(ValidateParamConstant.PASSWORD);
        parameters.remove(ValidateParamConstant.DEVICE_ID);
        parameters.remove(ValidateParamConstant.VALID_CODE);


        // 认证
        Authentication userAuth = new UsernamePasswordAuthenticationToken(username, password);
        ((AbstractAuthenticationToken) userAuth).setDetails(parameters);
        try {
            // 认证
            log.info("登录认证用户 {} , {}", username, password);
            userAuth = authenticationManager.authenticate(userAuth);
        } catch (AccountStatusException ase) {
            log.info("登录认证用户失败 {} ", ase);
            throw new InvalidGrantException(ase.getMessage());

        } catch (BadCredentialsException e) {
            log.info("登录认证用户失败 {} ", e);
            throw new InvalidGrantException(e.getMessage());
        }
        if (userAuth == null || !userAuth.isAuthenticated()) {
            log.info("无法验证用户身份 {} ", username);
            throw new InvalidGrantException("Could not authenticate user: " + username);
        }

        OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(storedOAuth2Request, userAuth);
    }

}