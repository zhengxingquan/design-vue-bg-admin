package com.quan.core.feign;

import com.quan.core.constant.auth.details.LoginAppUser;
import com.quan.core.constant.feign.FeignExceptionConfig;
import com.quan.core.constant.model.SysUser;
import com.quan.core.constant.web.PageResult;
import com.quan.core.feign.fallback.UserFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/****
 *
 * 调用用户中心中的userdetail对象，用户oauth中的登录
 * 获取的用户与页面输入的密码 进行BCryptPasswordEncoder匹配
 *
 * @author zxq(956607644@qq.com)
 * @date 2020/12/6 15:49
 */

@FeignClient(value="user-center",configuration = FeignExceptionConfig.class ,fallbackFactory = UserFeignClientFallbackFactory.class, decode404 = true)
public interface UserFeignClient {

	/**
	 * feign rpc访问远程/users-anon/login接口
	 * @param username
	 * @return
	 */
    @GetMapping(value = "/users-anon/login", params = "username")
	LoginAppUser findByUsername(@RequestParam("username") String username);


	@GetMapping(value = "/users-anon/mobile", params = "mobile")
	LoginAppUser findByMobile(@RequestParam("mobile") String mobile);

	
	@GetMapping(value = "/users", params = "params")
	PageResult<SysUser> findUsers(@RequestParam Map<String, Object> params);
    
}
