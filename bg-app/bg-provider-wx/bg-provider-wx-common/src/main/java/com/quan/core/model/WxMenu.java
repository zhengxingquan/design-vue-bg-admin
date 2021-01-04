package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxMenu extends BaseModel {

    private String name;
    private String type;
    private String key;
    private String url;
    private String appid;
    private String pagepath;
    private String media_id;

    private List<WxMenu> subButtons;
}
