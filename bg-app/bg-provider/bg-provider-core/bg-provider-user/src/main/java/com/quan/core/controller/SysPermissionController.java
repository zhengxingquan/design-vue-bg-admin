package com.quan.core.controller;

import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.exception.service.ServiceException;
import com.quan.core.common.model.SysPermission;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.JsonResult;
import com.quan.core.annotation.SLog;
import com.quan.core.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


/**
* @author 作者 owen 
* @version 创建时间：2017年11月12日 上午22:57:51
* 权限管理
 */
@RestController
@Api(tags = "PERMISSION API")
public class SysPermissionController {

	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 删除权限标识
	 * 参考 /permissions/1
	 * @param id
	 * @throws ControllerException 
	 */
	@DeleteMapping("/permissions/{id}")
	@ApiOperation(value = "后台管理删除权限标识")
	@PreAuthorize("hasAuthority('permission:delete/permissions/{id}')")
	@SLog(module="user-center")
	public JsonResult delete(@PathVariable Long id) throws ControllerException {

		try {
			sysPermissionService.delete(id);
			return  JsonResult.succeed("操作成功");
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}

	}


	/**
	 * 查询所有的权限标识
	 * 参考 ?start=0&length=10
	 * @return
	 * @throws ControllerException 
	 */
	@GetMapping("/permissions")
	@ApiOperation(value = "后台管理查询所有的权限标识")
	@PreAuthorize("hasAuthority('permission:get/permissions')")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "limit",value = "分页结束位置", required = true, dataType = "Integer")
    })
	@SLog(module="user-center")
	public PageResult<SysPermission> findPermissions(@RequestParam Map<String, Object> params) throws ControllerException {
		
		try {
			return sysPermissionService.findPermissions(params);
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}

	/**
	 * 权限新增或者更新
	 * @param sysPermission
	 * @return
	 * @throws ControllerException 
	 */
	@PostMapping("/permissions/saveOrUpdate")
	@PreAuthorize("hasAnyAuthority('permission:put/permissions','permission:post/permissions')")
	@SLog(module="user-center")
	public JsonResult saveOrUpdate(@RequestBody SysPermission sysPermission) throws ControllerException {
		try{
			if (sysPermission.getId()!=null){
				sysPermissionService.update(sysPermission);
			}else {
				sysPermissionService.save(sysPermission);
			}
			return JsonResult.succeed("操作成功");
		}catch (ServiceException e){
			throw new ControllerException(e);
		}
	}

	@ApiOperation(value = "根据roleId获取对应的权限")
	@GetMapping("/permissions/{roleId}/permissions")
	@PreAuthorize("hasAuthority('permission:get/permissions/{roleId}/permissions')")
	@SLog(module="user-center")
	public List<Map<String, Object>> findAuthByRoleId(@PathVariable Long roleId) throws ControllerException {
		
		try {
			List<Map<String, Object>> authTrees = new ArrayList<>();
			Set<Long> roleIds = new HashSet<Long>();
			//初始化角色
			roleIds.add(roleId);
			Set<SysPermission> roleAuths = sysPermissionService.findByRoleIds(roleIds);//根据roleId获取对应的权限
			PageResult<SysPermission> allAuths = sysPermissionService.findPermissions(null);//根据roleId获取对应的权限


			Map<Long,SysPermission> roleAuthsMap = roleAuths.stream().collect(Collectors.toMap(SysPermission::getId, SysPermission->SysPermission));

			for (SysPermission sysPermission : allAuths.getData() ){
				Map<String, Object> authTree = new HashMap<>();
				authTree.put("id",sysPermission.getId() + "");
				authTree.put("name",sysPermission.getName());
				authTree.put("open",true);
				authTree.put("checked", false);
				if (roleAuthsMap.get(sysPermission.getId())!=null){
					authTree.put("checked", true);
				}
				authTrees.add(authTree);
			}

			return authTrees;
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	/**
	 * 给角色分配权限
	 * @throws ControllerException 
	 */
	@ApiOperation(value = "角色分配权限")
	@PostMapping("/permissions/granted")
	@PreAuthorize("hasAuthority('permission:post/permissions/granted')")
	@SLog(module="user-center")
	public JsonResult setPermissionToRole(@RequestBody SysPermission sysPermission) throws ControllerException {
		try {
			sysPermissionService.setPermissionToRole(sysPermission.getRoleId(),sysPermission.getAuthIds());
			return JsonResult.succeed("操作成功");
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}

}
