package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.model.SysClient;
import com.quan.core.common.request.del.BatchDeleteRequest;
import com.quan.core.common.request.del.DeleteRequest;
import com.quan.core.common.request.query.FindOneByIdRequest;
import com.quan.core.common.request.update.BatchEnableAndDisableRequest;
import com.quan.core.common.request.update.DisableRequest;
import com.quan.core.common.request.update.EnableRequest;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.Result;
import com.quan.core.controller.request.client.QueryClientPageRequest;
import com.quan.core.controller.request.client.QueryClientRequest;
import com.quan.core.controller.request.token.create.ClientCreateRequest;
import com.quan.core.controller.request.token.update.ClientUpdateRequest;
import com.quan.core.service.SysClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/list")
    @ApiOperation(value = "应用列表")
    @PreAuthorize("hasAuthority('sys:client:list')")
    @SLog(module = "auth-server")
    public PageResult<SysClient> list(@RequestBody QueryClientPageRequest client) {
        return null;
//        sysClientService.list(client);
    }

    @GetMapping("/findById")
    @ApiOperation(value = "根据id获取应用")
    @PreAuthorize("hasAuthority('sys:client:list')")
    @SLog(module = "auth-server")
    public Result findById(@RequestBody FindOneByIdRequest request) {
        return JsonResult.succeed(sysClientService.getById(request.getId()));
    }

    @GetMapping("/data")
    @ApiOperation(value = "所有应用")
    @SLog(module = "auth-server")
    @PreAuthorize("hasAuthority('sys:client:list')")
    public Result<List<SysClient>> data(@RequestBody QueryClientRequest request) {
        return JsonResult.succeed(sysClientService.data(request));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除应用")
    @PreAuthorize("hasAuthority('sys:client:delete')")
    @SLog(module = "auth-server")
    public void doDelete(@RequestBody DeleteRequest deleteRequest) {
        try {
            sysClientService.delete(deleteRequest.getId());
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @PostMapping("/deletes")
    @ApiOperation(value = "删除应用")
    @PreAuthorize("hasAuthority('sys:client:delete')")
    @SLog(module = "auth-server")
    public void doDeletes(@RequestBody BatchDeleteRequest deleteRequest) {
        try {
            sysClientService.deletes(deleteRequest.getIds());
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存应用")
    @PreAuthorize("hasAuthority('sys:client:save')")
    public Result doSave(@RequestBody ClientCreateRequest request) {

        return sysClientService.save(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改应用")
    @PreAuthorize("hasAuthority('sys:client:update')")
    public Result doUpdate(@RequestBody ClientUpdateRequest request) {
        return sysClientService.update(request);
    }

    /**
     * 启用
     */
    @PostMapping("/enable")
    @ApiOperation(value = "修改状态启用")
    @PreAuthorize("hasAuthority('sys:client:update:enable')")
    @SLog(module = "auth-server")
    public Result enable(@RequestBody EnableRequest request) {
        return sysClientService.enable(request.getId());
    }


    /**
     * 禁用
     */
    @PostMapping("/disable")
    @ApiOperation(value = "修改状态冻结")
    @PreAuthorize("hasAuthority('sys:client:update:disable')")
    @SLog(module = "auth-server")
    public Result disable(@RequestBody DisableRequest request) {
        return sysClientService.disable(request.getId());
    }


    /***
     *   批量启用
     */
    @PostMapping("/disable")
    @ApiOperation(value = "修改状态批量启用")
    @PreAuthorize("hasAuthority('sys:client:update:enable')")
    @SLog(module = "auth-server")
    public Result batchEnable(@RequestBody BatchEnableAndDisableRequest request) {
        return sysClientService.batchEnable(request.getId());
    }


    /***
     *   批量禁用
     */
    @PostMapping("/disable")
    @ApiOperation(value = "修改状态批量禁用")
    @PreAuthorize("hasAuthority('sys:client:update:disable')")
    @SLog(module = "auth-server")
    public Result batchDisable(@RequestBody BatchEnableAndDisableRequest request) {
        return sysClientService.batchDisable(request.getId());
    }


}
