package com.quan.core.util;

import com.quan.core.common.util.Langs;

import java.util.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class WxPaySign {
    /**
     * 签名算法
     *
     * @param key
     * @param params
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String createSign(String key, Map<String, Object> params) {
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        Set es = params.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            parameters.put(k, v);
        }
        StringBuffer sb = new StringBuffer();
        Set es2 = parameters.entrySet();//accsii升序排序
        Iterator it2 = es2.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        String sign = Langs.md5(sb.toString()).toUpperCase();
        return sign;
    }
}
