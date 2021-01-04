package com.quan.core.common.http.send;

import com.quan.core.common.exception.HttpException;
import com.quan.core.common.http.Request;
import com.quan.core.common.http.Response;
import com.quan.core.common.http.Sender;
import com.quan.core.common.stream.Streams;

import java.io.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class PostSender extends Sender {

    public PostSender(Request request) {
        super(request);
    }

    @Override
    public Response send() throws HttpException {
        try {
            openConnection();
            InputStream ins = request.getInputStream();
            setupRequestHeader();
            if (ins != null
                    && request.getHeader() != null
                    && ins instanceof ByteArrayInputStream
                    && this.request.getHeader().get("Content-Length") == null)
                conn.addRequestProperty("Content-Length", "" + ins.available());
            setupDoInputOutputFlag();
            if (null != ins) {
                OutputStream ops = Streams.buff(getOutputStream());
                Streams.write(ops, ins);
                Streams.safeClose(ins);
                Streams.safeFlush(ops);
                Streams.safeClose(ops);
            }
            return createResponse(getResponseHeader());
        }
        catch (Exception e) {
            throw new HttpException(request.getUrl().toString(), e);
        }
    }

    @Override
    public int getEstimationSize() throws IOException {
        if (request.getInputStream() != null) {
            return request.getInputStream().available();
        } else {
            if (null != request.getData()) {
                return request.getData().length;
            }
            try {
                return request.getURLEncodedParams().getBytes(request.getEnc()).length;
            }
            catch (UnsupportedEncodingException e) {
                throw Langs.wrapThrow(e);
            }
        }
    }
}
