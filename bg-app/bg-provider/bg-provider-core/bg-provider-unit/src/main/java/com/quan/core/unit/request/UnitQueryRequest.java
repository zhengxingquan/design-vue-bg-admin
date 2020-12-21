package com.quan.core.unit.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * 系统单位表 条件查询请求类
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-21 19:28:04
 */

@Getter
@Setter
@Data
public class UnitQueryRequest {

                    /**
         * 父级ID
         */
        @ApiModelProperty(value = "父级ID")
        private String parentId;
                        /**
         * 单位名称
         */
        @ApiModelProperty(value = "单位名称")
        private String name;
                        /**
         * 单位别名
         */
        @ApiModelProperty(value = "单位别名")
        private String aliasName;
                        /**
         * 机构编码
         */
        @ApiModelProperty(value = "机构编码")
        private String unitCode;
                        /**
         * 单位介绍
         */
        @ApiModelProperty(value = "单位介绍")
        private String note;
                        /**
         * 附加值一
         */
        @ApiModelProperty(value = "附加值一")
        private String field1;
                        /**
         * 附加值二
         */
        @ApiModelProperty(value = "附加值二")
        private String field2;
                        /**
         * 附加值三
         */
        @ApiModelProperty(value = "附加值三")
        private String field3;
                        /**
         * 排序字段
         */
        @ApiModelProperty(value = "排序字段")
        private Integer sort;
                        /**
         * 是否禁用
         */
        @ApiModelProperty(value = "是否禁用")
        private Integer disabled;
                        /**
         * 是否有子节点
         */
        @ApiModelProperty(value = "是否有子节点")
        private Integer hasChildren;
                        /**
         * 单位logo
         */
        @ApiModelProperty(value = "单位logo")
        private String logo;
                                                                    
}
