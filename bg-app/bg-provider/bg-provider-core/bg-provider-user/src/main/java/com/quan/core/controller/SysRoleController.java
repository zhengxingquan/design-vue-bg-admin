package com.quan.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.exception.service.ServiceException;
import com.quan.core.common.model.SysRole;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.JsonResult;
import com.quan.core.annotation.SLog;
import com.quan.core.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
* @author 作者 owen 
* @version 创建时间：2017年11月12日 上午22:57:51
* 角色管理
 */

@RestController
@Api(tags = "ROLE API")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 后台管理查询角色
	 * @param params
	 * @return
	 * @throws JsonProcessingException 
	 */
	@GetMapping("/roles")
	@ApiOperation(value = "后台管理查询角色")
	@PreAuthorize("hasAuthority('role:get/roles')")
	@SLog(module="user-center")
	public PageResult<SysRole> findRoles(@RequestParam Map<String, Object> params) throws ControllerException {
		try {
//			BizLog.info("角色列表", LogEntry.builder().clazz(this.getClass().getName()).method("findRoles").msg("hello").path("/roles").build());
			return sysRoleService.findRoles(params);
		} catch (ServiceException e) {
			 throw new ControllerException(e);
		}
	}

	/**
	 * 角色新增或者更新
	 * @param sysRole
	 * @return
	 * @throws ControllerException 
	 */
	@PostMapping("/roles/saveOrUpdate")
	@PreAuthorize("hasAnyAuthority('role:post/roles','role:put/roles')")
	@SLog(module="user-center")
	public JsonResult saveOrUpdate(@RequestBody SysRole sysRole) throws ControllerException {
		try {
			return sysRoleService.saveOrUpdate(sysRole);
		} catch (ServiceException e) {
			 throw new ControllerException(e);
		}
	}

	/**
	 * 后台管理删除角色
	 * delete /role/1
	 * @param id
	 * @throws ControllerException 
	 */
	@DeleteMapping("/roles/{id}")
	@ApiOperation(value = "后台管理删除角色")
	@PreAuthorize("hasAuthority('role:delete/roles/{id}')")
	@SLog(module="user-center")
	public JsonResult deleteRole(@PathVariable Long id) throws ControllerException {
		try {
			if (id == 1L){
				return JsonResult.failed("管理员不可以删除");
			}
			sysRoleService.deleteRole(id);
			return JsonResult.succeed("操作成功");
		}catch (Exception e){
			 throw new ControllerException(e);
		}
	}
}
