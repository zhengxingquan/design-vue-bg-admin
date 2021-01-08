package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.request.*;
import com.quan.core.request.del.RoleGroupMenuGroupBatchDeleteRequest;
import com.quan.core.request.del.RoleGroupMenuGroupDeleteRequest;
import com.quan.core.request.create.RoleGroupMenuGroupCreateRequest;
import com.quan.core.request.update.RoleGroupMenuGroupUpdateRequest;
import com.quan.core.service.RoleGroupMenuGroupService;
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
 * 角色组与菜单组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:58:57
 */
@RestController
@RequestMapping("sys/role/group/menu/group")
@Api(tags = "角色组与菜单组管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "角色组与菜单组管理", permission = "sys:role:group:menu:group")
public class RoleGroupMenuGroupController {

    @Autowired
    private RoleGroupMenuGroupService roleGroupMenuGroupService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:list')")
    @SLog(module = "permissions-center", tag = "查询列表")
    public Object data(@RequestBody RoleGroupMenuGroupPageQueryRequest req) {
        return roleGroupMenuGroupService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:menu:group:save", parentPermission = "sys:role:group:menu:group")
    @SLog(module = "permissions-center", tag = "添加数据")
    public Result doSave(@RequestBody RoleGroupMenuGroupCreateRequest req) {
        roleGroupMenuGroupService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 批量添加数据
     */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:menu:group:save", parentPermission = "sys:role:group:menu:group")
    @SLog(module = "permissions-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<RoleGroupMenuGroupCreateRequest> req) {
        roleGroupMenuGroupService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:role:group:menu:group:update", parentPermission = "sys:role:group:menu:group")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody RoleGroupMenuGroupUpdateRequest req) {
        roleGroupMenuGroupService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:role:group:menu:group:delete", parentPermission = "sys:role:group:menu:group")
    @SLog(module = "permissions-center", tag = "编辑数据")
    public Result doDelete(@RequestBody RoleGroupMenuGroupDeleteRequest req) {
        return JsonResult.succeed(roleGroupMenuGroupService.delete(req.getId()), "删除成功");
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:role:group:menu:group:delete", parentPermission = "sys:role:group:menu:group")
    @SLog(module = "permissions-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody RoleGroupMenuGroupBatchDeleteRequest req) {
        return JsonResult.succeed(roleGroupMenuGroupService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:list')")
    @SLog(module = "permissions-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody RoleGroupMenuGroupFindOneByIdRequest req) {
        return JsonResult.succeed(roleGroupMenuGroupService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     *
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody RoleGroupMenuGroupQueryRequest req) {
        return JsonResult.succeed(roleGroupMenuGroupService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:list')")
    @SLog(module = "permissions-center", tag = "通过条件查找记录")
    public Result data(@RequestBody RoleGroupMenuGroupQueryRequest req) {
        return JsonResult.succeed(roleGroupMenuGroupService.list(req));
    }


    /**
     * 启用
     */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:enable')")
    @SLog(module = "permissions-center", tag = "启用")
    public Result doEnable(@RequestBody RoleGroupMenuGroupEnableRequest req) {
        return JsonResult.succeed(roleGroupMenuGroupService.enable(req));
    }


    /**
     * 禁用
     */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:role:group:menu:group:disable')")
    @SLog(module = "permissions-center", tag = "禁用")
    public Result doDisable(@RequestBody RoleGroupMenuGroupDisableRequest req) {
        return JsonResult.succeed(roleGroupMenuGroupService.disable(req));
    }


}
