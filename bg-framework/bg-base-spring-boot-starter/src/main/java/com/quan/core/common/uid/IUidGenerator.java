package com.quan.core.common.uid;


import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：Id生成器接口
 */
public interface IUidGenerator {

    /**
     * 生成Id
     *
     * @param entity 实体
     * @return id
     */
    Long nextId(Object entity);

    /**
     * 生成Id
     *
     * @return id
     */
    Long uid();

    /**
     * 生成uuid
     *
     * @param entity 实体
     * @return uuid
     */
    default String nextUUID(Object entity) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new UUID(random.nextLong(), random.nextLong()).toString().replace(UidCons.DASH, UidCons.EMPTY);

    }
}
