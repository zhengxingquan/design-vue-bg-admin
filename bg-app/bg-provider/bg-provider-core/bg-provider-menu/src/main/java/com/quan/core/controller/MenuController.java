//package com.quan.core.controller;
//
//import com.quan.core.annotation.SLog;
//import com.quan.core.common.annotation.AutoCreateMenuAuth;
//import com.quan.core.common.constant.MenuType;
//import com.quan.core.common.web.JsonResult;
//import com.quan.core.common.web.Result;
//import com.quan.core.service.MenuService;
//import com.quan.core.controller.request.create.MenuCreateRequest;
//import com.quan.core.controller.request.update.MenuUpdateRequest;
//import com.quan.core.controller.request.del.MenuBatchDeleteRequest;
//import com.quan.core.controller.request.del.MenuDeleteRequest;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.security.access.prepost.PreAuthorize;
//
//import java.util.List;
//
///**
// * 系统菜单表
// *
// * @author ${author}
// * @email  956607644@qq.com
// * @date   2021-01-05 17:50:17
// */
//@RestController
//@RequestMapping("sys/menu")
//@Api(tags = "系统菜单管理")
//@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统菜单管理", permission = "sys:menu")
//public class MenuController {
//
//    @Autowired
//    private MenuService menuService;
//
//    /**
//     * 列表
//     */
//    @ApiOperation(value = "查询列表")
//    @PostMapping("/list")
//    @PreAuthorize("hasAnyAuthority('sys:menu:list')")
//    @SLog(module = "menu-center", tag = "查询列表")
//    public Object data(@RequestBody MenuCreateRequest req) {
//        return menuService.findAll(null);
//    }
//
//
//    /**
//     * 保存
//     */
//    @ApiOperation(value = "添加数据")
//    @PostMapping("/save")
//    @PreAuthorize("hasAnyAuthority('sys:menu:save')")
//    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:menu:save", parentPermission = "sys:menu")
//    @SLog(module = "menu-center", tag = "添加数据")
//    public Result doSave(@RequestBody MenuCreateRequest req) {
//            menuService.save(req);
//        return JsonResult.succeed("保存成功");
//    }
//
//    /**
//    * 批量添加数据
//    */
//    @ApiOperation(value = "批量添加数据")
//    @PostMapping("/batchSave")
//    @PreAuthorize("hasAnyAuthority('sys:menu:save')")
//    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:menu:save", parentPermission = "sys:menu")
//    @SLog(module = "menu-center", tag = "批量添加数据")
//    public Result doBatchSaveSave(@RequestBody List<MenuCreateRequest> req) {
//            menuService.batchSave(req);
//        return JsonResult.succeed("保存成功");
//    }
//
//    /**
//     * 修改
//     */
//    @ApiOperation(value = "编辑数据")
//    @PostMapping("/update")
//    @PreAuthorize("hasAnyAuthority('sys:menu:update')")
//    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:menu:update", parentPermission = "sys:menu")
//    @SLog(module = "menu-center", tag = "编辑数据")
//    public Result doUpdate(@RequestBody MenuUpdateRequest req) {
//            menuService.update(req);
//        return JsonResult.succeed("修改成功");
//    }
//
//    /**
//     * 删除
//     */
//    @ApiOperation(value = "删除数据")
//    @PostMapping("/delete")
//    @PreAuthorize("hasAnyAuthority('sys:menu:delete')")
//    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:menu:delete", parentPermission = "sys:menu")
//    @SLog(module = "menu-center", tag = "编辑数据")
//    public Result doDelete(@RequestBody MenuDeleteRequest req) {
//        return JsonResult.succeed(menuService.delete(req.getId()), "删除成功");
//    }
//
//    /**
//    * 批量删除
//    */
//    @ApiOperation(value = "删除数据")
//    @PostMapping("/deletes")
//    @PreAuthorize("hasAnyAuthority('sys:menu:delete')")
//    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:menu:delete", parentPermission = "sys:menu")
//    @SLog(module = "menu-center", tag = "批量编辑数据")
//    public Result doDeletes(@RequestBody MenuBatchDeleteRequest req) {
//        return JsonResult.succeed(menuService.delete(req.getIds()), "删除成功");
//    }
//
//
//    /**
//     * 查找记录
//     */
//    @ApiOperation(value = "查找记录（通过主键）")
//    @PostMapping("/findById")
//    @PreAuthorize("hasAnyAuthority('sys:menu:list')")
//    @SLog(module = "menu-center", tag = "通过主键查找记录")
//    public Result doFindById(@RequestBody MenuFindOneByIdRequest req) {
//        return JsonResult.succeed(menuService.findOneById(req.getId()));
//    }
//
//
//    /**
//     * 通过条件查找记录
//     * @param req 对象数据
//     * @return
//     */
//    @ApiOperation(value = "查找记录")
//    @PostMapping("/findByCnd")
//    @PreAuthorize("hasAnyAuthority('sys:menu:list')")
//    @SLog(module = "menu-center", tag = "通过条件查找记录")
//    public Result doFindOneByCnd(@RequestBody MenuQueryRequest req) {
//        return JsonResult.succeed(menuService.findOneByCnd(req));
//    }
//
//    /**
//     * 查找记录
//     */
//    @ApiOperation(value = "查找数据不分页")
//    @PostMapping("/query")
//    @PreAuthorize("hasAnyAuthority('sys:menu:list')")
//    @SLog(module = "menu-center", tag = "通过条件查找记录")
//    public Result data(MenuQueryRequest req) {
//        return JsonResult.succeed(menuService.list(req));
//    }
//
//
//}
