package com.quan.core.service;

import com.quan.core.UidGenerator;
import com.quan.core.exception.UidGenerateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/25
 * 描述：
 */

@Service
@Primary
@Slf4j
public class CachedUidGeneratorImpl implements IUidGeneratorService {

    @Autowired
    private UidGenerator cachedUidGenerator;

    @Override
    public Long getUID() throws UidGenerateException {
        Long uid = cachedUidGenerator.getUID();
        log.info("生成全局分布式ID: {} ", uid);
        return uid;
    }

    @Override
    public String parseUID(long uid) {
        return cachedUidGenerator.parseUID(uid);
    }

}
