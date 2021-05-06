package com.quan.core.constant.feign;

import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
/***
 *   
 * @author zxq(956607644@qq.com)  
 * @date 2020/12/24 18:17
 */
public class GlobalFeignConfig {

    @Bean
    public Level level() {
        return Level.FULL;
    }
}
