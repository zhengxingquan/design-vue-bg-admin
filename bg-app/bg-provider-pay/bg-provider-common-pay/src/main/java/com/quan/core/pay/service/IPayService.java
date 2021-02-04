package com.quan.core.pay.service;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/3
 * 描述：支付服务
 */
public interface IPayService<T> {

    /***
     *   支付 付预下单
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/3 18:29
     * @param object

     * @return void
     */
    void pay(T object);

    /***
     *  支付退款
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/3 18:30
     * @param object

     * @return void
     */
    void refund(T object);

    /***
     *  关闭账单
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/3 18:30
     * @param object

     * @return void
     */
    void closeOrder(T object);

    /***
     *  下载对账单
     * @author zxq(956607644 @ qq.com)
     * @date 2021/2/3 18:32
     * @param billDate
     @param billType
      * @return void
     */
    void downloadBillUrl(String billDate, String billType);
}
