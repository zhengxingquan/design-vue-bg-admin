package com.quan.core.model;

import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
@Data
public class EventExecuteInfo {

    private Long id;

    private String eventCode;

    private Integer maxNum;

    private Integer currentNum;

    private Integer executeStatus;

    /**
     * 扩展数据
     */
    private String exData;
}
