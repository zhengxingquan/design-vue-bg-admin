package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.controller.request.create.UserRoleGroupCreateRequest;
import com.quan.core.controller.request.del.UserRoleGroupBatchDeleteRequest;
import com.quan.core.controller.request.del.UserRoleGroupDeleteRequest;
import com.quan.core.controller.request.update.UserRoleGroupUpdateRequest;
import com.quan.core.service.UserRoleGroupService;
import com.quan.core.controller.request.UserRoleGroupPageQueryRequest;
import com.quan.core.controller.request.UserRoleGroupQueryRequest;
import com.quan.core.controller.request.UserRoleGroupFindOneByIdRequest;
import com.quan.core.controller.request.UserRoleGroupEnableRequest;
import com.quan.core.controller.request.UserRoleGroupDisableRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 用户与角色组
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-08 19:23:48
 */
@RestController
@RequestMapping("sys/user/role/group")
@Api(tags = "用户与角色组管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "用户与角色组管理", permission = "sys:user:role:group")
public class UserRoleGroupController {

    @Autowired
    private UserRoleGroupService userRoleGroupService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:list')")
    @SLog(module = "permissions-center", tag = "查询列表")
    public Object data(@RequestBody UserRoleGroupPageQueryRequest req) {
        return userRoleGroupService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:user:role:group:save", parentPermission = "sys:user:role:group")
    @SLog(module = "permissions-center", tag = "添加数据")
    public Result doSave(@RequestBody UserRoleGroupCreateRequest req) {
            userRoleGroupService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:user:role:group:save", parentPermission = "sys:user:role:group")
    @SLog(module = "permissions-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<UserRoleGroupCreateRequest> req) {
            userRoleGroupService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:user:role:group:update", parentPermission = "sys:user:role:group")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody UserRoleGroupUpdateRequest req) {
            userRoleGroupService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:user:role:group:delete", parentPermission = "sys:user:role:group")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doDelete(@RequestBody UserRoleGroupDeleteRequest req) {
        return JsonResult.succeed(userRoleGroupService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:user:role:group:delete", parentPermission = "sys:user:role:group")
    @SLog(module = "permissions-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody UserRoleGroupBatchDeleteRequest req) {
        return JsonResult.succeed(userRoleGroupService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:list')")
    @SLog(module = "permissions-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody UserRoleGroupFindOneByIdRequest req) {
        return JsonResult.succeed(userRoleGroupService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody UserRoleGroupQueryRequest req) {
        return JsonResult.succeed(userRoleGroupService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result data(@RequestBody UserRoleGroupQueryRequest req) {
        return JsonResult.succeed(userRoleGroupService.list(req));
    }


    /**
    * 启用
    */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:enable')")
    @SLog(module = "permissions-center", tag = "启用")
    public Result doEnable(@RequestBody UserRoleGroupEnableRequest req) {
        return JsonResult.succeed(userRoleGroupService.enable(req));
    }


    /**
    * 禁用
    */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:user:role:group:disable')")
    @SLog(module = "permissions-center", tag = "禁用")
    public Result doDisable(@RequestBody UserRoleGroupDisableRequest req) {
        return JsonResult.succeed(userRoleGroupService.disable(req));
    }




}
