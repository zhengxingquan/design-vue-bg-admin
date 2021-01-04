package com.quan.core.api;

import com.alibaba.fastjson.serializer.BeanContext;
import com.quan.core.common.util.Langs;
import com.quan.core.exception.WxException;
import com.quan.core.model.WxGroup;
import com.quan.core.model.WxMenu;
import com.quan.core.model.WxUser;

import java.io.Serializable;
import java.util.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class WxResp extends LinkedHashMap implements Serializable {

    private static final long serialVersionUID = -1;

    public boolean ok() {
        return errcode() == 0;
    }

    public WxResp check() {
        if (!ok()) {
            throw new WxException("errcode=" + errcode() + ", " + this);
        }
        return this;
    }

    public int errcode() {
        return getInt("errcode", 0);
    }

    public String errmsg() {
        return getString("errmsg");
    }

    public String msg_id() {
        return getString("msg_id");
    }

    public String msg_status() {
        return getString("msg_status");
    }

    public String type() {
        return getString("type");
    }

    public int created_at() {
        return getInt("created_at", 0);
    }

    private int getInt(String key, int i) {
        return (Integer) this.getOrDefault(key , i);
    }

    public Date created_at_date() {
        return new Date(created_at());
    }

    //--------------------------------------
    // 各种帮助方法

    public Map<String,Object> group() {
        Map map = (Map) this.getOrDefault("groups",null);
        if (map == null) {
            return null;
        }
        return map;
    }

    public List<Map<String,Object>> groups() {
        return (List<Map<String, Object>>)
                        this.getOrDefault("groups",Collections.EMPTY_LIST);

    }

    public WxUser user() {
        return Langs.map2Object(this, WxUser.class);
    }

    public List<WxMenu> menu() {
        List<WxMenu> list = new ArrayList<WxMenu>();
        return list;
    }

    public String media_id() {
        return getString("media_id");
    }

    private String getString(String media_id) {
        return (String) this.getOrDefault(media_id,"");
    }

    public String template_id() {
        return getString("template_id");
    }

    public String msgid() {
        return getString("msgid");
    }

    public <T> List<T> getTo(String key, Class<T> klass) {
        List<Object> tmp = (List<Object> )this.getOrDefault(key, null);
        if (tmp == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (Object obj : tmp) {
            if (obj instanceof Map) {
                // TODO 这里要重写
                throw new RuntimeException("这里要重写");
//                list.add(Langs.map2Object((Map)obj, klass));
            }
        }
        return list;
    }
}
