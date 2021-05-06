package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.controller.request.create.RoleGroupCreateRequest;
import com.quan.core.controller.request.del.RoleGroupBatchDeleteRequest;
import com.quan.core.controller.request.RoleGroupFindOneByIdRequest;
import com.quan.core.controller.request.RoleGroupPageQueryRequest;
import com.quan.core.controller.request.RoleGroupQueryRequest;
import com.quan.core.controller.request.del.RoleGroupDeleteRequest;
import com.quan.core.controller.request.update.RoleGroupUpdateRequest;
import com.quan.core.service.RoleGroupService;
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
 * 系统角色分组表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:07:02
 */
@RestController
@RequestMapping("sys/role/group")
@Api(tags = "系统角色分组管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统角色分组管理", permission = "sys:role:group")
public class RoleGroupController {

    @Autowired
    private RoleGroupService roleGroupService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:role:group:list')")
    @SLog(module = "role-center", tag = "查询列表")
    public Object data(RoleGroupPageQueryRequest req) {
        return roleGroupService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:role:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:save", parentPermission = "sys:role:group")
    @SLog(module = "role-center", tag = "添加数据")
    public Result doSave(@RequestBody RoleGroupCreateRequest req) {
        roleGroupService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 批量添加数据
     */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:role:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:save", parentPermission = "sys:role:group")
    @SLog(module = "role-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<RoleGroupCreateRequest> req) {
        roleGroupService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:role:group:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:role:group:update", parentPermission = "sys:role:group")
    @SLog(module = "role-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody RoleGroupUpdateRequest req) {
        roleGroupService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:role:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:role:group:delete", parentPermission = "sys:role:group")
    @SLog(module = "role-center", tag = "编辑数据")
    public Result doDelete(@RequestBody RoleGroupDeleteRequest req) {
        return JsonResult.succeed(roleGroupService.delete(req.getId()), "删除成功");
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:role:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:role:group:delete", parentPermission = "sys:role:group")
    @SLog(module = "role-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody RoleGroupBatchDeleteRequest req) {
        return JsonResult.succeed(roleGroupService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:role:group:list')")
    @SLog(module = "role-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody RoleGroupFindOneByIdRequest req) {
        return JsonResult.succeed(roleGroupService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     *
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:role:group:list')")
    @SLog(module = "role-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody RoleGroupQueryRequest req) {
        return JsonResult.succeed(roleGroupService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:role:group:list')")
    @SLog(module = "role-center", tag = "通过条件查找记录")
    public Result data(RoleGroupQueryRequest req) {
        return JsonResult.succeed(roleGroupService.list(req));
    }


}
