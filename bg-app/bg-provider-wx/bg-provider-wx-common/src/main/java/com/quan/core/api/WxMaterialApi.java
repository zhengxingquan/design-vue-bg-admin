package com.quan.core.api;

import com.quan.core.NutResource;
import com.quan.core.model.WxArticle;
import com.quan.core.model.WxMassArticle;

import java.io.File;
import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxMaterialApi {

    WxResp add_news(WxMassArticle...news);

    WxResp uploadimg(File f);

    WxResp uploadnews(List<WxMassArticle> articles) ;

    WxResp add_material(String type, File f);

    WxResp add_video(File f, String title, String introduction);

    NutResource get_material(String media_id);

    List<WxArticle> get_material_news(String media_id);

    WxResp get_material_video(String media_id);

    WxResp del_material(String media_id);

    WxResp update_material(String media_id, int index, WxArticle article);

    WxResp get_materialcount();

    WxResp batchget_material(String type, int offset, int count);
}
