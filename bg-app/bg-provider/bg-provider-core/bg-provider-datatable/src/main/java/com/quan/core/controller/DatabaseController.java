package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.service.DatabaseService;
import com.quan.core.controller.request.create.DatabaseCreateRequest;
import com.quan.core.controller.request.update.DatabaseUpdateRequest;
import com.quan.core.controller.request.del.DatabaseBatchDeleteRequest;
import com.quan.core.controller.request.del.DatabaseDeleteRequest;
import com.quan.core.controller.request.DatabasePageQueryRequest;
import com.quan.core.controller.request.DatabaseQueryRequest;
import com.quan.core.controller.request.DatabaseFindOneByIdRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 系统数据仓库表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-07 22:12:27
 */
@RestController
@RequestMapping("sys/database")
@Api(tags = "系统数据仓库管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统数据表管理", permission = "sys:database")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:database:list')")
    @SLog(module = "datatable-center", tag = "查询列表")
    public Object data(DatabasePageQueryRequest req) {
        return databaseService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:database:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:database:save", parentPermission = "sys:database")
    @SLog(module = "datatable-center", tag = "添加数据")
    public Result doSave(@RequestBody DatabaseCreateRequest req) {
            databaseService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:database:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:database:save", parentPermission = "sys:database")
    @SLog(module = "datatable-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<DatabaseCreateRequest> req) {
            databaseService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:database:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:database:update", parentPermission = "sys:database")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody DatabaseUpdateRequest req) {
            databaseService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:database:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:database:delete", parentPermission = "sys:database")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doDelete(@RequestBody DatabaseDeleteRequest req) {
        return JsonResult.succeed(databaseService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:database:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:database:delete", parentPermission = "sys:database")
    @SLog(module = "datatable-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody DatabaseBatchDeleteRequest req) {
        return JsonResult.succeed(databaseService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:database:list')")
    @SLog(module = "datatable-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody DatabaseFindOneByIdRequest req) {
        return JsonResult.succeed(databaseService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:database:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody DatabaseQueryRequest req) {
        return JsonResult.succeed(databaseService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:database:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public Result data(DatabaseQueryRequest req) {
        return JsonResult.succeed(databaseService.list(req));
    }


}
