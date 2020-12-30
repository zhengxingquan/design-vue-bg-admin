package com.quan.core.common.baidu.uid.fallback;

import com.quan.core.common.baidu.uid.UidGeneratorFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UidGeneratorFeignClientFallbackFactory implements FallbackFactory<UidGeneratorFeignClient> {
    @Override
    public UidGeneratorFeignClient create(Throwable throwable) {
        return new UidGeneratorFeignClient() {

            @Override
            public String getUID() {
                log.error("获取分布式ID 异常 :{}", throwable);
                return null;
            }

            @Override
            public String parseUID(Long uid) {
                log.error("获取分布式ID 异常 :{}", throwable);
                return null;
            }
        };
    }
}
