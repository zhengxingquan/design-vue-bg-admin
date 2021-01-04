package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxSendLocationInfo extends BaseModel {

    private double location_X;
    private double location_Y;
    private double scale;
    private String label;
    private String poiname;
}
