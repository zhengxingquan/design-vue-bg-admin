package com.quan.core.common.http.send;

import com.quan.core.common.http.Request;
import com.quan.core.common.http.Sender;
import com.quan.core.common.http.SenderFactory;

import java.io.File;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class DefaultSenderFactory implements SenderFactory {

    @Override
    public Sender create(Request request) {
        if (request.isGet())
            return new GetSender(request);
        if (request.isDelete()) {
            if (request.getParams() != null || request.getData() != null || request.hasInputStream())
                return new PostSender(request);
            return new GetSender(request);
        }
        if ((request.isPost() || request.isPut()) && (request.getParams() != null)) {
            for (Object val : request.getParams().values()) {
                if (val instanceof File || val instanceof File[]) {
                    return new FilePostSender(request);
                }
            }
        }
        return new PostSender(request);
    }
}