package com.quan.core.api;

import com.quan.core.common.util.Each;
import com.quan.core.model.WxGroup;
import com.quan.core.model.WxTag;

import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 *
 * 用户管理API
 */
public interface WxUserApi {


    WxResp groups_create(WxGroup group);

    WxResp groups_get();

    WxResp groups_getid(String openid);

    WxResp groups_update(WxGroup group);

    WxResp groups_member_update(String openid, String groupid);

    // -----------------------------------------------

    WxResp tags_create(WxTag tag);

    WxResp tags_get();

    WxResp tags_update(WxTag tag);

    WxResp tags_delete(WxTag tag);

    WxResp tag_getusers(String tagid, String nextOpenid);

    WxResp tags_members_batchtagging(List<String> openids, String tagid);

    WxResp tags_members_chuntagging(List<String> openids, String tagid);

    WxResp tags_getidlist(String openid);

    // -----------------------------------------------

    WxResp user_info(String openid, String lang);

    void user_get(Each<String> each);

    WxResp user_info_updatemark(String openid, String remark);
}
