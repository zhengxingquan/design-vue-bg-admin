package com.quan.core.request;

import com.quan.core.common.request.RequestPage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModel;

/**
 * 角色组与菜单 分页查询请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:43:42
 */

@Getter
@Setter
@Data
@ApiModel
public class RoleGroupMenuPageQueryRequest extends RequestPage {

}
