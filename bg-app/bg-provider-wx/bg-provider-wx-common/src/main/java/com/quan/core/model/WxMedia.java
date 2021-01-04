package com.quan.core.model;

import com.quan.core.model.base.BaseModel;
import lombok.Data;

import java.io.InputStream;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Data
public class WxMedia extends BaseModel {

    private String id;
    private long size;
    private String contentType;
    private transient InputStream stream;
}
