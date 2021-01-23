package com.quan.core.api;

import com.quan.core.model.WxArticle;
import com.quan.core.model.WxOutMsg;

import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 *
 * 高级群发
 */
public interface WxMassApi {

    WxResp mass_uploadnews(List<WxArticle> articles);

    WxResp mass_sendall(boolean is_to_all, String group_id, WxOutMsg msg);

    WxResp mass_send(List<String> touser, WxOutMsg msg);

    WxResp mass_del(String msg_id);

    WxResp mass_preview(String touser, WxOutMsg msg);

    WxResp mass_get(String msg_id);

}
