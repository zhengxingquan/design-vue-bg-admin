package com.quan.core.constant.reflect;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 *
 *
 * 匹配类型：
 *
 * <ul>
 * <li>YES: 匹配
 * <li>LACK: 参数不足
 * <li>NO: 不匹配
 * </ul>
 */
public enum MatchType {
    /**
     * 匹配
     */
    YES,
    /**
     * 参数不足
     */
    LACK,
    /**
     * 不匹配
     */
    NO,
    /**
     * 长度相同，但是需要转换
     */
    NEED_CAST
}
