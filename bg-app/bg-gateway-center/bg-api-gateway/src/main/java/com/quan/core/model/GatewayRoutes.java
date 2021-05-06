package com.quan.core.model;

import com.quan.core.constant.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/4/30
 * 描述：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRoutes extends BaseEntity {

    private String uri;

    private String predicates;

    private String filters;

    private Integer order;

    private String description;

    private Date createTime;

    private Date updateTime;

}
