package com.quan.common.dto.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Data
public class PageQueryDTO implements Serializable {
    private int pageNumber = 0;
    private int pageSize = 10;
}
