package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxTemplateData extends BaseModel {

    public static final String DFT_COLOR = "#173177";

    private String value;
    private String color = DFT_COLOR;

}
