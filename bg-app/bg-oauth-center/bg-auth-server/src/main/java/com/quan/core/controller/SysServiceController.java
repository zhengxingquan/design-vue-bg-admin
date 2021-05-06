package com.quan.core.controller;

import com.quan.core.constant.exception.controller.ControllerException;
import com.quan.core.constant.model.SysClient;
import com.quan.core.constant.model.SysService;
import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.annotation.SLog;
import com.quan.core.constant.web.Result;
import com.quan.core.service.SysServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: [gitgeek]
 * @Date: [2018-08-23 16:20]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Slf4j
@RestController
@Api(tags = "SERVICE API")
@RequestMapping("/services")
@SuppressWarnings("all")
public class SysServiceController {

    @Autowired
    private SysServiceService sysServiceService;

    /**
     * 查询所有服务
     * @return
     */
    @ApiOperation(value = "查询所有服务")
    @GetMapping("/findAlls")
    @PreAuthorize("hasAuthority('service:get/service/findAlls')")
    @SLog(module="auth-server")
    public PageResult<SysService> findAlls() {
        try {
			List<SysService> list = sysServiceService.findAll();
			return PageResult.<SysService>builder().data(list).code(0).count((long)list.size()).build() ;
		} catch (Exception e) {
			throw new ControllerException(e);
		}
    }

    /**
     * 获取服务以及顶级服务
     * @return
     */
    @ApiOperation(value = "获取服务以及顶级服务")
    @GetMapping("/findOnes")
    @PreAuthorize("hasAuthority('service:get/service/findOnes')")
    @SLog(module="auth-server")
    public PageResult<SysService> findOnes(){
        try {
			List<SysService> list = sysServiceService.findOnes();
			return PageResult.<SysService>builder().data(list).code(0).count((long)list.size()).build() ;
		} catch (Exception e) {
			throw new ControllerException(e);
		}
    }

    /**
     * 删除服务
     * @param id
     * @return
     */
    
    
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除服务")
    @PreAuthorize("hasAuthority('service:delete/service/{id}')")
    @SLog(module="auth-server")
    public Result delete(@PathVariable Long id){
        try {
			sysServiceService.delete(id);
			return JsonResult.succeed("操作成功");
		} catch (Exception e) {
			throw new ControllerException(e);
		}
    }

    
    @ApiOperation(value = "新增服务")
    @PostMapping("/saveOrUpdate")
    @SLog(module="auth-server")
    @PreAuthorize("hasAnyAuthority('service:post/saveOrUpdate')")
    public Result saveOrUpdate(@RequestBody SysService service) {
        try{
            if (service.getId() != null){
                sysServiceService.update(service);
            }else {
                sysServiceService.save(service);
            }
            return JsonResult.succeed("操作成功");
        }catch (Exception ex){
        	throw new ControllerException(ex);
        }
    }

    @ApiOperation(value = "根据clientId获取对应的服务")
    @GetMapping("/{clientId}/services")
    @SLog(module="auth-server")
    public List<Map<String, Object>> findServicesByclientId(@PathVariable Long clientId) {
        try {
			Set<Long> clientIds = new HashSet<Long>();
			//初始化应用
			clientIds.add(clientId);
			List<SysService> clientService = sysServiceService.findByClient(clientIds);
			List<SysService> allService = sysServiceService.findAll();
			List<Map<String, Object>> authTrees = new ArrayList<>();
			Map<Long,SysService> clientServiceMap = clientService.stream().collect(Collectors.toMap(SysService::getId, SysService->SysService));
			for (SysService sysService: allService) {
			    Map<String, Object> authTree = new HashMap<>();
			    authTree.put("id",sysService.getId());
			    authTree.put("name",sysService.getName());
			    authTree.put("pId",sysService.getParentId());
			    authTree.put("open",true);
			    authTree.put("checked", false);
			    if (clientServiceMap.get(sysService.getId())!=null){
			        authTree.put("checked", true);
			    }
			    authTrees.add(authTree);
			}

			return  authTrees;
		} catch (Exception e) {
			throw new ControllerException(e);
		}
    }

    @PostMapping("/granted")
    @SLog(module="auth-server")
    public Result setMenuToClient(@RequestBody SysClient sysClient) {
        try {
			sysServiceService.setMenuToClient(sysClient.getId(), sysClient.getServiceIds());
			return JsonResult.succeed("操作成功");
		} catch (Exception e) {
			throw new ControllerException(e);
		}
    }















}
