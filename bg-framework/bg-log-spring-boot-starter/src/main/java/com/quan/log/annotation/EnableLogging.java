package com.quan.log.annotation;

import com.quan.log.selector.LogImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * 启动日志框架支持
 * @author owen
 * @create 2017年7月2日
 * 自动装配starter ，需要配置多数据源
 * blog: https://blog.51cto.com/13005375
 * code: https://gitee.com/owenwangwen/open-capacity-platform
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogImportSelector.class)
public @interface EnableLogging{
//	String name() ;
}