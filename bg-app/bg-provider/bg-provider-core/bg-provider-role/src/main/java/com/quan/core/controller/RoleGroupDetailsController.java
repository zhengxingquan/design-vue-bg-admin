package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.controller.request.RoleGroupDetailsFindOneByIdRequest;
import com.quan.core.controller.request.RoleGroupDetailsPageQueryRequest;
import com.quan.core.controller.request.RoleGroupDetailsQueryRequest;
import com.quan.core.controller.request.create.RoleGroupDetailsCreateRequest;
import com.quan.core.controller.request.del.RoleGroupDetailsBatchDeleteRequest;
import com.quan.core.controller.request.update.RoleGroupDetailsUpdateRequest;
import com.quan.core.service.RoleGroupDetailsService;
import com.quan.core.controller.request.del.RoleGroupDetailsDeleteRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 系统角色分组与角色对应表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-07 20:21:41
 */
@RestController
@RequestMapping("sys/role/group/details")
@Api(tags = "系统角色分组与角色管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统角色分组与角色管理", permission = "sys:role:group:details")
public class RoleGroupDetailsController {

    @Autowired
    private RoleGroupDetailsService roleGroupDetailsService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:list')")
    @SLog(module = "role-center", tag = "查询列表")
    public Object data(RoleGroupDetailsPageQueryRequest req) {
        return roleGroupDetailsService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:details:save", parentPermission = "sys:role:group:details")
    @SLog(module = "role-center", tag = "添加数据")
    public Result doSave(@RequestBody RoleGroupDetailsCreateRequest req) {
            roleGroupDetailsService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:group:details:save", parentPermission = "sys:role:group:details")
    @SLog(module = "role-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<RoleGroupDetailsCreateRequest> req) {
            roleGroupDetailsService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:role:group:details:update", parentPermission = "sys:role:group:details")
    @SLog(module = "role-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody RoleGroupDetailsUpdateRequest req) {
            roleGroupDetailsService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:role:group:details:delete", parentPermission = "sys:role:group:details")
    @SLog(module = "role-center", tag = "编辑数据")
    public Result doDelete(@RequestBody RoleGroupDetailsDeleteRequest req) {
        return JsonResult.succeed(roleGroupDetailsService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:role:group:details:delete", parentPermission = "sys:role:group:details")
    @SLog(module = "role-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody RoleGroupDetailsBatchDeleteRequest req) {
        return JsonResult.succeed(roleGroupDetailsService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:list')")
    @SLog(module = "role-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody RoleGroupDetailsFindOneByIdRequest req) {
        return JsonResult.succeed(roleGroupDetailsService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:list')")
    @SLog(module = "role-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody RoleGroupDetailsQueryRequest req) {
        return JsonResult.succeed(roleGroupDetailsService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:role:group:details:list')")
    @SLog(module = "role-center", tag = "通过条件查找记录")
    public Result data(RoleGroupDetailsQueryRequest req) {
        return JsonResult.succeed(roleGroupDetailsService.list(req));
    }


}
