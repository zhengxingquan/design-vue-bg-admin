package com.quan.core.constant.http.send;

import com.quan.core.constant.exception.HttpException;
import com.quan.core.constant.http.Request;
import com.quan.core.constant.http.Response;
import com.quan.core.constant.http.Sender;

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
