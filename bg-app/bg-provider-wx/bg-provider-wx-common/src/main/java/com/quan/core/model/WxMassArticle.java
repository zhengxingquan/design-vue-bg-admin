package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxMassArticle extends BaseModel {

    private String title;
    private String author;
    private String thumb_media_id;
    private String content_source_url;
    private String content;
    private String digest;
    private int show_cover_pic;
    private int need_open_comment;
    private int only_fans_can_comment;
}
