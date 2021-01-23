//package com.quan.core.store;
//
//import com.quan.core.bean.WxAccessToken;
//
//import java.util.Map;
//
///**
// * @author 郑兴泉 956607644@qq.com
// * @data 2021/1/1
// * 描述：
// */
//public class DaoAccessTokenStore implements WxAccessTokenStore{
//
//    // TODO 这里用 JDBC 来 配置查询
//    private Dao dao;
//    private Map<String, Object> params;
//    private String tableAccessToken = "access_token";
//    private String tableAccessTokenExpires = "access_token_expires";
//    private String tableAccessTokenLastat = "access_token_lastat";
//
//    private String fetch = "select access_token,access_token_expires,access_token_lastat from wx_config where id=@id";
//    private String update = "update wx_config set access_token=@access_token, access_token_expires=@access_token_expires, access_token_lastat=@access_token_lastat where id=@id";
//
//    public DaoAccessTokenStore() {}
//
//    public DaoAccessTokenStore(Dao dao) {
//        super();
//        this.dao = dao;
//    }
//
//    @Override
//    public WxAccessToken get() {
//        Sql sql = Sqls.fetchRecord(fetch);
//        if (params != null)
//            sql.params().putAll(params);
//        dao.execute(sql);
//        Record record = sql.getObject(Record.class);
//        WxAccessToken at = new WxAccessToken();
//        at.setToken(record.getString(tableAccessToken));
//        at.setExpires(record.getInt(tableAccessTokenExpires));
//        at.setLastCacheTimeMillis(record.getLong(tableAccessTokenLastat));
//        return at;
//    }
//
//    @Override
//    public void save(String token, int time, long lastCacheTimeMillis) {
//        Sql sql = Sqls.create(update);
//        if (params != null)
//            sql.params().putAll(params);
//        sql.params().set(tableAccessToken, token);
//        sql.params().set(tableAccessTokenExpires, time);
//        sql.params().set(tableAccessTokenLastat, lastCacheTimeMillis);
//        dao.execute(sql);
//    }
//
//    public Dao getDao() {
//        return dao;
//    }
//
//    public void setDao(Dao dao) {
//        this.dao = dao;
//    }
//
//    public Map<String, Object> getParams() {
//        return params;
//    }
//
//    public void setParams(Map<String, Object> params) {
//        this.params = params;
//    }
//
//    public String getTableAccessToken() {
//        return tableAccessToken;
//    }
//
//    public void setTableAccessToken(String tableAccessToken) {
//        this.tableAccessToken = tableAccessToken;
//    }
//
//    public String getTableAccessTokenExpires() {
//        return tableAccessTokenExpires;
//    }
//
//    public void setTableAccessTokenExpires(String tableAccessTokenExpires) {
//        this.tableAccessTokenExpires = tableAccessTokenExpires;
//    }
//
//    public String getTableAccessTokenLastat() {
//        return tableAccessTokenLastat;
//    }
//
//    public void setTableAccessTokenLastat(String tableAccessTokenLastat) {
//        this.tableAccessTokenLastat = tableAccessTokenLastat;
//    }
//
//    public String getFetch() {
//        return fetch;
//    }
//
//    public void setFetch(String fetch) {
//        this.fetch = fetch;
//    }
//
//    public String getUpdate() {
//        return update;
//    }
//
//    public void setUpdate(String update) {
//        this.update = update;
//    }
//}
