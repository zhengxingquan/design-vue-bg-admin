package com.quan.common.util;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public class ClassTools {

    private static ClassLoader bgClassLoader;

    static {
//        bgClassLoader = Nutz.class.getClassLoader();
        if (bgClassLoader == null)
            try {
                bgClassLoader = ClassLoader.getSystemClassLoader();
            } catch (Throwable e) {
            }
    }

    /**
     * 获取nutz.jar的ClassLoader的方法
     */
    public static ClassLoader getClassLoader() {
        return bgClassLoader;
    }

    @Deprecated
    public static void setNutClassLoader(ClassLoader nutClassLoader) {
        ClassTools.bgClassLoader = nutClassLoader;
    }
}
