package com.quan.common.stream;

import com.quan.common.util.Encoding;
import com.quan.common.util.Langs;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public class StringInputStream extends ByteArrayInputStream {

    public StringInputStream(CharSequence s, Charset charset) {
        super(toBytes(s, charset));
    }

    public StringInputStream(CharSequence s) {
        super(toBytes(s, Encoding.CHARSET_UTF8));
    }

    protected static byte[] toBytes(CharSequence str, Charset charset) {
        if (str == null)
            return new byte[0];
        if (charset == null)
            charset = Encoding.CHARSET_UTF8;
        try {
            return str.toString().getBytes(charset.name());
        } catch (UnsupportedEncodingException e) {
            throw Langs.wrapThrow(e);
        }
    }
}
