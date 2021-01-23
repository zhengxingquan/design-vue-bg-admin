package com.quan.core.api;

import com.quan.core.model.WxMatchRule;
import com.quan.core.model.WxMenu;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxMenuApi {

    WxResp menu_create(LinkedHashMap map);

    WxResp menu_create(List<WxMenu> button);

    WxResp menu_get();

    WxResp menu_delete();

    WxResp menu_addconditional(List<WxMenu> button, WxMatchRule matchRule);

    WxResp menu_delconditional(String menuid);

    WxResp menu_trymatch(String user_id);
}
