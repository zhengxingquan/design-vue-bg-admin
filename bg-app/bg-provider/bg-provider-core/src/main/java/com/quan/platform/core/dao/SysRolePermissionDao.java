package com.quan.platform.core.dao;

import com.quam.common.model.SysPermission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;


/**
* @author 作者 owen 
* @version 创建时间：2017年11月12日 上午22:57:51
 * 角色权限关系
 */
@Mapper
public interface SysRolePermissionDao {

	@Insert("insert into sys_role_permission(role_id, permission_id) values(#{roleId}, #{permissionId})")
	int save(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

	void saveBatch(@Param("roleId") Long roleId, @Param("permissions") Set<Long> permissions);
	
	int deleteBySelective(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

	Set<SysPermission> findByRoleIds(@Param("roleIds") Set<Long> roleIds);

}
