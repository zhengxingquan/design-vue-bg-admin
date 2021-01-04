package com.quan.core.store;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class WxAccessTokenStoreFactory {

    // TOOD 这里用 工厂拿取数据
    public static WxAccessTokenStore make(String type) {

        return null;
//        if (Strings.isBlank(type) || "memory".equals(type)) {
//            return new MemoryAccessTokenStore();
//        }
//        if ("dao".equals(type)) {
//            return new DaoAccessTokenStore(ioc.get(Dao.class));
//        }
//        if ("jedisPool".equals(type)) {
//            PropertiesProxy conf = ioc.get(PropertiesProxy.class, "conf");
//            return new RedisAccessTokenStore(conf.get("weixin.redis.key"),
//                    ioc.get(JedisPool.class));
//        }
//        if ("jedis".equals(type)) {
//            PropertiesProxy conf = ioc.get(PropertiesProxy.class, "conf");
//            return new JedisAgenAccessTokenStore(conf.get("weixin.redis.key"),
//                    ioc.get(JedisAgent.class));
//        }
//        throw new RuntimeException("unsupport type=" + type);
    }
}
