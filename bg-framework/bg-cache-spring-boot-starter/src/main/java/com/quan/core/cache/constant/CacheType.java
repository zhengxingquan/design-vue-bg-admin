package com.quan.core.cache.constant;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/11
 * 描述：
 */
public enum CacheType {

    /***
     * redis 缓存数据
     */
    REDIS(1),
    /***
     * 内存 缓存数据
     */
    MEMORY(0),
    /***
     * 数据库 缓存数据
     */
    MYSQL(2);

    CacheType(Integer code) {
        this.code = code;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
