package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.controller.request.RoleGroupMenuEnableRequest;
import com.quan.core.controller.request.RoleGroupMenuQueryRequest;
import com.quan.core.controller.request.create.RoleGroupMenuCreateRequest;
import com.quan.core.controller.request.del.RoleGroupMenuBatchDeleteRequest;
import com.quan.core.controller.request.del.RoleGroupMenuDeleteRequest;
import com.quan.core.controller.request.update.RoleGroupMenuUpdateRequest;
import com.quan.core.service.RoleGroupMenuService;
import com.quan.core.controller.request.RoleGroupMenuPageQueryRequest;
import com.quan.core.controller.request.RoleGroupMenuFindOneByIdRequest;
import com.quan.core.controller.request.RoleGroupMenuDisableRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 角色组与菜单
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-08 18:43:42
 */
@RestController
@RequestMapping("sys/role/group/menu")
@Api(tags = "角色组与菜单管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "角色组与菜单管理", permission = "sys:role:group:menu")
public class RoleGroupMenuController {

    @Autowired
    private RoleGroupMenuService roleGroupMenuService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:list')")
    @SLog(module = "permissions-center", tag = "查询列表")
    public Object data(@RequestBody RoleGroupMenuPageQueryRequest req) {
        return roleGroupMenuService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:menu:save", parentPermission = "sys:role:group:menu")
    @SLog(module = "permissions-center", tag = "添加数据")
    public Result doSave(@RequestBody RoleGroupMenuCreateRequest req) {
            roleGroupMenuService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:menu:save", parentPermission = "sys:role:group:menu")
    @SLog(module = "permissions-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<RoleGroupMenuCreateRequest> req) {
            roleGroupMenuService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:role:group:menu:update", parentPermission = "sys:role:group:menu")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody RoleGroupMenuUpdateRequest req) {
            roleGroupMenuService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:role:group:menu:delete", parentPermission = "sys:role:group:menu")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doDelete(@RequestBody RoleGroupMenuDeleteRequest req) {
        return JsonResult.succeed(roleGroupMenuService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:role:group:menu:delete", parentPermission = "sys:role:group:menu")
    @SLog(module = "permissions-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody RoleGroupMenuBatchDeleteRequest req) {
        return JsonResult.succeed(roleGroupMenuService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:list')")
    @SLog(module = "permissions-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody RoleGroupMenuFindOneByIdRequest req) {
        return JsonResult.succeed(roleGroupMenuService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody RoleGroupMenuQueryRequest req) {
        return JsonResult.succeed(roleGroupMenuService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public JsonResult data(@RequestBody RoleGroupMenuQueryRequest req) {
        return JsonResult.succeed(roleGroupMenuService.list(req));
    }


    /**
    * 启用
    */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:enable')")
    @SLog(module = "permissions-center", tag = "启用")
    public Result doEnable(@RequestBody RoleGroupMenuEnableRequest req) {
        return JsonResult.succeed(roleGroupMenuService.enable(req));
    }


    /**
    * 禁用
    */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:disable')")
    @SLog(module = "permissions-center", tag = "禁用")
    public Result doDisable(@RequestBody RoleGroupMenuDisableRequest req) {
        return JsonResult.succeed(roleGroupMenuService.disable(req));
    }




}
