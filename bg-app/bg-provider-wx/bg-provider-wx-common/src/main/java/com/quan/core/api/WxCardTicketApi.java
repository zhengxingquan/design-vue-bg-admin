package com.quan.core.api;

import com.quan.core.store.WxCardTicketStore;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxCardTicketApi {

    /**
     * 注入用于存储卡券api_ticket（调用卡券相关接口的临时票据）的仓库
     *
     * @author JinYi
     * @param cts
     */
    void setCardTicketStore(WxCardTicketStore cts);

    /**
     * 获取用于存储卡券api_ticket（调用卡券相关接口的临时票据）的仓库
     *
     * @author JinYi
     * @return
     */
    WxCardTicketStore getCardTicketStore();

    /**
     * 获取卡券api_ticket（调用卡券相关接口的临时票据）
     *
     * @author JinYi
     * @return
     */
    String getCardTicket();

}
