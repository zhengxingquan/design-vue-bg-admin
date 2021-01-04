package com.quan.core.common.http.send;

import com.quan.core.common.exception.HttpException;
import com.quan.core.common.http.Request;
import com.quan.core.common.http.Response;
import com.quan.core.common.http.Sender;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class GetSender extends Sender {

    public GetSender(Request request) {
        super(request);
    }

    @Override
    public Response send() throws HttpException {
        try {
            openConnection();
            setupRequestHeader();
            return createResponse(getResponseHeader());
        }
        catch (Exception e) {
            throw new HttpException(request.getUrl().toString(), e);
        }
    }
}
