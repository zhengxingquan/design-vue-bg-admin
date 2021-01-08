package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.request.MenuGroupDetailsFindOneByIdRequest;
import com.quan.core.request.MenuGroupDetailsPageQueryRequest;
import com.quan.core.request.MenuGroupDetailsQueryRequest;
import com.quan.core.request.create.MenuGroupDetailsCreateRequest;
import com.quan.core.request.del.MenuGroupDetailsBatchDeleteRequest;
import com.quan.core.request.del.MenuGroupDetailsDeleteRequest;
import com.quan.core.request.update.MenuGroupDetailsUpdateRequest;
import com.quan.core.service.MenuGroupDetailsService;
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
 * 系统菜单分组与菜单对应表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 18:49:57
 */
@RestController
@RequestMapping("sys/menu/group/details")
@Api(tags = "系统菜单分组与菜单管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统菜单分组与菜单管理", permission = "sys:menu:group:details")
public class MenuGroupDetailsController {

    @Autowired
    private MenuGroupDetailsService menuGroupDetailsService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:list')")
    @SLog(module = "menu-center", tag = "查询列表")
    public Object data(MenuGroupDetailsPageQueryRequest req) {
        return menuGroupDetailsService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:menu:group:details:save", parentPermission = "sys:menu:group:details")
    @SLog(module = "menu-center", tag = "添加数据")
    public Result doSave(@RequestBody MenuGroupDetailsCreateRequest req) {
        menuGroupDetailsService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 批量添加数据
     */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:menu:group:details:save", parentPermission = "sys:menu:group:details")
    @SLog(module = "menu-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<MenuGroupDetailsCreateRequest> req) {
        menuGroupDetailsService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:menu:group:details:update", parentPermission = "sys:menu:group:details")
    @SLog(module = "menu-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody MenuGroupDetailsUpdateRequest req) {
        menuGroupDetailsService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:menu:group:details:delete", parentPermission = "sys:menu:group:details")
    @SLog(module = "menu-center", tag = "编辑数据")
    public Result doDelete(@RequestBody MenuGroupDetailsDeleteRequest req) {
        return JsonResult.succeed(menuGroupDetailsService.delete(req.getId()), "删除成功");
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:menu:group:details:delete", parentPermission = "sys:menu:group:details")
    @SLog(module = "menu-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody MenuGroupDetailsBatchDeleteRequest req) {
        return JsonResult.succeed(menuGroupDetailsService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:list')")
    @SLog(module = "menu-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody MenuGroupDetailsFindOneByIdRequest req) {
        return JsonResult.succeed(menuGroupDetailsService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     *
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:list')")
    @SLog(module = "menu-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody MenuGroupDetailsQueryRequest req) {
        return JsonResult.succeed(menuGroupDetailsService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:menu:group:details:list')")
    @SLog(module = "menu-center", tag = "通过条件查找记录")
    public Result data(MenuGroupDetailsQueryRequest req) {
        return JsonResult.succeed(menuGroupDetailsService.list(req));
    }


}
