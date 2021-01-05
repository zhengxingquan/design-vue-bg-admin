package com.quan.core.common.reflect;

import com.quan.core.common.exception.other.LoopException;
import com.quan.core.common.util.Each;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
public  interface Loop<T> extends Each<T> {

    /**
     * 循环开始的调用
     *
     * @return true 开始循环，false 不进行循环
     * @throws LoopException
     */
    boolean begin() throws LoopException;

    /**
     * 循环结束得调用
     *
     * @throws LoopException
     */
    void end() throws LoopException;

}
