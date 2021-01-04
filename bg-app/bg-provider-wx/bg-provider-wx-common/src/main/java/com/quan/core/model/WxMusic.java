package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxMusic extends BaseModel {

    private String title;
    private String description;
    private String musicUrl;
    private String hQMusicUrl;
    private String thumbMediaId;
}
