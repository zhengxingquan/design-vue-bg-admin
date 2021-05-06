package com.quan.core.constant.annotation;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 * 设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
 *
 * PageHelper.startPage(MapUtils.getInteger(map, "page"), MapUtils.getInteger(map, "limit"), true);
 */
@Target( ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageQuery {

    /***
     * 是否统计 总条数
     */
    boolean countState() default true;
}
