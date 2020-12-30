package com.quan.core.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
* @author 作者 gitgeek 
* @version 创建时间：2018-08-06 21:29
* 类说明  菜单实体
*/
@Data
@TableName("sys_menu")
public class SysMenu extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 749360940290141180L;
	private Long parentId;
	private String name;
	private String url;
	private String path;
	private String css;
	private Integer sort;
	@TableField(value="is_menu")
	private Integer isMenu;
	private Boolean hidden;
	
	@TableField(exist=false)
	private List<SysMenu> subMenus;
	@TableField(exist=false)
	private Long roleId;
	@TableField(exist=false)
	private Set<Long> menuIds;
}
