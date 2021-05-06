package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.exception.controller.ControllerException;
import com.quan.core.constant.model.SysClient;
import com.quan.core.constant.request.del.BatchDeleteRequest;
import com.quan.core.constant.request.del.DeleteRequest;
import com.quan.core.constant.request.query.FindOneByIdRequest;
import com.quan.core.constant.request.update.BatchEnableAndDisableRequest;
import com.quan.core.constant.request.update.DisableRequest;
import com.quan.core.constant.request.update.EnableRequest;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.Result;
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
@Api(tags = "应用管理API")
@RequestMapping("/sys/clients")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "应用管理", permission = "sys:client")
public class SysClientController {

    @Autowired
    private SysClientService sysClientService;


    @GetMapping("/list")
    @ApiOperation(value = "获取列表数据应用")
    @PreAuthorize("hasAuthority('sys:client:list')")
    @SLog(module = "auth-server", tag = "获取列表数据应用")
    public PageResult<SysClient> list(@RequestBody QueryClientPageRequest client) {
        return null;
//        sysClientService.list(client);
    }

    @GetMapping("/findById")
    @ApiOperation(value = "根据id获取应用")
    @PreAuthorize("hasAuthority('sys:client:list')")
    @SLog(module = "auth-server", tag = "根据id获取应用")
    public Result findById(@RequestBody FindOneByIdRequest request) {
        return JsonResult.succeed(sysClientService.getById(request.getId()));
    }

    @GetMapping("/data")
    @ApiOperation(value = "查询列表不分页")
    @PreAuthorize("hasAuthority('sys:client:list')")
    @SLog(module = "auth-server", tag = "查询列表不分页")
    public Result<List<SysClient>> data(@RequestBody QueryClientRequest request) {
        return JsonResult.succeed(sysClientService.data(request));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除应用")
    @PreAuthorize("hasAuthority('sys:client:delete')")
    @SLog(module = "auth-server", tag = "删除应用")
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
    @SLog(module = "auth-server", tag = "删除应用")
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
    @SLog(module = "auth-server", tag = "保存应用")
    public Result doSave(@RequestBody ClientCreateRequest request) {

        return sysClientService.save(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改应用")
    @PreAuthorize("hasAuthority('sys:client:update')")
    @SLog(module = "auth-server", tag = "修改应用")
    public Result doUpdate(@RequestBody ClientUpdateRequest request) {
        return sysClientService.update(request);
    }

    /**
     * 启用
     */
    @PostMapping("/enable")
    @ApiOperation(value = "修改状态启用")
    @PreAuthorize("hasAuthority('sys:client:update:enable')")
    @SLog(module = "auth-server", tag = "修改状态启用")
    public Result enable(@RequestBody EnableRequest request) {
        return sysClientService.enable(request.getId());
    }


    /**
     * 禁用
     */
    @PostMapping("/disable")
    @ApiOperation(value = "修改状态冻结")
    @PreAuthorize("hasAuthority('sys:client:update:disable')")
    @SLog(module = "auth-server", tag = "修改状态冻结")
    public Result disable(@RequestBody DisableRequest request) {
        return sysClientService.disable(request.getId());
    }


    /***
     *   批量启用
     */
    @PostMapping("/disable")
    @ApiOperation(value = "修改状态批量启用")
    @PreAuthorize("hasAuthority('sys:client:update:enable')")
    @SLog(module = "auth-server", tag = "修改状态批量启用")
    public Result batchEnable(@RequestBody BatchEnableAndDisableRequest request) {
        return sysClientService.batchEnable(request.getId());
    }


    /***
     *   批量禁用
     */
    @PostMapping("/disable")
    @ApiOperation(value = "修改状态批量禁用")
    @PreAuthorize("hasAuthority('sys:client:update:disable')")
    @SLog(module = "auth-server", tag = "修改状态批量禁用")
    public Result batchDisable(@RequestBody BatchEnableAndDisableRequest request) {
        return sysClientService.batchDisable(request.getId());
    }


}
