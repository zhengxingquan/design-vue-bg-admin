package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.service.RoleMenuGroupService;
import com.quan.core.controller.request.create.RoleMenuGroupCreateRequest;
import com.quan.core.controller.request.update.RoleMenuGroupUpdateRequest;
import com.quan.core.controller.request.del.RoleMenuGroupBatchDeleteRequest;
import com.quan.core.controller.request.del.RoleMenuGroupDeleteRequest;
import com.quan.core.controller.request.RoleMenuGroupPageQueryRequest;
import com.quan.core.controller.request.RoleMenuGroupQueryRequest;
import com.quan.core.controller.request.RoleMenuGroupFindOneByIdRequest;
import com.quan.core.controller.request.RoleMenuGroupEnableRequest;
import com.quan.core.controller.request.RoleMenuGroupDisableRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 角色与菜单组
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-08 19:08:40
 */
@RestController
@RequestMapping("sys/role/menu/group")
@Api(tags = "角色与菜单组管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "角色与菜单组管理", permission = "sys:role:menu:group")
public class RoleMenuGroupController {

    @Autowired
    private RoleMenuGroupService roleMenuGroupService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:list')")
    @SLog(module = "permissions-center", tag = "查询列表")
    public Object data(@RequestBody RoleMenuGroupPageQueryRequest req) {
        return roleMenuGroupService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:menu:group:save", parentPermission = "sys:role:menu:group")
    @SLog(module = "permissions-center", tag = "添加数据")
    public Result doSave(@RequestBody RoleMenuGroupCreateRequest req) {
            roleMenuGroupService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:menu:group:save", parentPermission = "sys:role:menu:group")
    @SLog(module = "permissions-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<RoleMenuGroupCreateRequest> req) {
            roleMenuGroupService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:role:menu:group:update", parentPermission = "sys:role:menu:group")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody RoleMenuGroupUpdateRequest req) {
            roleMenuGroupService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:role:menu:group:delete", parentPermission = "sys:role:menu:group")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doDelete(@RequestBody RoleMenuGroupDeleteRequest req) {
        return JsonResult.succeed(roleMenuGroupService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:role:menu:group:delete", parentPermission = "sys:role:menu:group")
    @SLog(module = "permissions-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody RoleMenuGroupBatchDeleteRequest req) {
        return JsonResult.succeed(roleMenuGroupService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:list')")
    @SLog(module = "permissions-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody RoleMenuGroupFindOneByIdRequest req) {
        return JsonResult.succeed(roleMenuGroupService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody RoleMenuGroupQueryRequest req) {
        return JsonResult.succeed(roleMenuGroupService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result data(@RequestBody RoleMenuGroupQueryRequest req) {
        return JsonResult.succeed(roleMenuGroupService.list(req));
    }


    /**
    * 启用
    */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:enable')")
    @SLog(module = "permissions-center", tag = "启用")
    public Result doEnable(@RequestBody RoleMenuGroupEnableRequest req) {
        return JsonResult.succeed(roleMenuGroupService.enable(req));
    }


    /**
    * 禁用
    */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:group:disable')")
    @SLog(module = "permissions-center", tag = "禁用")
    public Result doDisable(@RequestBody RoleMenuGroupDisableRequest req) {
        return JsonResult.succeed(roleMenuGroupService.disable(req));
    }




}
