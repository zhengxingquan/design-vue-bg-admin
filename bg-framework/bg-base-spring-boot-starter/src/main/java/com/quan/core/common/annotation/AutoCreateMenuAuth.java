package com.quan.core.common.annotation;


import com.quan.core.common.enume.MenuType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 自动创建菜单
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/29 10:10
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoCreateMenuAuth {

    /***
     *  菜单的链接 默认为 data-pjax 如果当前为父节点，则为空
     * @return java.lang.String
     */
    String target() default "data-pjax";

    /**
     * 菜单名称 或者 权限名称
     *
     * @return
     */
    String name();

    /**
     * 菜单 或者 按钮或资源
     * 请参见 MenuType 类
     *
     * @return
     */
    MenuType type() default MenuType.SOURCE;

    /**
     * 图标
     *
     * @return
     */
    String icon() default "";

    /**
     * 权限标识
     * <p>
     * 留空将自动扫描 shiro 的RequiresPermissions标签
     *
     * @return
     */
    String permission() default "";


    /**
     * 上级权限的标识
     * <p>
     * 留空表明自己是根节点
     *
     * @return
     */
    String parentPermission() default "";

    /**
     * 菜单排序
     *
     * @return
     */
    int shortNo() default 0;

    /**
     * 菜单简介
     *
     * @return
     */
    String note() default "";
}
