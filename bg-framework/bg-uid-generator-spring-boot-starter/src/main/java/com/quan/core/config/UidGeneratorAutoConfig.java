package com.quan.core.config;

import com.quan.core.impl.CachedUidGenerator;
import com.quan.core.impl.DefaultUidGenerator;
import com.quan.core.impl.UidProperties;
import com.quan.core.worker.DisposableWorkerIdAssigner;
import com.quan.core.worker.WorkerIdAssigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/24
 * 描述：百度 分布式 ID 数据表
 */
@Configuration
@ConditionalOnClass({DefaultUidGenerator.class, CachedUidGenerator.class})
//@MapperScan({"com.quan.core.dao"})
@EnableConfigurationProperties(UidProperties.class)
public class UidGeneratorAutoConfig {


    public class UidAutoConfigure {

        @Autowired
        private UidProperties uidProperties;

        @Bean
        @ConditionalOnMissingBean
        @Lazy
        public DefaultUidGenerator defaultUidGenerator() {
            return new DefaultUidGenerator(uidProperties);
        }

        @Bean
        @ConditionalOnMissingBean
        @Lazy
        @Primary
        public CachedUidGenerator cachedUidGenerator() {
            return new CachedUidGenerator(uidProperties);
        }

        @Bean
        @ConditionalOnMissingBean
        public WorkerIdAssigner workerIdAssigner() {
            return new DisposableWorkerIdAssigner();
        }
    }
}
