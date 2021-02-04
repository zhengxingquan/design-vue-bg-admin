package com.quan.core.controller;

import com.google.common.collect.Maps;
import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.model.SysClient;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.Result;
import com.quan.core.controller.request.client.QueryClientPageRequest;
import com.quan.core.factory.AuthClientFactory;
import com.quan.core.service.SysClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 角色相关接口
 *
 * @author owen 624191343@qq.com
 */
@RestController
@Api(tags = "CLIENT API")
@RequestMapping("/sys/clients")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "应用管理", permission = "sys:client")
public class SysClientController {

    @Autowired
    private SysClientService sysClientService;


    @GetMapping
    @ApiOperation(value = "应用列表")
    @PreAuthorize("hasAuthority('client:get/clients')")
    @SLog(module = "auth-server")
    public PageResult<SysClient> list(@RequestBody QueryClientPageRequest client) {
        return sysClientService.list(client);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取应用")
    @PreAuthorize("hasAuthority('client:get/clients/{id}')")
    @SLog(module = "auth-server")
    public SysClient get(@PathVariable Long id) {
        try {
            return sysClientService.getById(id);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "所有应用")
    @SLog(module = "auth-server")
    @PreAuthorize("hasAnyAuthority('client:get/clients')")
    public List<SysClient> findList() {
        try {
            return sysClientService.data(null);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除应用")
    @PreAuthorize("hasAuthority('client:delete/clients')")
    @SLog(module = "auth-server")
    public void delete(@PathVariable Long id) {
        try {
            sysClientService.delete(id);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "保存或者修改应用")
    @PreAuthorize("hasAuthority('client:post/clients')")
    public Result saveOrUpdate(@RequestBody SysClient sysClient) {
        try {
            return sysClientService.saveOrUpdate(sysClient);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @PutMapping("/updateEnabled")
    @ApiOperation(value = "修改状态")
    @PreAuthorize("hasAuthority('client:post/clients')")
    @SLog(module = "auth-server")
    public Result updateEnabled(@RequestBody Map<String, Object> params) {
        try {
            return sysClientService.updateEnabled(params);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

}
