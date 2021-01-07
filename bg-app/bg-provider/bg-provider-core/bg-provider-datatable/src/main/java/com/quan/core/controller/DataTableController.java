package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.Result;
import com.quan.core.service.DataTableService;
import com.quan.core.request.create.DataTableCreateRequest;
import com.quan.core.request.update.DataTableUpdateRequest;
import com.quan.core.request.del.DataTableBatchDeleteRequest;
import com.quan.core.request.del.DataTableDeleteRequest;
import com.quan.core.request.DataTablePageQueryRequest;
import com.quan.core.request.DataTableQueryRequest;
import com.quan.core.request.DataTableFindOneByIdRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 系统数据表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-07 23:05:24
 */
@RestController
@RequestMapping("sys/datatable")
@Api(tags = "系统数据表管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "数据表管理", permission = "sys:datatable")
public class DataTableController {

    @Autowired
    private DataTableService dataTableService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:datatable:list')")
    @SLog(module = "datatable-center", tag = "查询列表")
    public Object data(DataTablePageQueryRequest req) {
        return dataTableService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:datatable:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:datatable:save", parentPermission = "sys:datatable")
    @SLog(module = "datatable-center", tag = "添加数据")
    public Result doSave(@RequestBody DataTableCreateRequest req) {
            dataTableService.save(req);
        return Result.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:datatable:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:datatable:save", parentPermission = "sys:datatable")
    @SLog(module = "datatable-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<DataTableCreateRequest> req) {
            dataTableService.batchSave(req);
        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:datatable:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:datatable:update", parentPermission = "sys:datatable")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody DataTableUpdateRequest req) {
            dataTableService.update(req);
        return Result.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:datatable:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:datatable:delete", parentPermission = "sys:datatable")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doDelete(@RequestBody DataTableDeleteRequest req) {
        return Result.succeed(dataTableService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:datatable:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:datatable:delete", parentPermission = "sys:datatable")
    @SLog(module = "datatable-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody DataTableBatchDeleteRequest req) {
        return Result.succeed(dataTableService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:datatable:list')")
    @SLog(module = "datatable-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody DataTableFindOneByIdRequest req) {
        return Result.succeed(dataTableService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:datatable:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody DataTableQueryRequest req) {
        return Result.succeed(dataTableService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:datatable:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public Result data(DataTableQueryRequest req) {
        return Result.succeed(dataTableService.list(req));
    }


}
