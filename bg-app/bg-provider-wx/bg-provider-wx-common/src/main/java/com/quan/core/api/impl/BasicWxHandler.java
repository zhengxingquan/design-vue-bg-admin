package com.quan.core.api.impl;

import com.quan.core.exception.AesException;
import com.quan.core.util.Wxs;
import com.quan.core.weixin.repo.com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class BasicWxHandler extends AbstractWxHandler {

    protected String token;

    protected String aeskey;

    protected WXBizMsgCrypt msgCrypt;

    protected String appid;

    protected BasicWxHandler() {}

    public BasicWxHandler(String token) {
        this.token = token;
    }

    public BasicWxHandler(String token, String aeskey, String appid) {
        super();
        this.token = token;
        this.aeskey = aeskey;
        this.appid = appid;
    }

    @Override
    public boolean check(String signature, String timestamp, String nonce, String key) {
        return Wxs.check(token, signature, timestamp, nonce);
    }

    public WXBizMsgCrypt getMsgCrypt() {
        if (msgCrypt == null)
            try {
                msgCrypt = new WXBizMsgCrypt(token, aeskey, appid);
            }
            catch (AesException e) {
                throw new RuntimeException(e);
            }
        return msgCrypt;
    }

//    public BasicWxHandler configure(PropertiesProxy conf, String prefix){
//        prefix = Strings.sBlank(prefix);
//        token = conf.check(prefix+"token");
//        aeskey = conf.get(prefix+"aes");
//        appid = conf.get(prefix+"appid");
//        return this;
//    }
}
