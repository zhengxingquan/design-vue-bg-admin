package com.quan.core.request;

import com.quan.core.common.request.RequestPage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModel;

/**
 * 用户组与角色组 分页查询请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */

@Getter
@Setter
@Data
@ApiModel
public class UserGroupRoleGroupPageQueryRequest extends RequestPage {

}
