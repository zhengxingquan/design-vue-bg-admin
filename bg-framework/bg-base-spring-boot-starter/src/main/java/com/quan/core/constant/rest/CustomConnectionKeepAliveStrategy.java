package com.quan.core.constant.rest;

import cn.hutool.core.convert.Convert;
import com.quan.core.constant.util.StringUtil;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.util.Arrays;


/**
 *	连接复用
 */
public class CustomConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {

	// TODO 暂时写死 参数，以后采用配置文件配置起来
	private final long DEFAULT_SECONDS = 30;
	private final String DEFAULT_HEAD = "timeout";

	/**
	 * 最大keep alive的时间（秒钟）
	 * 这里默认为30秒，可以观察客户端机器状态为TIME_WAIT的T可以根据实际情况设置。CP连接数，如果太多，可以增大此值。
	 */
	@Override
	public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
		return Arrays.asList(
				response.getHeaders(HTTP.CONN_KEEP_ALIVE))
				.stream()
				.filter(h -> StringUtil.equalsIgnoreCase(h.getName(), DEFAULT_HEAD) && StringUtil.isNumeric(h.getValue()))
				.findFirst()
				.map(h -> Convert.toLong(h.getValue(), DEFAULT_SECONDS))
				.orElse(DEFAULT_SECONDS) * 1000;
	}
}
