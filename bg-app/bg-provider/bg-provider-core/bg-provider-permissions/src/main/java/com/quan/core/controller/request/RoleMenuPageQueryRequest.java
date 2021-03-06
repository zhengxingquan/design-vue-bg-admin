package com.quan.core.controller.request;

import com.quan.core.constant.request.PageRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModel;

/**
 *  分页查询请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */

@Getter
@Setter
@Data
@ApiModel
public class RoleMenuPageQueryRequest extends PageRequest {

}
