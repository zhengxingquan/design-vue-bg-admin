package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.controller.request.*;
import com.quan.core.controller.request.del.RoleMenuBatchDeleteRequest;
import com.quan.core.controller.request.del.RoleMenuDeleteRequest;
import com.quan.core.controller.request.create.RoleMenuCreateRequest;
import com.quan.core.controller.request.update.RoleMenuUpdateRequest;
import com.quan.core.service.RoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */
@RestController
@RequestMapping("sys/role/menu")
@Api(tags = "角色与菜单管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "角色与菜单管理", permission = "sys:role:menu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:list')")
    @SLog(module = "permissions-center", tag = "查询列表")
    public Object data(@RequestBody RoleMenuPageQueryRequest req) {
        return roleMenuService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:menu:save", parentPermission = "sys:role:menu")
    @SLog(module = "permissions-center", tag = "添加数据")
    public Result doSave(@RequestBody RoleMenuCreateRequest req) {
        roleMenuService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 批量添加数据
     */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:menu:save", parentPermission = "sys:role:menu")
    @SLog(module = "permissions-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<RoleMenuCreateRequest> req) {
        roleMenuService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:role:menu:update", parentPermission = "sys:role:menu")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody RoleMenuUpdateRequest req) {
        roleMenuService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:role:menu:delete", parentPermission = "sys:role:menu")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doDelete(@RequestBody RoleMenuDeleteRequest req) {
        return JsonResult.succeed(roleMenuService.delete(req.getId()), "删除成功");
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:role:menu:delete", parentPermission = "sys:role:menu")
    @SLog(module = "permissions-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody RoleMenuBatchDeleteRequest req) {
        return JsonResult.succeed(roleMenuService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:list')")
    @SLog(module = "permissions-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody RoleMenuFindOneByIdRequest req) {
        return JsonResult.succeed(roleMenuService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     *
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody RoleMenuQueryRequest req) {
        return JsonResult.succeed(roleMenuService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result data(@RequestBody RoleMenuQueryRequest req) {
        return JsonResult.succeed(roleMenuService.list(req));
    }


    /**
     * 启用
     */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:enable')")
    @SLog(module = "permissions-center", tag = "启用")
    public Result doEnable(@RequestBody RoleMenuEnableRequest req) {
        return JsonResult.succeed(roleMenuService.enable(req));
    }


    /**
     * 禁用
     */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:role:menu:disable')")
    @SLog(module = "permissions-center", tag = "禁用")
    public Result doDisable(@RequestBody RoleMenuDisableRequest req) {
        return JsonResult.succeed(roleMenuService.disable(req));
    }


}
