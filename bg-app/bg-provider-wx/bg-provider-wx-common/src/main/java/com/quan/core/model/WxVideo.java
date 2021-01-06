package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：视频
 */
@Data
public class WxVideo extends BaseModel {
    private String mediaId;
    private String title;
    private String description;
    private String thumb_media_id;
}
