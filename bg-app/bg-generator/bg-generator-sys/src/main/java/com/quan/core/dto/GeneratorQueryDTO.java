package com.quan.core.dto;

import com.quan.common.dto.query.PageQueryDTO;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Data
public class GeneratorQueryDTO extends PageQueryDTO {
    private String tableName;
}
