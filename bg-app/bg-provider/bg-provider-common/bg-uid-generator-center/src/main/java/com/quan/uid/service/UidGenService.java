package com.quan.uid.service;

import com.netflix.discovery.converters.Auto;
import com.quan.baidu.uid.UidGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/24
 * 描述：
 */
@Service
@Slf4j
public class UidGenService {

    @Autowired
    private UidGenerator cachedUidGenerator;

    public long getUid() {
        Long uid = cachedUidGenerator.getUID();
        log.info("获取全局ID: {}", uid);
        return uid;
    }
}
