package com.quan.core.common.http;

import com.alibaba.fastjson.JSON;
import com.quan.core.common.meta.Pair;
import com.quan.core.common.util.Strings;
import lombok.extern.slf4j.Slf4j;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Slf4j
public class Cookie implements HttpReqRespInterceptor {

    protected Map<String, String> map;

    protected boolean debug;

    public Cookie() {
        map = new HashMap<String, String>();
    }

    public Cookie(String s) {
        this();
        parse(s);
    }

    public String get(String name) {
        return map.get(name);
    }

    public Cookie remove(String name) {
        map.remove(name);
        return this;
    }

    public Cookie set(String name, String value) {
        map.put(name, value);
        return this;
    }

    public void parse(String str) {
        if (debug) {
            log.debug("parse " + str);
        }
        String[] ss = Strings.splitIgnoreBlank(str, ";");
        for (String s : ss) {
            Pair<String> p = Pair.create(Strings.trim(s));
            if (p.getValueString() == null) {
                continue;
            }
            if ("Path".equals(p.getName()) || "Expires".equals(p.getName())) {
                continue;
            }
            if ("Max-Age".equals(p.getName())) {
                long age = Long.parseLong(p.getValue());
                if (age == 0) {
                    return;
                }
            }
            String val = p.getValueString();
            if (debug) {
                log.debug("add cookie [{}={}]",  p.getName(), val);
            }
            map.put(p.getName(), val);
        }
    }

    @Override
    public String toString() {
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> en : map.entrySet()) {
            sb.append(en.getKey()).append('=').append(en.getValue()).append("; ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    @Override
    public void beforeConnect(Request request) {
    }

    @Override
    public void afterConnect(Request request, HttpURLConnection conn) {
        if (this.map.isEmpty()) {
            return;
        }
        String c = toString();
        if (debug) {
            log.debug("add Cookie for req {} ", c);
        }
        if (!Strings.isBlank(c)) {
            conn.addRequestProperty("Cookie", c);
        }
    }

    @Override
    public void afterResponse(Request request, HttpURLConnection conn, Response response) {
        Map<String, List<String>> props = conn.getHeaderFields();
        for (Map.Entry<String, List<String>> en : props.entrySet()) {
            if (en.getKey() == null || !"Set-Cookie".equalsIgnoreCase(en.getKey())) {
                continue;
            }
            for (String e : en.getValue()) {
                if (debug) {
                    log.debug("found Set-Cookie {}", e);
                }
                this.parse(e);
            }
            break;
        }
    }

    public String toJson() {
        return JSON.toJSONString(map);
    }

    public int size() {
        return map.size();
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
