package com.quan.core.pay.model;

import com.quan.core.constant.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/3
 * 描述：
 * 订单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    private Long id;// 主键
    private Long productId;// 商品ID
    private String subject;//订单名称
    private String body;// 商品描述
    private String totalFee;// 总金额(单位是分)
    private String outTradeNo;// 订单号(唯一)
    private String spbillCreateIp;// 发起人IP地址
    private String attach;// 附件数据主要用于商户携带订单的自定义数据
    private Short payType;// 支付类型(1:支付宝 2:微信 3:银联)
    private Short payWay;// 支付方式 (1：PC,平板 2：手机)
    private String frontUrl;// 前台回调地址  非扫码支付使用
}
