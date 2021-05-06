package com.quan.core.constant.stream;

import java.io.IOException;
import java.io.Writer;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public class StringWriter extends Writer {

    private StringBuilder sb;

    public StringWriter(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public void flush() throws IOException {
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < (off + len); i++) {
            sb.append(cbuf[i]);
        }
    }

    public StringBuilder getStringBuilder() {
        return sb;
    }
}