package com.quan.core.common.mybatis.log;

import org.apache.ibatis.logging.stdout.StdOutImpl;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/31
 * 描述：
 */
public class CustomStdOutImpl extends StdOutImpl {

    public CustomStdOutImpl(String clazz) {
        super(clazz);
    }

    @Override
    public void error(String s, Throwable e) {
        System.err.println("EXEC SQL:");
        super.error(s, e);
    }

    @Override
    public void error(String s) {
        System.err.println("EXEC SQL:");
        super.error(s);
    }

    @Override
    public void debug(String s) {
        System.out.println("EXEC SQL:");
        super.debug(s);
    }

    @Override
    public void trace(String s) {
        System.out.println("EXEC SQL:");
        super.trace(s);
    }

    @Override
    public void warn(String s) {
        System.out.println("EXEC SQL:");
        super.warn(s);
    }
}
