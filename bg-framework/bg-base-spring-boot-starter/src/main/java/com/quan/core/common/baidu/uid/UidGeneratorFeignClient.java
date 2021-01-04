package com.quan.core.common.baidu.uid;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.common.baidu.uid.fallback.UidGeneratorFeignClientFallbackFactory;
import com.quan.core.common.feign.FeignExceptionConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/****
 *
 * 远程调用 baidu.uid 数据库分布式ID
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/6 15:49
 */

@FeignClient(value = "uid-generator-center", configuration = FeignExceptionConfig.class, fallbackFactory = UidGeneratorFeignClientFallbackFactory.class, decode404 = true)
public interface UidGeneratorFeignClient {

    /**
     * feign rpc访问远程/uid-generator-rpc/uid
     */

    @GetMapping("/uid-generator-rpc/getUID")
    Long getUID();

    @GetMapping(value = "/uid-generator-rpc/parseUID", params = "uid")
    String parseUID(@RequestParam Long uid);

}
