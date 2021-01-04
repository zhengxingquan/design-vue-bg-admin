package com.quan.core.api.impl;

import com.quan.core.api.WxLogin;
import com.quan.core.api.WxResp;
import okhttp3.Request;

import java.util.LinkedHashMap;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class WxLoginImpl implements WxLogin {

    protected String host;
    protected String appid;
    protected String appsecret;

    @Override
    public String qrconnect(String redirect_uri, String scope, String state) {
        Request req = Request.create("https://open.weixin.qq.com/connect/qrconnect", METHOD.GET);
        LinkedHashMap params = new LinkedHashMap();
        params.put("appid", appid);
        if (redirect_uri.startsWith("http")) {
            params.put("redirect_uri", redirect_uri);
        }
        else {
            params.put("redirect_uri", host + redirect_uri);
        }
        params.put("response_type", "code");
        params.put("scope", Strings.sBlank(scope, "snsapi_login"));
        req.setParams(params);
        return req.getUrl().toString() + "#wechat_redirect";
    }


    @Override
    public String authorize(String redirect_uri, String scope, String state) {
        Request req = Request.create("https://open.weixin.qq.com/connect/oauth2/authorize", METHOD.GET);
        LinkedHashMap params = new LinkedHashMap();
        params.put("appid", appid);
        if (redirect_uri.startsWith("http"))
            params.put("redirect_uri", redirect_uri);
        else
            params.put("redirect_uri", host + redirect_uri);
        params.put("response_type", "code");
        params.put("scope", Strings.sBlank(scope, "snsapi_userinfo"));
        req.setParams(params);
        return req.getUrl().toString() + "#wechat_redirect";
    }

    @Override
    public WxResp access_token(String code) {
        Request req = Request.create("https://api.weixin.qq.com/sns/oauth2/access_token", METHOD.GET);
        LinkedHashMap params = new LinkedHashMap();
        params.put("appid", appid);
        params.put("secret", appsecret);
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        req.setParams(params);
        Response resp = Sender.create(req).send();
        if (!resp.isOK()) {
            return null;
        }
        return Json.fromJson(WxResp.class, resp.getReader("UTF-8"));
    }

    @Override
    public WxResp refresh_token(String refresh_token) {
        Request req = Request.create("https://api.weixin.qq.com/sns/oauth2/refresh_token", AbstractWxApi2.METHOD.GET);
        LinkedHashMap params = new LinkedHashMap();
        params.put("appid", appid);
        params.put("secret", appsecret);
        params.put("refresh_token", refresh_token);
        params.put("grant_type", "refresh_token");
        req.setParams(params);
        Response resp = Sender.create(req).send();
        if (!resp.isOK()) {
            return null;
        }
        return Json.fromJson(WxResp.class, resp.getReader("UTF-8"));
    }

    @Override
    public WxResp auth(String token) {
        return null;
    }

    @Override
    public WxResp userinfo(String openid, String access_token) {
        // https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
        Request req = Request.create("https://api.weixin.qq.com/sns/userinfo", METHOD.GET);
        NutMap params = new NutMap();
        params.put("access_token", access_token);
        params.put("openid", openid);
        req.setParams(params);
        Response resp = Sender.create(req).send();
        if (!resp.isOK()) {
            return null;
        }
        return Json.fromJson(WxResp.class, resp.getReader("UTF-8"));
    }

    public WxLoginImpl configure(PropertiesProxy conf, String prefix) {
        prefix = Strings.sBlank(prefix);
        appid = conf.get(prefix + "appid");
        appsecret = conf.get(prefix + "appsecret");
        host = conf.get(prefix + "host");
        return this;
    }
}
