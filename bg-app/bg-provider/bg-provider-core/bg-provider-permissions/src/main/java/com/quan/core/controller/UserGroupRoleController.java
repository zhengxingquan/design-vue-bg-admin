package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.request.create.UserGroupRoleCreateRequest;
import com.quan.core.request.del.UserGroupRoleBatchDeleteRequest;
import com.quan.core.request.del.UserGroupRoleDeleteRequest;
import com.quan.core.request.update.UserGroupRoleUpdateRequest;
import com.quan.core.service.UserGroupRoleService;
import com.quan.core.request.UserGroupRolePageQueryRequest;
import com.quan.core.request.UserGroupRoleQueryRequest;
import com.quan.core.request.UserGroupRoleFindOneByIdRequest;
import com.quan.core.request.UserGroupRoleEnableRequest;
import com.quan.core.request.UserGroupRoleDisableRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 用户组与角色
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-08 19:18:17
 */
@RestController
@RequestMapping("sys/user/group/role")
@Api(tags = "用户组与角色管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "用户组与角色管理", permission = "sys:user:group:role")
public class UserGroupRoleController {

    @Autowired
    private UserGroupRoleService userGroupRoleService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:list')")
    @SLog(module = "permissions-center", tag = "查询列表")
    public Object data(@RequestBody UserGroupRolePageQueryRequest req) {
        return userGroupRoleService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:user:group:role:save", parentPermission = "sys:user:group:role")
    @SLog(module = "permissions-center", tag = "添加数据")
    public Result doSave(@RequestBody UserGroupRoleCreateRequest req) {
            userGroupRoleService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:user:group:role:save", parentPermission = "sys:user:group:role")
    @SLog(module = "permissions-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<UserGroupRoleCreateRequest> req) {
            userGroupRoleService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:user:group:role:update", parentPermission = "sys:user:group:role")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody UserGroupRoleUpdateRequest req) {
            userGroupRoleService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:user:group:role:delete", parentPermission = "sys:user:group:role")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doDelete(@RequestBody UserGroupRoleDeleteRequest req) {
        return JsonResult.succeed(userGroupRoleService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:user:group:role:delete", parentPermission = "sys:user:group:role")
    @SLog(module = "permissions-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody UserGroupRoleBatchDeleteRequest req) {
        return JsonResult.succeed(userGroupRoleService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:list')")
    @SLog(module = "permissions-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody UserGroupRoleFindOneByIdRequest req) {
        return JsonResult.succeed(userGroupRoleService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody UserGroupRoleQueryRequest req) {
        return JsonResult.succeed(userGroupRoleService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result data(@RequestBody UserGroupRoleQueryRequest req) {
        return JsonResult.succeed(userGroupRoleService.list(req));
    }


    /**
    * 启用
    */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:enable')")
    @SLog(module = "permissions-center", tag = "启用")
    public Result doEnable(@RequestBody UserGroupRoleEnableRequest req) {
        return JsonResult.succeed(userGroupRoleService.enable(req));
    }


    /**
    * 禁用
    */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:user:group:role:disable')")
    @SLog(module = "permissions-center", tag = "禁用")
    public Result doDisable(@RequestBody UserGroupRoleDisableRequest req) {
        return JsonResult.succeed(userGroupRoleService.disable(req));
    }




}
