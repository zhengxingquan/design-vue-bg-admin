package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.auth.details.LoginAppUser;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.model.SysPermission;
import com.quan.core.common.util.SysUserUtil;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.Result;
import com.quan.core.controller.request.token.*;
import com.quan.core.factory.AuthTokenFactory;
import com.quan.core.service.SysTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 认证中心
 * @author zxq(956607644 @ qq.com)
 * @date 2021/2/4 14:31
 */
@Slf4j
@RestController
@Api(tags = "（AUTH CENTER）认证中心")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "TOKEN管理", permission = "sys:token")
public class OAuth2Controller {

    @Autowired
    private SysTokenService sysTokenService;


    @ApiOperation(value = "通过clientId获取token")
    @PostMapping("/sys/oauth/client/token")
    @SLog(module = "auth-server", msg = "通过 clientId 获取 token")
    public Result getClientTokenInfo() {
        try {
            ServletRequestAttributes servletRequestAttributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();
            return JsonResult.succeed(sysTokenService.getClientTokenInfo(
                    AuthTokenFactory.newInstance(request)));
        } catch (Exception e) {
            log.error("clientId获取token失败", e);
            return Result.failed(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        }
    }

    @ApiOperation(value = "用户名密码获取token")
    @PostMapping("/sys/oauth/user/token")
    @SLog(module = "auth-server", msg = "用户名密码获取token")
    public Result getUserTokenInfo(@RequestBody UserTokenRequest tokenRequest) {
        try {
            ServletRequestAttributes servletRequestAttributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            HttpServletRequest request = servletRequestAttributes.getRequest();

            return JsonResult.succeed(sysTokenService.getUserTokenInfo(
                    AuthTokenFactory.newInstance(request, tokenRequest)));

        } catch (Exception e) {
            log.error("用户名密码获取token失败", e);
            return Result.failed(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        }
    }


    @PostMapping("/sys/oauth/authentication/sms")
    @ApiOperation(value = "手机验证码认证")
    @SLog(module = "auth-server", msg = "手机验证码认证")
    public Result getMobileInfo(@RequestBody ValidCodeTokenRequest tokenRequest) {


        try {
            ServletRequestAttributes servletRequestAttributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();

            return JsonResult.succeed(sysTokenService.getMobileTokenInfo(
                    AuthTokenFactory.newInstance(request, tokenRequest)));
        } catch (Exception e) {
            log.error("手机验证码认证失败", e);
            return Result.failed(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        }
    }

    @ApiOperation(value = "access_token刷新token")
    @PostMapping(value = "/sys/oauth/refresh/token")
    @SLog(module = "auth-server", msg = "access_token刷新token")
    public Result refreshTokenInfo(@RequestBody RefreshTokenRequest tokenRequest) {

        return JsonResult.succeed(sysTokenService.getRefreshTokenInfo(AuthTokenFactory.newInstance(tokenRequest)));

    }

    /**
     * 移除access_token和refresh_token
     *
     * @param tokenRequest
     */
    @ApiOperation(value = "移除token")
    @PostMapping(value = "/sys/oauth/remove/token")
    @SLog(module = "auth-server")
    public Result removeToken(@RequestBody RemoveTokenRequest tokenRequest) {
        sysTokenService.removeToken(AuthTokenFactory.newInstance(tokenRequest));
        return JsonResult.succeed();
    }

    @ApiOperation(value = "获取token信息")
    @PostMapping(value = "/sys/oauth/get/token")
    @SLog(module = "auth-server")
    public Result getTokenInfo(@RequestBody QueryUserTokenRequest tokenRequest) {
        return JsonResult.succeed(sysTokenService.getTokenInfo(AuthTokenFactory.newInstance(tokenRequest)));
    }

    /**
     * 当前登陆用户信息
     * security获取当前登录用户的方法是SecurityContextHolder.getContext().getAuthentication()
     * 这里的实现类是org.springframework.security.oauth2.provider.OAuth2Authentication
     *
     * @return
     */
    @ApiOperation(value = "当前登陆用户信息")
    @GetMapping(value = {"/sys/oauth/userinfo"})
    @SLog(module = "auth-server")
    public Result getCurrentUserDetail() throws ControllerException {

        Map<String, Object> userInfo = new HashMap<>();
        LoginAppUser loginUser = SysUserUtil.getLoginAppUser();
        userInfo.put("user", loginUser);
        List<SysPermission> permissions = new ArrayList<>();
        loginUser.getAuthorities().forEach(o -> {
            SysPermission sysPermission = new SysPermission();
            sysPermission.setPermission(o.toString());
            permissions.add(sysPermission);
        });
        userInfo.put("permissions", permissions);
        return JsonResult.succeed(userInfo);
    }


    @ApiOperation(value = "获取TOKEN列表")
    @PostMapping("/sys/oauth/token/list")
    @SLog(module = "auth-server", msg = "获取TOKEN列表")
    public PageResult<Map<String, String>> getTokenList(@RequestBody QueryUserTokenPageRequest tokenRequest) {
        return sysTokenService.getTokenList(AuthTokenFactory.newInstance(tokenRequest));
    }


}
