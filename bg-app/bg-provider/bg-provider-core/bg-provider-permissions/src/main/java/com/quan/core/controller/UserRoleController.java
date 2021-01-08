package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.request.create.UserRoleCreateRequest;
import com.quan.core.request.update.UserRoleUpdateRequest;
import com.quan.core.service.UserRoleService;
import com.quan.core.request.del.UserRoleBatchDeleteRequest;
import com.quan.core.request.del.UserRoleDeleteRequest;
import com.quan.core.request.UserRolePageQueryRequest;
import com.quan.core.request.UserRoleQueryRequest;
import com.quan.core.request.UserRoleFindOneByIdRequest;
import com.quan.core.request.UserRoleEnableRequest;
import com.quan.core.request.UserRoleDisableRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 用户与角色
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-08 19:23:48
 */
@RestController
@RequestMapping("sys/user/role")
@Api(tags = "用户与角色管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "用户与角色管理", permission = "sys:user:role")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:user:role:list')")
    @SLog(module = "permissions-center", tag = "查询列表")
    public Object data(@RequestBody UserRolePageQueryRequest req) {
        return userRoleService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:user:role:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:user:role:save", parentPermission = "sys:user:role")
    @SLog(module = "permissions-center", tag = "添加数据")
    public Result doSave(@RequestBody UserRoleCreateRequest req) {
            userRoleService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:user:role:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:user:role:save", parentPermission = "sys:user:role")
    @SLog(module = "permissions-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<UserRoleCreateRequest> req) {
            userRoleService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:user:role:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:user:role:update", parentPermission = "sys:user:role")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody UserRoleUpdateRequest req) {
            userRoleService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:user:role:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:user:role:delete", parentPermission = "sys:user:role")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doDelete(@RequestBody UserRoleDeleteRequest req) {
        return JsonResult.succeed(userRoleService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:user:role:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:user:role:delete", parentPermission = "sys:user:role")
    @SLog(module = "permissions-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody UserRoleBatchDeleteRequest req) {
        return JsonResult.succeed(userRoleService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:user:role:list')")
    @SLog(module = "permissions-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody UserRoleFindOneByIdRequest req) {
        return JsonResult.succeed(userRoleService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:user:role:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody UserRoleQueryRequest req) {
        return JsonResult.succeed(userRoleService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:user:role:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result data(@RequestBody UserRoleQueryRequest req) {
        return JsonResult.succeed(userRoleService.list(req));
    }


    /**
    * 启用
    */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:user:role:enable')")
    @SLog(module = "permissions-center", tag = "启用")
    public Result doEnable(@RequestBody UserRoleEnableRequest req) {
        return JsonResult.succeed(userRoleService.enable(req));
    }


    /**
    * 禁用
    */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:user:role:disable')")
    @SLog(module = "permissions-center", tag = "禁用")
    public Result doDisable(@RequestBody UserRoleDisableRequest req) {
        return JsonResult.succeed(userRoleService.disable(req));
    }




}
