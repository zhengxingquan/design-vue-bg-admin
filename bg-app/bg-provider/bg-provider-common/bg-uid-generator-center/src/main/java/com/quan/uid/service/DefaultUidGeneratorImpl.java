package com.quan.uid.service;

import com.quan.baidu.uid.UidGenerator;
import com.quan.baidu.uid.exception.UidGenerateException;
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
    private UidGenerator defaultUidGenerator;


    @Override
    public Long getUID() throws UidGenerateException {
        log.info("生成 分布式ID ");
        return defaultUidGenerator.getUID();
    }

    @Override
    public String parseUID(long uid) {
        return defaultUidGenerator.parseUID(uid);
    }

}
