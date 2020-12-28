package com.quan.core.datasource.util;

import com.quan.core.datasource.constant.DataSourceKey;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/***
 *   spring动态数据源（需要继承AbstractRoutingDataSource）
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 15:33
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> dataSources = new HashMap<>();

    public DynamicDataSource() {
        super.setTargetDataSources(dataSources);

    }

    public <T extends DataSource> void addDataSource(DataSourceKey key, T data) {
        dataSources.put(key, data);
    }

    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSourceKey();
    }

}