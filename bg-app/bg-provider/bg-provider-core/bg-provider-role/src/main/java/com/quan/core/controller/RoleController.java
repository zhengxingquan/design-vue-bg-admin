package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.controller.request.RoleFindOneByIdRequest;
import com.quan.core.controller.request.RolePageQueryRequest;
import com.quan.core.controller.request.RoleQueryRequest;
import com.quan.core.controller.request.create.RoleCreateRequest;
import com.quan.core.controller.request.del.RoleBatchDeleteRequest;
import com.quan.core.controller.request.del.RoleDeleteRequest;
import com.quan.core.controller.request.update.RoleUpdateRequest;
import com.quan.core.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统角色表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */
@RestController
@RequestMapping("sys/role")
@Api(tags = "角色管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "角色管理", permission = "sys:role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:role:list')")
    @SLog(module = "role-center", tag = "查询列表")
    public PageResult data(@RequestBody RolePageQueryRequest req) {
        return (PageResult) roleService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:role:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:save", parentPermission = "sys:role")
    @SLog(module = "role-center", tag = "添加数据")
    public Result doSave(@RequestBody RoleCreateRequest req, HttpServletResponse resp) {
        roleService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 批量添加数据
     */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:role:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:role:save", parentPermission = "sys:role")
    @SLog(module = "role-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<RoleCreateRequest> req) {
        roleService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:role:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:role:update", parentPermission = "sys:role")
    @SLog(module = "role-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody RoleUpdateRequest req) {
        roleService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:role:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:role:delete", parentPermission = "sys:role")
    @SLog(module = "role-center", tag = "编辑数据")
    public Result doDelete(@RequestBody RoleDeleteRequest req) {
        return JsonResult.succeed(roleService.delete(req.getId()), "删除成功");
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:role:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:role:delete", parentPermission = "sys:role")
    @SLog(module = "role-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody RoleBatchDeleteRequest req) {
        return JsonResult.succeed(roleService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:role:list')")
    @SLog(module = "role-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody RoleFindOneByIdRequest req) {
        return JsonResult.succeed(roleService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     *
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:role:list')")
    @SLog(module = "role-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody RoleQueryRequest req) {
        return JsonResult.succeed(roleService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:role:list')")
    @SLog(module = "role-center", tag = "通过条件查找记录")
    public Result data(RoleQueryRequest req) {
        return JsonResult.succeed(roleService.list(req));
    }


}
