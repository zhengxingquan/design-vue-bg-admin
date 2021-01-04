package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxArticle extends BaseModel {

    private String title;
    private String description;
    private String picUrl;
    private String url;

}
