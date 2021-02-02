package com.quan.core.service;

import com.quan.core.common.uid.IUidGenerator;
import com.quan.core.exception.UidGenerateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/25
 * 描述：
 */

@Service
@Slf4j
public class DefaultUidGeneratorImpl implements IUidGeneratorService {

    @Autowired
    private IUidGenerator defaultUidGenerator;


    @Override
    public Long getUID() throws UidGenerateException {
        log.info("生成 分布式ID ");
        return defaultUidGenerator.uid();
    }

    @Override
    public Long parseUID(long uid) {
        return defaultUidGenerator.nextId(uid);
    }

}
