package com.quan.core.service.impl;
/**
 *
 */

import com.quan.core.constant.model.SysClient;
import com.quan.core.constant.model.SysService;
import com.quan.core.service.RbacService;
import com.quan.core.service.SysClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * API 级别权限认证
 * 网关实现应用服务API接口
 * @author 作者 owen
 * @version 创建时间：2017年12月4日 下午5:32:29 类说明 blog: https://blog.51cto.com/13005375
 * desc 需要开启uaa-client-spring-boot-starter中的com.open.capacity.uaa.client.authorize.OpenAuthorizeConfigManager开启
 * code: https://gitee.com/owenwangwen/open-capacity-platform
 */

@Service("rbacService")
@SuppressWarnings("all")
public class RbacServiceImpl implements RbacService {

    @Autowired
    private SysClientService sysClientService;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * @param request HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        boolean hasPermission = false;
        if (user != null) {
            if (user instanceof OAuth2Authentication) {
                OAuth2Authentication athentication = (OAuth2Authentication) user;
                String clientId = athentication.getOAuth2Request().getClientId();
                SysClient client = sysClientService.findClientByClientId(clientId);
                if (Objects.isNull(client)) {
                    hasPermission = false;
                } else {
                    List<SysService> list = sysClientService.findAllClientByClientId(client.getId());
                    hasPermission = list.stream().anyMatch(item -> antPathMatcher.match(item.getPath(), request.getRequestURI()));
                }
            }
        }
        return hasPermission;
    }

}
