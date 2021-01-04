package com.quan.core.api;

import com.quan.core.model.*;

import java.io.File;
import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxPayApi {

    Map postPay(String url, String key, Map<String, Object> params);

    Map postPay(String url, String key, Map<String, Object> params, Object keydata, String password);

    Map pay_unifiedorder(String key, WxPayUnifiedOrder wxPayUnifiedOrder);

    Map pay_jsapi(String key, WxPayUnifiedOrder wxPayUnifiedOrder);

    Map pay_transfers(String key, WxPayTransfers wxPayTransfers, Object keydata, String password);

    Map send_redpack(String key, WxPayRedPack wxRedPack, Object keydata, String password);

    Map send_redpackgroup(String key, WxPayRedPackGroup wxRedPackGroup, Object keydata, String password);

    Map send_coupon(String key, WxPayCoupon wxPayCoupon, Object keydata, String password);

    Map pay_refund(String key, WxPayRefund wxPayRefund, Object keydata, String password);

    Map pay_refundquery(String key, WxPayRefundQuery wxPayRefundQuery);

    // 兼容老方法
    Map pay_transfers(String key, WxPayTransfers wxPayTransfers, File keydata, String password);

    Map send_redpack(String key, WxPayRedPack wxRedPack, File keydata, String password);

    Map send_redpackgroup(String key, WxPayRedPackGroup wxRedPackGroup, File keydata, String password);

    Map send_coupon(String key, WxPayCoupon wxPayCoupon, File keydata, String password);

    Map pay_refund(String key, WxPayRefund wxPayRefund, File keydata, String password);
}