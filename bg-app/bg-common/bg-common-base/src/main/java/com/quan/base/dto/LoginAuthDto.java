package com.quan.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：
 */
@Data
@ApiModel(value = "登录人信息")
public class LoginAuthDto implements Serializable  {

    private static final long serialVersionUID = -1137852221455042256L;
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "登录名")
    private String loginName;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "组织ID")
    private Long groupId;
    @ApiModelProperty(value = "组织名称")
    private String groupName;

    public LoginAuthDto() {
    }

    public LoginAuthDto(String userId, String loginName, String userName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
    }

    public LoginAuthDto(String userId, String loginName, String userName, Long groupId, String groupName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
