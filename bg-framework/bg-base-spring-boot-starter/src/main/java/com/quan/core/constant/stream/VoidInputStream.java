package com.quan.core.constant.stream;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public class VoidInputStream extends InputStream {

    /***
     * 返回 -1
     */
    @Override
    public int read() throws IOException {
        return -1;
    }

}