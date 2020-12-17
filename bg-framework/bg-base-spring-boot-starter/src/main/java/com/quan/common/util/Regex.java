package com.quan.common.util;

import java.util.regex.Pattern;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public class Regex {

    protected static LRUCache<String, Pattern> cache = new LRUCache<String, Pattern>(10000);

    public static void setCacheSize(int size) {
        cache.setCacheSize(size);
    }

    public static void clear() {
        if (cache != null)
            cache.clear();
    }

    public static Pattern getPattern(String regex) {
        Pattern pattern = cache.get(regex);
        if (pattern == null) {
            pattern = Pattern.compile(regex);
            cache.put(regex, pattern);
        }
        return pattern;
    }

    public static boolean match(String regex, String value) {
        return getPattern(regex).matcher(value).find();
    }
}
