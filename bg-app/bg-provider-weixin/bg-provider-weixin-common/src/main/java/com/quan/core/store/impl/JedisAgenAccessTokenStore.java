//package com.quan.core.store;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author 郑兴泉 956607644@qq.com
// * @data 2021/1/1
// * 描述：
// */
//public class JedisAgenAccessTokenStore implements WxAccessTokenStore{
//
//    protected String tokenKey = "wxmp:access_token";
//
//    // TODO 这里用 redis 来实现
//    protected JedisAgent jedisAgent;
//
//    public JedisAgenAccessTokenStore(String tokenKey, JedisAgent jedisAgent) {
//        if (!Strings.isBlank(tokenKey))
//            this.tokenKey = tokenKey;
//        this.jedisAgent = jedisAgent;
//    }
//
//    public WxAccessToken get() {
//        Map<String, String> map;
//        Jedis jedis = null;
//        try {
//            jedis = jedisAgent.getResource();
//            map = jedis.hgetAll(tokenKey);
//        } finally {
//            Streams.safeClose(jedis);
//        }
//        if (map == null || map.isEmpty())
//            return null;
//        return Lang.map2Object(map, WxAccessToken.class);
//    }
//
//    public void save(String token, int expires, long lastCacheTimeMillis) {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("token", token);
//        map.put("expires", "" + expires);
//        map.put("lastCacheTimeMillis", "" + lastCacheTimeMillis);
//        Jedis jedis = null;
//        try {
//            jedis = jedisAgent.getResource();
//            jedis.hmset(tokenKey, map);
//        } finally {
//            Streams.safeClose(jedis);
//        }
//    }
//
//    public void setTokenKey(String tokenKey) {
//        this.tokenKey = tokenKey;
//    }
//}
