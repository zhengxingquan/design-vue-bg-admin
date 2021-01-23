package com.quan.core.povider;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTags;
import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTagsProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/9
 * 描述：
 *
 * 重写WebMvcTagsProvider，目的是去掉 WebMvcTags.exception(exception)
 *
 */
public class MyTagsProvider implements WebMvcTagsProvider {

    /**
     * 去掉WebMvcTags.exception(exception)
     *
     * @param request   请求
     * @param response  响应
     * @param handler   处理
     * @param exception 异常
     * @return
     */
    @Override
    public Iterable<Tag> getTags(HttpServletRequest request, HttpServletResponse response, Object handler, Throwable exception) {
        return Tags.of(WebMvcTags.method(request), WebMvcTags.uri(request, response), WebMvcTags.status(response));
    }

    @Override
    public Iterable<Tag> getLongRequestTags(HttpServletRequest request, Object handler) {
        return Tags.of(WebMvcTags.method(request), WebMvcTags.uri(request, null));
    }

}
