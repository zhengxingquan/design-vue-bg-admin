package com.quan.plugins.cache.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Set;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Slf4j
@Aspect
//@Order(-1) // 保证该AOP在@Transactional之前执行
public class CacheRemoveAop {



    public void exec(){

    }
    
}
