package com.quan.common.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


/***
 *   分页实体类
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/16 10:16
 * 分页实体类
 * total 总数
 * code  是否成功
 * data 当前页结果集
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -275582248840137389L;
    @ApiModelProperty(value = "要查询的起始页码")
    private int pageNumber = 0;
    @ApiModelProperty(value = "每页显示数量")
    private int pageSize = 10;
    @ApiModelProperty(value = "总结果数")
    private long count;
    @ApiModelProperty(value = "错误消息")
    private String msg;
    @ApiModelProperty(value = "成功的状态码")
    private int code = 0;
    @ApiModelProperty(value = "数据集合")
    private List<T> data;
}
