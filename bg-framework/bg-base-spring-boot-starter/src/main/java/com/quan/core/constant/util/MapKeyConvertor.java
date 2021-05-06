package com.quan.core.constant.util;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：Langs.convertMapKey 的回调
 */
public interface MapKeyConvertor {

    /**
     * @param key
     *            原始的 key
     * @return 新的 key
     */
    String convertKey(String key);
}
