package com.quan.core.datasource.util;


import com.quan.core.datasource.constant.DataSourceKey;

/***
 *   用于数据源切换
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 15:32
 */
public class DataSourceHolder {

    //注意使用ThreadLocal，微服务下游建议使用信号量
    private static final ThreadLocal<DataSourceKey> DATA_SOURCE_KEY = new ThreadLocal<>();

    /***
     *  得到当前的数据库连接
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/18 15:33
     * @param

     * @return com.quan.datasource.constant.DataSourceKey
     */
    public static DataSourceKey getDataSourceKey() {
        return DATA_SOURCE_KEY.get();
    }

    /***
     *   设置当前的数据库连接
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/18 15:33
     * @param type

     * @return void
     */
    public static void setDataSourceKey(DataSourceKey type) {
        DATA_SOURCE_KEY.set(type);
    }

    /***
     *   清除当前的数据库连接
     * @author zxq(956607644 @ qq.com)
     * @date 2020/12/18 15:33
     * @param

     * @return void
     */
    public static void clearDataSourceKey() {
        DATA_SOURCE_KEY.remove();
    }


}