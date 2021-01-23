package com.quan.core.config;

import com.quan.core.povider.MyTagsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.storage.mysql.v1.MySQLStorage;

import javax.sql.DataSource;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/9
 * 描述：
 */
@Configuration
public class ZipkinConfig {

    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.newBuilder().datasource(datasource).executor(Runnable::run).build();
    }

    @Bean
    public MyTagsProvider myTagsProvider(){
        return new MyTagsProvider();
    }

}
