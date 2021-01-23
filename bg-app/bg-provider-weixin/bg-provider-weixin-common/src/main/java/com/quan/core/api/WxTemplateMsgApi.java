package com.quan.core.api;

import com.quan.core.model.WxTemplateData;

import java.util.Map;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxTemplateMsgApi {

    WxResp template_api_set_industry(String industry_id1, String industry_id2);

    WxResp template_api_add_template(String template_id_short);

    WxResp template_api_del_template(String template_id);

    WxResp template_send(String touser,
                         String template_id,
                         String url,
                         Map<String, WxTemplateData> data);

    WxResp template_send(String touser, String template_id, String url, Map<String, Object> miniprogram, Map<String, WxTemplateData> data);

    WxResp get_all_private_template();

    WxResp get_industry();
}
