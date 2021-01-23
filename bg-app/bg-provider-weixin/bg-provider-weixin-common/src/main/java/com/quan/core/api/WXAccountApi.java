package com.quan.core.api;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WXAccountApi {

    public static enum Type {
        TEMP("QR_SCENE"), TEMPRGS("QR_STR_SCENE"), EVER("QR_LIMIT_SCENE"), EVERARGS("QR_LIMIT_STR_SCENE");

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private Type(String value) {
            this.value = value;
        }

    }

    WxResp createQRTicket(long expire, Type type, int id);

    WxResp createQRTicket(long expire, Type type, String str);

    String qrURL(String ticket);
}
