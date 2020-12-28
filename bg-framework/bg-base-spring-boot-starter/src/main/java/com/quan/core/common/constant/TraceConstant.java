package com.quan.core.common.constant;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/2
 * 描述：
 */
public interface TraceConstant {
    /**
     * 日志跟踪id名。
     */
    String LOG_TRACE_ID = "traceId";

    String LOG_B3_TRACEID = "X-B3-TraceId";

    /**
     * 请求头跟踪id名。
     */
    String HTTP_HEADER_TRACE_ID = "app_trace_id";
}
