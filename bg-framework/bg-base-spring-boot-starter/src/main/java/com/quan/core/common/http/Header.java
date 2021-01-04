package com.quan.core.common.http;

import com.alibaba.fastjson.JSON;
import springfox.documentation.spring.web.json.Json;

import java.nio.charset.Charset;
import java.util.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class Header {

    protected LinkedHashMap<String, Object> items;

    protected Header() {
        items = new LinkedHashMap();
    }

    public Collection<String> keys() {
        return items.keySet();
    }

    public LinkedHashMap getMap() {
        LinkedHashMap map = new LinkedHashMap();
        for (String key : this.keys()) {
            String val = this.get(key);
            map.put(key, val);
        }
        return map;
    }

    @SuppressWarnings("rawtypes")
    public String get(String key) {
        Object value = items.get(key);
        if (value == null) {
            return null;
        }
        if (value instanceof List) {
            if (((List) value).isEmpty()) {
                return null;
            }
            return (String) ((List) value).get(0);
        }
        return (String) value;
    }

    public Header set(String key, String value) {
        if (null != key) {
            items.put(key, value);
        }
        return this;
    }

    public Header remove(String key) {
        items.remove(key);
        return this;
    }

    public Header clear() {
        items.clear();
        return this;
    }

    public Set<Map.Entry<String, String>> getAll() {
        Map<String, String> tmp = new HashMap<String, String>();
        for (String key : items.keySet()) {
            String value = get(key);
            if (value != null) {
                tmp.put(key, value);
            }
        }
        return tmp.entrySet();
    }

    public Header addAll(Map<String, String> map) {
        if (null != map) {
            for (Map.Entry<String, String> en : map.entrySet()) {
                // 如果值不是String,就立马报错咯
                if (en.getValue() != null) {
                    this.items.put(en.getKey(), en.getValue());
                }
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(items);
    }

    public static Header create(Map<String, String> properties) {
        return new Header().addAll(properties);
    }

    public static Header create(LinkedHashMap reHeader) {
        Header header = new Header();
        header.items.putAll(reHeader);
        return header;
    }

    public static Header create(String properties) {
        return create(JSON.parseObject(properties, Map.class));
    }

    public static Header create() {
        Header header = new Header();
        // TODO 这里设置默认的 头信息
//        header.addAll(Http.DEFAULT_HEADERS);
        return header;
    }

    public String get(String key, String defaultValue) {
        String value = get(key);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public int getInt(String key, int defaultValue) {
        String value = get(key);
        if (value == null) {
            return defaultValue;
        }
        return Integer.parseInt(value);
    }

    public Header asJsonContentType() {
        return this.asJsonContentType(null);
    }

    public Header asFormContentType() {
        return this.asFormContentType(null);
    }

    public Header asJsonContentType(String enc) {
        if (enc == null) {
            enc = Charset.defaultCharset().name();
        }
        set("Content-Type", "application/json; charset=" + enc.toUpperCase());
        return this;
    }

    public Header asFormContentType(String enc) {
        if (enc == null) {
            enc = Charset.defaultCharset().name();
        }
        set("Content-Type", "application/x-www-form-urlencoded; charset=" + enc.toUpperCase());
        return this;
    }

    public void addv(String name, String value) {
        if (value == null) {
            items.remove(name);
        } else {
            items.put(name, value);
        }
    }

    public List<String> getValues(String name) {
        Object value = items.get(name);
        if (value == null) {
            return Collections.EMPTY_LIST;
        }
        if (value instanceof String) {
            return Arrays.asList((String) value);
        }
        return (List<String>) value;
    }
}

