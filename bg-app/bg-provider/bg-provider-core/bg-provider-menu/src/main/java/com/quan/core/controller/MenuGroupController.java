package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.service.MenuGroupService;
import com.quan.core.controller.request.create.MenuGroupCreateRequest;
import com.quan.core.controller.request.update.MenuGroupUpdateRequest;
import com.quan.core.controller.request.del.MenuGroupBatchDeleteRequest;
import com.quan.core.controller.request.del.MenuGroupDeleteRequest;
import com.quan.core.controller.request.MenuGroupPageQueryRequest;
import com.quan.core.controller.request.MenuGroupQueryRequest;
import com.quan.core.controller.request.MenuGroupFindOneByIdRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 系统菜单表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-05 18:42:13
 */
@RestController
@RequestMapping("sys/menu/group")
@Api(tags = "系统菜单分组管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统菜单分组管理", permission = "sys:menu:group")
public class MenuGroupController {

    @Autowired
    private MenuGroupService menuGroupService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:list')")
    @SLog(module = "menu-center", tag = "查询列表")
    public Object data(MenuGroupPageQueryRequest req) {
        return menuGroupService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:menu:group:save", parentPermission = "sys:menu:group")
    @SLog(module = "menu-center", tag = "添加数据")
    public Result doSave(@RequestBody MenuGroupCreateRequest req) {
            menuGroupService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:menu:group:save", parentPermission = "sys:menu:group")
    @SLog(module = "menu-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<MenuGroupCreateRequest> req) {
            menuGroupService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:menu:group:update", parentPermission = "sys:menu:group")
    @SLog(module = "menu-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody MenuGroupUpdateRequest req) {
            menuGroupService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:menu:group:delete", parentPermission = "sys:menu:group")
    @SLog(module = "menu-center", tag = "编辑数据")
    public Result doDelete(@RequestBody MenuGroupDeleteRequest req) {
        return JsonResult.succeed(menuGroupService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:menu:group:delete", parentPermission = "sys:menu:group")
    @SLog(module = "menu-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody MenuGroupBatchDeleteRequest req) {
        return JsonResult.succeed(menuGroupService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:list')")
    @SLog(module = "menu-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody MenuGroupFindOneByIdRequest req) {
        return JsonResult.succeed(menuGroupService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:list')")
    @SLog(module = "menu-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody MenuGroupQueryRequest req) {
        return JsonResult.succeed(menuGroupService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:list')")
    @SLog(module = "menu-center", tag = "通过条件查找记录")
    public Result data(MenuGroupQueryRequest req) {
        return JsonResult.succeed(menuGroupService.list(req));
    }


}
