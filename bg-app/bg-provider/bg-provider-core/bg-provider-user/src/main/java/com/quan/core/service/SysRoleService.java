package com.quan.core.service;

import com.quan.core.constant.exception.service.ServiceException;
import com.quan.core.constant.model.SysPermission;
import com.quan.core.constant.model.SysRole;
import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.Result;

import java.util.Map;
import java.util.Set;

/**
* @author 作者 owen 
* @version 创建时间：2017年11月12日 上午22:57:51
 */
public interface SysRoleService {

	/**
	 * 保存角色
	 * @param sysRole
	 */
	void save(SysRole sysRole)  throws ServiceException;

	/**
	 * 修改角色
	 * @param sysRole
	 */
	void update(SysRole sysRole)  throws ServiceException;

	/**
	 * 删除角色
	 * @param id
	 */
	void deleteRole(Long id)  throws ServiceException;

	

	/**
	 * ID获取角色
	 * @param id
	 * @return
	 */
	SysRole findById(Long id)  throws ServiceException;

	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	PageResult<SysRole> findRoles(Map<String, Object> params)  throws ServiceException;

	/**
	 * 角色权限列表
	 * @param roleId
	 * @return
	 */
	Set<SysPermission> findPermissionsByRoleId(Long roleId)  throws ServiceException;

	/**
	 * 更新角色
	 * @param sysRole
	 */
	Result saveOrUpdate(SysRole sysRole)  throws ServiceException;

}
