package com.quan.core.error;

import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * zuul自定义异常格式
 * (限流处理异常)
*/

@RestController
public class ZuulErrorController implements ErrorController {

    public static final String ERROR_PATH = "/error";


    /**
     * 错误最终会到这里来
     */
    @RequestMapping(ERROR_PATH)
    public Object error() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        return throwable;
//        return Result.failed(throwable.getMessage()) ;
    }

    

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}