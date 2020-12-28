/**
 *
 */
package com.quan.core.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/30 18:51
 * 类说明     适用于zuul网关
 * 应用服务API接口
 * @return
 */
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
