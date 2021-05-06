package com.quan.core.constant.http;

import com.quan.core.constant.stream.Streams;
import com.quan.core.constant.util.Encoding;
import com.quan.core.constant.util.Langs;
import com.quan.core.constant.util.Strings;

import java.io.*;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class Response {

    private static final String DEF_PROTOCAL_VERSION = "HTTP/1.1";

    public Response() {
    }

    public Response(HttpURLConnection conn, Map<String, String> reHeader) throws IOException {
        status = conn.getResponseCode();
        detail = conn.getResponseMessage();
        this.header = Header.create(reHeader);
        String s = header.get("Set-Cookie");
        if (null != s) {
            this.cookie = new Cookie();
            this.cookie.afterResponse(null, conn, null); // 解决多个Set-Cookie丢失的问题
        }
        encode = getEncodeType();
    }

    private Header header;
    private InputStream stream;
    private Cookie cookie;
    private String protocol = DEF_PROTOCAL_VERSION;
    private int status;
    private String detail;
    private String content;
    private String encode;

    public String getProtocol() {
        return protocol;
    }

    @Deprecated
    public String getProtocal() {
        return protocol;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public boolean isOK() {
        return status == 200;
    }

    public boolean isServerError() {
        return status >= 500 && status < 600;
    }

    public boolean isClientError() {
        return status >= 400 && status < 500;
    }

    void setStream(InputStream stream) {
        this.stream = stream;
    }

    public Header getHeader() {
        return header;
    }

    /**
     * 根据Http头的Content-Type获取网页的编码类型，如果没有设的话则返回null
     */
    public String getEncodeType() {
        String contentType = header.get("Content-Type");
        if (null != contentType) {
            for (String tmp : contentType.split(";")) {
                if (tmp == null) {
                    continue;
                }
                tmp = tmp.trim();
                if (tmp.startsWith("charset=")) {
                    tmp = Strings.trim(tmp.substring(8)).trim();
                    if (tmp.contains(",")) {
                        tmp = tmp.substring(0, tmp.indexOf(',')).trim();
                    }
                    return tmp;
                }
            }
        }
        return Encoding.UTF8;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getEncode() {
        return encode;
    }

    public InputStream getStream() {
        return new BufferedInputStream(stream);
    }

    public Reader getReader() {
        String encoding = this.getEncodeType();
        if (null == encoding) {
            return getReader(Encoding.defaultEncoding());
        }
        else {
            return getReader(encoding);
        }
    }

    public Reader getReader(String charsetName) {
        if (content != null) {
            return new StringReader(charsetName);
        }
        return new InputStreamReader(getStream(), Charset.forName(charsetName));
    }

    public Reader getReader(Charset charset) {

        if (charset == null) {
            throw new IllegalArgumentException("charset can not be null");
        }


        return getReader(charset.name());
    }
    public Cookie getCookie() {
        return cookie;
    }

    public void printHeader(Writer writer) {
        try {
            writer.write(header.toString());
        }
        catch (IOException e) {
            throw Langs.wrapThrow(e);
        }
    }

    public void print(Writer writer) {
        print(writer, null);
    }

    public void print(Writer writer, String charsetName) {
        Reader reader = null;
        try {
            if (null == charsetName) {
                reader = getReader();
            }
            else {
                reader = this.getReader(charsetName);
            }
            int c;
            char[] buf = new char[8192];
            while (-1 != (c = reader.read(buf))) {
                writer.write(buf, 0, c);
            }
            writer.flush();
        }
        catch (IOException e) {
            throw Langs.wrapThrow(e);
        }
    }

    public String getContent() {
        return getContent(encode);
    }

    public String getContent(String charsetName) {
        if (content == null) {
            if (charsetName == null) {
                content = Streams.readAndClose(getReader(encode));
            }
            else {
                content = Streams.readAndClose(getReader(charsetName));
            }
        }
        return content;
    }
}
